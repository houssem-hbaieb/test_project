package com.example.test.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "prestataire")
public class Prestataire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeP ;

    private String nomP;

    private String prenomP;

    private String adresse ;

    private String numcpte ;

    private String agence ;

    private Date dateFiscale ;

    private String EmailP ;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TypePrestation typeP;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "num_ctx", referencedColumnName = "num_ctx"),
            @JoinColumn(name = "cod_strc_ctx", referencedColumnName = "cod_strc_ctx")
    })
    private DebiteurCtx debiteurCtx;






}
