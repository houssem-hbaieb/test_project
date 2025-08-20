package com.example.test.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RisqueCtxDTO {
    private Long codeRisqueCtx;
    private Integer numRisqueCtx;
    private String numContratCompteCtx;
    private Integer codeAgenceCtx;
    private Double montantPrincipalEntreCtx;
    private Double soldePrincipalCtx;
    private Date dateArreteCtx;
    private Integer numCtx;
    private Integer codeStructureCtx;
}
