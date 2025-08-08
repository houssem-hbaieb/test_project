package com.example.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebiteurCtxDTO implements Serializable {

    private Integer numCtx;
    private Integer codeStructureCtx;

    private String etatCtx;
    private String sortCtx;
    private String motifSortCtx;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    private Date dateTransfertCtx;

    private Double soldeRecouvrementCtx;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    private Date dateClotureCtx;

    private String motifClotureCtx;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    private Date dateCreationCtx;

    private Integer matriculeCreationCtx;
    private Date dateMajCtx;
    private Integer matriculeMajCtx;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    private Date dateDecisionCtx;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    private Date dateReceptionDossier;

    private Long departementId;
    private Long divisionId;
    private int userId;



}
