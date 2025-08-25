package com.example.test.dto;

import com.example.test.Models.DebiteurCtx;
import com.example.test.Models.Prestataire;
import com.example.test.Models.TypePrestation;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrestataireDTO {

    private Long id;
    private String codeP;
    private String nomP;
    private String prenomP;
    private String adresse;
    private String numcpte;
    private String agence;
    private Date dateFiscale;
    private String emailP;
    private TypePrestation typeP;

    private Integer numCtx;
    private Integer codeStructureCtx;

    public static PrestataireDTO fromEntity(Prestataire prestataire) {
        if (prestataire == null) {
            return null;
        }

        Integer numCtx = null;
        Integer codeStructureCtx = null;
        if (prestataire.getDebiteurCtx() != null) {
            numCtx = prestataire.getDebiteurCtx().getNumCtx();
            codeStructureCtx = prestataire.getDebiteurCtx().getCodeStructureCtx();
        }

        return PrestataireDTO.builder()
                .id(prestataire.getId())
                .codeP(prestataire.getCodeP())
                .nomP(prestataire.getNomP())
                .prenomP(prestataire.getPrenomP())
                .adresse(prestataire.getAdresse())
                .numcpte(prestataire.getNumcpte())
                .agence(prestataire.getAgence())
                .dateFiscale(prestataire.getDateFiscale())
                .emailP(prestataire.getEmailP())
                .typeP(prestataire.getTypeP())
                .numCtx(numCtx)
                .codeStructureCtx(codeStructureCtx)
                .build();
    }

    public static Prestataire toEntity(PrestataireDTO dto, DebiteurCtx debiteur) {
        if (dto == null) {
            return null;
        }

        return Prestataire.builder()
                .id(dto.getId())
                .codeP(dto.getCodeP())
                .nomP(dto.getNomP())
                .prenomP(dto.getPrenomP())
                .EmailP(dto.getEmailP())
                .adresse(dto.getAdresse())
                .numcpte(dto.getNumcpte())
                .agence(dto.getAgence())
                .dateFiscale(dto.getDateFiscale())
                .typeP(dto.getTypeP())
                .debiteurCtx(debiteur)
                .build();
    }
}

