package com.example.test.Services.impl;

import com.example.test.Models.DebiteurCtx;
import com.example.test.Models.Departement;
import com.example.test.Models.Division;
import com.example.test.Models.User;
import com.example.test.Repositories.DebiteurRepository;
import com.example.test.Repositories.DepartementRepository;
import com.example.test.Repositories.DivisionRepository;
import com.example.test.Repositories.UserRepository;
import com.example.test.Services.DebiteurService;
import com.example.test.dto.DebiteurCtxDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DebiteurCtxServiceImpl implements DebiteurService {

    private final DebiteurRepository debiteurCtxRepository;
    private final DepartementRepository departementRepository;
    private final DivisionRepository divisionRepository;
    private final UserRepository userRepository;


    private DebiteurCtxDTO toDTO(DebiteurCtx entity) {
        return DebiteurCtxDTO.builder()
                .numCtx(entity.getNumCtx())
                .codeStructureCtx(entity.getCodeStructureCtx())
                .etatCtx(entity.getEtatCtx())
                .sortCtx(entity.getSortCtx())
                .motifSortCtx(entity.getMotifSortCtx())
                .dateTransfertCtx(entity.getDateTransfertCtx())
                .soldeRecouvrementCtx(entity.getSoldeRecouvrementCtx())
                .dateClotureCtx(entity.getDateClotureCtx())
                .motifClotureCtx(entity.getMotifClotureCtx())
                .dateCreationCtx(entity.getDateCreationCtx())
                .matriculeCreationCtx(entity.getMatriculeCreationCtx())
                .dateMajCtx(entity.getDateMajCtx())
                .matriculeMajCtx(entity.getMatriculeMajCtx())
                .dateDecisionCtx(entity.getDateDecisionCtx())
                .dateReceptionDossier(entity.getDateReceptionDossier())
                .departementId(entity.getDepartement() != null ? entity.getDepartement().getId() : null)
                .divisionId(entity.getDivision() != null ? entity.getDivision().getId() : null)
                .userId(entity.getUser() != null && entity.getUser().getId() != null ? entity.getUser().getId() : 0) // Default to 0 if null
                .build();
    }

    private DebiteurCtx toEntity(DebiteurCtxDTO dto) {
        DebiteurCtx entity = new DebiteurCtx();
        entity.setCodeStructureCtx(dto.getCodeStructureCtx());
        entity.setEtatCtx(dto.getEtatCtx());
        entity.setSortCtx(dto.getSortCtx());
        entity.setMotifSortCtx(dto.getMotifSortCtx());
        entity.setDateTransfertCtx(dto.getDateTransfertCtx());
        entity.setSoldeRecouvrementCtx(dto.getSoldeRecouvrementCtx());
        entity.setDateClotureCtx(dto.getDateClotureCtx());
        entity.setMotifClotureCtx(dto.getMotifClotureCtx());
        entity.setDateCreationCtx(dto.getDateCreationCtx());
        entity.setMatriculeCreationCtx(dto.getMatriculeCreationCtx());
        entity.setDateMajCtx(dto.getDateMajCtx());
        entity.setMatriculeMajCtx(dto.getMatriculeMajCtx());
        entity.setDateDecisionCtx(dto.getDateDecisionCtx());
        entity.setDateReceptionDossier(dto.getDateReceptionDossier());

        if (dto.getDepartementId() != null) {
            entity.setDepartement(departementRepository.findById(dto.getDepartementId())
                    .orElseThrow(() -> new RuntimeException("Departement not found")));
        }
        if (dto.getDivisionId() != null) {
            entity.setDivision(divisionRepository.findById(dto.getDivisionId())
                    .orElseThrow(() -> new RuntimeException("Division not found")));
        }


        return entity;
    }


    @Override
    public DebiteurCtxDTO create(DebiteurCtxDTO dto) {

        DebiteurCtx entity = toEntity(dto);
        return toDTO(debiteurCtxRepository.save(entity));
    }

    @Override
    public List<DebiteurCtxDTO> getAll() {
        return debiteurCtxRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DebiteurCtxDTO getById(Integer id) {
        return debiteurCtxRepository.findByNumCtx(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("DebiteurCtx not found"));
    }

    @Override
    public DebiteurCtxDTO update(Integer id, DebiteurCtxDTO dto) {
        DebiteurCtx existing = debiteurCtxRepository.findByNumCtx(id)
                .orElseThrow(() -> new RuntimeException("DebiteurCtx not found"));
        DebiteurCtx updated = toEntity(dto);
        updated.setNumCtx(existing.getNumCtx());
        return toDTO(debiteurCtxRepository.save(updated));
    }
    @Override
    public DebiteurCtx affecterDossierADepartement(Integer numCtx, Long departementId) {
        DebiteurCtx dossier = debiteurCtxRepository.findByNumCtx(numCtx)
                .orElseThrow(() -> new RuntimeException("Dossier introuvable"));

        Departement dep = departementRepository.findById(departementId)
                .orElseThrow(() -> new RuntimeException("Département introuvable"));

        dossier.setDepartement(dep);
        return debiteurCtxRepository.save(dossier);
    }
    @Override
    public DebiteurCtx affecterDossierADivision(Integer numCtx, Long divisionId) {
        DebiteurCtx dossier = debiteurCtxRepository.findByNumCtx(numCtx)
                .orElseThrow(() -> new RuntimeException("Dossier introuvable"));

        if (dossier.getDepartement() == null) {
            throw new RuntimeException("Impossible d'affecter à une division : le dossier n'est pas encore affecté à un département");
        }

        Division div = divisionRepository.findById(divisionId)
                .orElseThrow(() -> new RuntimeException("Division introuvable"));

        dossier.setDivision(div);
        return debiteurCtxRepository.save(dossier);
    }

    @Override
    public DebiteurCtx affecterDossierAUser(Integer numCtx, Integer userId) {
        DebiteurCtx dossier = debiteurCtxRepository.findByNumCtx(numCtx)
                .orElseThrow(() -> new RuntimeException("Dossier introuvable"));

        if (dossier.getDepartement() == null) {
            throw new RuntimeException("Impossible d'affecter un utilisateur : le dossier n'est pas encore affecté à un département");
        }

        if (dossier.getDivision() == null) {
            throw new RuntimeException("Impossible d'affecter un utilisateur : le dossier n'est pas encore affecté à une division");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        if(user.getAuthorities().stream().noneMatch(auth -> auth.getAuthority().equals("ROLE_CHARGEE"))) {
            throw new RuntimeException("L'utilisateur n'a pas le rôle approprié pour être affecté à ce dossier");
        }

        dossier.setUser(user);
        return debiteurCtxRepository.save(dossier);
    }

    @Override
    public List<DebiteurCtxDTO> getByDepartementId(Long departementId) {
        return debiteurCtxRepository.findByDepartementId(departementId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DebiteurCtxDTO> getByDivisionId(Long divisionId) {
        return debiteurCtxRepository.findByDivisionId(divisionId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DebiteurCtxDTO> getDebiteursByUserId(Integer userId) {
        return debiteurCtxRepository.findByUserId(userId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());    }

}
