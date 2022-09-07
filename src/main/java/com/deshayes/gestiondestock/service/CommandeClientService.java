package com.deshayes.gestiondestock.service;

import com.deshayes.gestiondestock.dto.CommandeClientDto;
import com.deshayes.gestiondestock.dto.LigneCommandeClientDto;
import com.deshayes.gestiondestock.exception.EntityNotFoundException;
import com.deshayes.gestiondestock.exception.ErrorCodes;
import com.deshayes.gestiondestock.exception.InvalideEntityException;
import com.deshayes.gestiondestock.model.Article;
import com.deshayes.gestiondestock.model.Client;
import com.deshayes.gestiondestock.model.CommandeClient;
import com.deshayes.gestiondestock.model.LigneCommandeClient;
import com.deshayes.gestiondestock.repository.ArticleRepository;
import com.deshayes.gestiondestock.repository.ClientRepository;
import com.deshayes.gestiondestock.repository.CommandeClientRepository;
import com.deshayes.gestiondestock.repository.LigneCommandeClientRepository;
import com.deshayes.gestiondestock.service.Iservice.ICommandeClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientService implements ICommandeClientService {

    @Autowired
    private CommandeClientRepository cmdClientRepo;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LigneCommandeClientRepository ligneCmdClientRepo;
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = LigneCommandeClientValidator.validate(dto);

        if(!errors.isEmpty()){
            log.error("Il y a des erreurs",errors);
            throw new InvalideEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,errors);
        }

        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isEmpty()){
          log.warn("Le client avec l'id " + dto.getClient().getId() + "n'as pas était trouver");
          throw  new EntityNotFoundException("Aucun client avec l'ID "+ dto.getClient().getId() + "n'a était trouver",ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommandeClients() != null){
            dto.getLigneCommandeClients().stream()
                    .forEach(ligneCommandeClient -> {
                        if (ligneCommandeClient.getArticle() != null){
                            Optional<Article> article = articleRepository.findById(ligneCommandeClient.getArticle().getId());
                            if (article.isEmpty()){
                                articleErrors.add("l'article avec l'ID " + ligneCommandeClient.getArticle().getId() + " n'existe pas ");
                            }
                        }
                    });
        }

        if (!articleErrors.isEmpty()){
            log.warn(" ");
            throw new InvalideEntityException("Article n'existe pas dans la BDD",ErrorCodes.ARTICLES_NOT_FOUND,articleErrors);
        }

        CommandeClient savedCmdClt = cmdClientRepo.save(CommandeClientDto.toEntity(dto));

        dto.getLigneCommandeClients().forEach(ligneCmdClient -> {
            LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(LigneCommandeClientDto.fromEntity(ligneCmdClient));
            ligneCommandeClient.setCommandeClient(savedCmdClt);
            ligneCmdClientRepo.save(ligneCommandeClient);
                }
        );
        return CommandeClientDto.fromEntity(savedCmdClt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if (id == null){
            log.error("l'ID est null");
            return null;
        }

        Optional<CommandeClient> cmdClient = cmdClientRepo.findById(id);
        CommandeClientDto dto = CommandeClientDto.fromEntity(cmdClient.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucune commande client n'a était trouver avec l'ID " + id,
                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if (!StringUtils.hasText(code)){
            log.error("le code est null");
            return null;
        }

        Optional<CommandeClient> cmdClient = cmdClientRepo.findCommandeClientByCode(code);
        CommandeClientDto dto = CommandeClientDto.fromEntity(cmdClient.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucune commande client n'a était trouver avec le code " + code,
                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));

    }

    @Override
    public List<CommandeClientDto> findAll() {
        return cmdClientRepo.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("l'id est null");
            return;
        }

        cmdClientRepo.deleteById(id);
    }
}
