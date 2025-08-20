package com.example.test.Mapper;

import com.example.test.Models.DebiteurCtxId;
import com.example.test.Models.RisqueCtx;
import com.example.test.Repositories.DebiteurRepository;
import com.example.test.dto.RisqueCtxDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RisqueMapper {

    private final DebiteurRepository debiteurRepository;

    public  RisqueCtx toEntity(RisqueCtxDTO dto) {
        RisqueCtx risque = new RisqueCtx();
        risque.setCodeRisqueCtx(dto.getCodeRisqueCtx());
        risque.setNumRisqueCtx(dto.getNumRisqueCtx());
        risque.setNumContratCompteCtx(dto.getNumContratCompteCtx());
        risque.setCodeAgenceCtx(dto.getCodeAgenceCtx());
        risque.setMontantPrincipalEntreCtx(dto.getMontantPrincipalEntreCtx());
        risque.setSoldePrincipalCtx(dto.getSoldePrincipalCtx());
        risque.setDateArreteCtx(dto.getDateArreteCtx());
        if (dto.getNumCtx() != null && dto.getCodeStructureCtx() != null) {
            DebiteurCtxId debiteurId = new DebiteurCtxId(dto.getNumCtx(), dto.getCodeStructureCtx());
            risque.setDebiteurCtx(debiteurRepository.findById(debiteurId).orElse(null));
        }
        return risque;
    }

    public RisqueCtxDTO toDTO(RisqueCtx entity) {
        RisqueCtxDTO dto = new RisqueCtxDTO();
        dto.setCodeRisqueCtx(entity.getCodeRisqueCtx());
        dto.setNumRisqueCtx(entity.getNumRisqueCtx());
        dto.setNumContratCompteCtx(entity.getNumContratCompteCtx());
        dto.setCodeAgenceCtx(entity.getCodeAgenceCtx());
        dto.setMontantPrincipalEntreCtx(entity.getMontantPrincipalEntreCtx());
        dto.setSoldePrincipalCtx(entity.getSoldePrincipalCtx());
        dto.setDateArreteCtx(entity.getDateArreteCtx());

        if (entity.getDebiteurCtx() != null) {
            dto.setNumCtx(entity.getDebiteurCtx().getNumCtx());
            dto.setCodeStructureCtx(entity.getDebiteurCtx().getCodeStructureCtx());
        }

        return dto;
    }


}
