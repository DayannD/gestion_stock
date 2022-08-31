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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            ligneCmdClient = LigneCommandeClientDto.toEntity(ligneCmdClient);
            ligneCmdClient.setCommandeClient(savedCmdClt);
            ligneCmdClientRepo.save()
                }
        );

    }

    @Override
    public CommandeClientDto findById(Integer id) {
        return null;
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return null;
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
