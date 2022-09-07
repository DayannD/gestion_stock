package com.deshayes.gestiondestock.service;

import com.deshayes.gestiondestock.dto.CommandeClientDto;
import com.deshayes.gestiondestock.dto.CommandeFournisseurDto;
import com.deshayes.gestiondestock.dto.LigneCommandeClientDto;
import com.deshayes.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.deshayes.gestiondestock.exception.EntityNotFoundException;
import com.deshayes.gestiondestock.exception.ErrorCodes;
import com.deshayes.gestiondestock.exception.InvalideEntityException;
import com.deshayes.gestiondestock.model.*;
import com.deshayes.gestiondestock.repository.*;
import com.deshayes.gestiondestock.service.Iservice.ICommandeFournisseurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurService implements ICommandeFournisseurService {

    @Autowired
    private CommandeFournisseurRepository cmdFourRepo;

    @Autowired
    private FournisseurRepository fourRepo;

    @Autowired
    private LigneCommandeFournisseurRepository lgnCmdfourRepo;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = LigneCommandeFournisseur.validate(dto);
        if (errors.isEmpty()){
            log.error("il y a des erreurs",errors);
            throw new InvalideEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,errors);
        }

        Optional<Fournisseur> fournisseur = fourRepo.findById(dto.getFournisseur().getId());
        if (!fournisseur.isEmpty()){
            log.warn("Le fournisseur avec l'id" + dto.getFournisseur().getId() + "n'as pas était trouver");
            throw new EntityNotFoundException("Aucun client avec l'ID "+ dto.getFournisseur().getId() + "n'a était trouver",ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommandeFournisseurs() != null){
            dto.getLigneCommandeFournisseurs().stream()
                    .forEach(ligneCommandeFournisseur -> {
                        if (ligneCommandeFournisseur.getArticle() != null){
                            Optional<Article> article = articleRepository.findById(ligneCommandeFournisseur.getArticle().getId());
                            if (article.isEmpty()){
                                articleErrors.add("l'article avec l'ID " + ligneCommandeFournisseur.getArticle().getId() + " n'existe pas ");
                            }
                        }
                    });
        }

        if (!articleErrors.isEmpty()){
            log.warn("");
            throw new InvalideEntityException("Article n'existe pas dans la BDD",ErrorCodes.ARTICLES_NOT_FOUND,articleErrors);
        }

        CommandeFournisseur savedCmdfrnr = cmdFourRepo.save(CommandeFournisseurDto.toEntity(dto));

        dto.getLigneCommandeFournisseurs().forEach(ligneCmdFourn -> {
            LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(LigneCommandeFournisseurDto.fromEntity(ligneCmdFourn));
            ligneCommandeFournisseur.setCommandeFournisseur(savedCmdfrnr);
            lgnCmdfourRepo.save(ligneCommandeFournisseur);
        });

        return CommandeFournisseurDto.fromEntity(savedCmdfrnr);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if (id == null){
            log.error("l'id est null");
            return null;
        }
        Optional<CommandeFournisseur> commandeFournisseur = cmdFourRepo.findById(id);
        CommandeFournisseurDto dto = CommandeFournisseurDto.fromEntity(commandeFournisseur.get());

        return Optional.of(dto).orElseThrow(() ->
            new EntityNotFoundException("La commande n'as pas était trouver ",ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if (!StringUtils.hasText(code)){
            log.error("le code" + code + " est null");
            return null;
        }

        Optional<CommandeFournisseur> commandeFournisseur = cmdFourRepo.findCommandeFournisseurByCode(code);
        CommandeFournisseurDto dto = CommandeFournisseurDto.fromEntity(commandeFournisseur.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("la commande fournisseur avec le code " + code + " n'as pas était trouver",ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
                );
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {

        return cmdFourRepo.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("l'id est null");
            return;
        }
    }
}
