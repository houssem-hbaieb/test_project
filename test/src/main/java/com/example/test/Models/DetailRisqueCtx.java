package com.example.test.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Detail_Risq_CTX")

public class DetailRisqueCtx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_eff_ctx", unique = true, nullable = false)
    @Comment("numéro d’effet")
    private Long numEffCtx;

    @Column(name = "mnt_p_ctx")
    @Comment("Montant principal")
    private Double montantPrincipalCtx;

    @Column(name = "mnt_ii_ctx")
    @Comment("Montant intercalaire")
    private Double montantIICtx;

    @Column(name = "mnt_ic_ctx")
    @Comment("Montant intéret conventionnel")
    private Double montantICCtx;

    @Column(name = "mnt_ic_rest_ctx")
    @Comment("Montant intéret conventionnel restant de l'effet")
    private Double montantICRestanttx = montantIICtx;

    @Column(name = "mnt_frais_ctx")
    @Comment("Montant des frais")
    private Double montantFraisCtx;

    @Column(name = "date_ech_ctx")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Temporal(TemporalType.DATE)
    @Comment("date d échéance")
    private Date dateEcheanceCtx;

    // EPS

    @Column(name = "benif_eps_ctx")
    @Comment("maitre œuvre (bénéficiaire de lEPS)")
    private String benifEpsCtx;

    @Column(name = "mnt_marge_gar_eps_ctx")
    @Comment("montant marge garantie de l EPS")
    private Double montantMargeGarantieEpsCtx;

    @Column(name = "mnt_marge_gar_eps_rest_ctx")
    @Comment("montant marge garantie de l EPS restant")
    private Double montantMargeGarantieRestantEps = 0.0;

    @Column(name = "mnt_depot_eps_ctx")
    @Comment("montant depot affecté de l EPS")
    private Double montantDepotEpsCtx;

    @Column(name = "mnt_rest_eps")
    @Comment("montant restant eps")
    private Double montantRestantEpsCtx;

    @Column(name = "num_cred_eps")
    @Comment("Numéro de credit Eps : Saeb")
    private String NumCreditEps;

//
//	@Column(name = "mnt_p_eps_rest")
//	@Comment("Montant principal restant  : MEJ partielle")
//	private Double montantPrincipalEpsRestant;

    @Column(name = "date_ech_marche_eps_ctx")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Temporal(TemporalType.DATE)
    @Comment("date échéance du marché")
    private Date dateEcheanceMarcheEpsCtx;

    @Column(name = "ref_marche_eps_ctx")
    @Comment("Référence du  marché EPS")
    private String refMarcheEpsCtx;

    @Column(name = "obj_marche_eps_ctx")
    @Comment("objet du  marché de l EPS")
    private String objetMarcheEpsCtx;

    @Column(name = "mnt_marche_eps_ctx")
    @Comment("Montant du  marché de l EPS")
    private Double montantMarcheEpsCtx;

    @Column(name = "type_marche_eps_ctx")
    @Comment("type du  marché de l EPS")
    private String typeMarcheEpsCtx;

    @Column(name = "lieu_marche_eps_ctx")
    @Comment("lieu réalisation du marché de l EPS")
    private String lieuMarcheEpsCtx;

    @Column(name = "sort_eps_ctx")
    @Comment("sort eps (apurement ; mise en jeu ..)")
    private String sortEpsCtx;

    // tiré

    @Column(name = "num_eff_tire_ctx", columnDefinition = "NUMBER(12,0)")
    @Comment("numéro d’effet escompté")
    private Long numEffetTireCtx;

    @Column(name = "sort_eff_tire_ctx")
    @Comment("sort effet à échoir")
    private String sortEffetTireCtx;

    @Column(name = "date_sort_eff_tire_ctx")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Temporal(TemporalType.DATE)
    @Comment("date du sort effet à échoir")
    private Date dateSortEffetTireCtx;

    @Column(name = "date_recep_eff_ctx")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Temporal(TemporalType.DATE)
    @Comment("Date réception physique de l’effet")
    private Date dateReceptionEffCtx;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Comment("Clé étrangère: RisqueCTX")
    @JoinColumn(name = "cod_risq_ctx", referencedColumnName = "cod_risq_ctx")
    private RisqueCtx risqueCtx;

}
