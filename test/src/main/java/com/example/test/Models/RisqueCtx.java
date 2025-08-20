package com.example.test.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "risque_ctx")
public class RisqueCtx {

    private static final long serialVersionUID = -8234741148184594993L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_risq_ctx", unique = true, nullable = false)
    @Comment("Identifiant unique du risque")
    private Long codeRisqueCtx;

    @Column(name = "num_risq_ctx", nullable = false)
    @Comment("N° de risque par client")
    private Integer numRisqueCtx;

    @Column(name = "num_ccpt_ctx", length = 13)
    @Comment("Numéro du compte du débiteur")
    private String numContratCompteCtx;

    @Column(name = "np_ctx", length = 10)
    @Comment("Numéro permanent dédié à l agricole")
    private String numPermanentCtx;

    @Column(name = "ref_gar_ctx", length = 10)
    @Comment("Référence de garantie")
    private String referenceGarantieCtx;

    @Column(name = "cod_agence_ctx")
    @Comment("Code de l agence du risque ")
    private Integer codeAgenceCtx;

    @Column(name = "risq_cible_ctx")
    @Comment("Numéro du risque cible : cas BNA BUDGET")
    private Integer risqueCibleCtx;

    @Column(name = "terme_ctx")
    @Comment("1 CT, 2 MT, 3 LT ")
    private Integer termeCtx;

    @Column(name = "date_transfert_ctx")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Temporal(TemporalType.DATE)
    @Comment("Date du transfert du risque")
    private Date dateTransfertRisqueCtx;

    @Column(name = "mnt_p_entre_ctx")
    @Comment("MONTANT PRINCIPAL D ENTREE EN CTX")
    private Double montantPrincipalEntreCtx;

    @Column(name = "mnt_ic_entre_ctx")
    @Comment("MONTANT DES IC A L ENTREE EN CTX")
    private Double montantICEntreCtx;

    @Column(name = "mnt_ii_entre_ctx")
    @Comment("MONTANT DES II A L ENTREE EN CTX")
    private Double montantIIEntreCtx;

    @Column(name = "solde_p_ctx")
    @Comment("SOLDE EN PRINCIPAL")
    private Double soldePrincipalCtx;

    @Column(name = "solde_ic_ctx")
    @Comment("SOLDE EN INTERETS CONVENTIONNELS")
    private Double soldeICCtx;

    @Column(name = "solde_ir_ctx")
    @Comment("SOLDE EN INTERETS DE RETARD")
    private Double soldeIRCtx;

    @Column(name = "mnt_ir_ctx")
    @Comment("MONTANT DES IR")
    private Double montantIRCtx;

    @Column(name = "mnt_frais_ctx")
    @Comment("MONTANT DES FRAIS")
    private Double montantFraisCtx;

    @Column(name = "tmm_indexe_ctx", length = 1)
    @Comment("INDEXE TMM O/N")
    private String tmmIndexeCtx;

    @Column(name = "taux_ir_ctx")
    @Comment("TAUX IR / MARGE")
    private Double tauxIRCtx;

    @Column(name = "taux_ic_ctx")
    @Comment("TAUX IC / MARGE")
    private Double tauxICCtx;

    @Column(name = "date_arrete_ctx")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Temporal(TemporalType.DATE)
    @Comment("DATE D ARRETE")
    private Date dateArreteCtx;

    @Column(name = "mnt_recouv_p_decl_ctx")
    @Comment("MONTANT DU RECOUVREMENT EN PRINCIPAL PAYÉ A DECLARER A L ETAT")
    private Double montantRecouvrementPrincipalDeclareCtx;

    @Column(name = "mnt_recouv_p_rest_ctx") // change to mnt_recouv_p_ctx
    @Comment("MONTANT DU PRINCIPAL RESTANT A RECOUVRER ET DECLARER A L ETAT")
    private Double montantRecouvrementPrincipalCtx;

    @Column(name = "mnt_recouv_ic_ctx")
    @Comment("MONTANT DU RECOUV EN IC PAYÉ A DECLARER A L ETAT")
    private Double montantRecouvrementICCtx;

    @Column(name = "mnt_recouv_ir_ctx")
    @Comment("MONTANT DU RECOUV EN IR PAYÉ A DECLARER A L ETAT")
    private Double montantRecouvrementIRCtx;

    @Column(name = "date_aff_ste_ctx")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Temporal(TemporalType.DATE)
    @Comment("DATE D AFFECTATION A LA SOCIETE DE RECOUVREMENT")
    private Date dateAffecationSocieteCtx;

    @Column(name = "etat_ste_reco_ctx")
    @Comment("1: A PAYER / 2: PAYÉ / 0: AUTRE")
    private Integer etatSocieteRecouvrementCtx;

    @Column(name = "num_cred_saeb")
    @Comment("N° CREDIT SAEB")
    private String numCreditSaeb;

    @Column(name = "mnt_accorde_saeb")
    @Comment("MONTANT ACCORDE SAEB")
    private Double montantAccordeSaeb;

    @Column(name = "mnt_utilise_saeb")
    @Comment("MONTANT UTILISE SAEB")
    private Double montantUtiliseSaeb;

    @Column(name = "date_accord_saeb")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Temporal(TemporalType.DATE)
    @Comment("DATE ACCORD DU CREDIT")
    private Date dateAccordSaeb;

    @Column(name = "date_debloc_saeb")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Comment("DATE DEBLOCAGE DU CREDIT")
    private Date dateDeblocageSaeb;

    @Column(name = "mnt_ic_reserv_ctx")
    @Comment("MONTANT DES AGIOS RESERVES")
    private Double montantICReserveCtx;

    @Column(name = "typ_piece_tire_ctx")
    @Comment("Type pièce du tiré, cas d escompte")
    private Integer typePieceTireCtx;

    @Column(name = "num_piece_tire_ctx")
    @Comment("Num pièce du tiré, cas d escompte")
    private String numPieceTireCtx;

    @Column(name = "date_clot_ctx")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Temporal(TemporalType.DATE)
    @Comment("DATE CLOTURE DU RISQUE")
    private Date dateClotureRisqueCtx;

    @Column(name = "mnt_cede_p_ctx")
    @Comment("MONTANT DE CESSION/ABANDON EN PRINCIPAL")
    private Double montantCedePrincipalCtx;

    @Column(name = "mnt_cede_ic_ctx")
    @Comment("MONTANT DE CESSION/ABANDON EN IC")
    private Double montantCedeICCtx;

    @Column(name = "DATE_DECISION_CTX")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    private Date dateDecisionCtx;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @Comment("clé étrangère: type_cloture_ctx")
//   @JoinColumn(name = "ID_TYPE_CREDIT_CTX", referencedColumnName = "ID_TYPE_CREDIT_CTX")
//    private TypeCredit typeCreditCtx;

    @Column(name = "ref_eps_ctx")
    @Comment("REF DE L EPS MIS EN JEU")
    private String referenceEpsCtx;

    @Column(name = "NUM_PRET_AGR")
    @Comment("Numéro de pret Agricole")
    private Integer numeroPretCtx;

    @Column(name = "ETAT_ASSAINISSEMENT_CTX")
    private Integer etatAssainissementCtx;

    @Column(name = "mnt_provision_ctx")
    private Double montantProvisionCtx;

//    @Column(name = "date_chargement_provision")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
//    @Temporal(TemporalType.DATE)
//    private Date dateChargementProvision;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // remove?
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ToString.Exclude
    @Comment("clé étrangère: Debiteur_CTX")
    @JoinColumn(name = "num_ctx", referencedColumnName = "num_ctx")
    @JoinColumn(name = "cod_strc_ctx", referencedColumnName = "cod_strc_ctx")
    private DebiteurCtx debiteurCtx;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @Comment("clé étrangère: Fond_ctx")
//    @JoinColumn(name = "cod_fond_ctx", referencedColumnName = "cod_fond_ctx")
//    private FondCtx fondCtx;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//   @OnDelete(action = OnDeleteAction.CASCADE)
//   @Comment("clé étrangère: stade_Ctx")
//   @JoinColumn(name = "cod_stade_ctx", referencedColumnName = "cod_stade_ctx")
//   private StadeCtx stadeCtx;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//
//    @Comment("clé étrangère: type_cloture_ctx")
//    @JoinColumn(name = "cod_type_cloture_ctx", referencedColumnName = "cod_type_cloture_ctx")
//    private TypeClotureCtx typeClotureCtx;
//
//   @ManyToOne(fetch = FetchType.LAZY, optional = false)
//   @OnDelete(action = OnDeleteAction.CASCADE)
//   @Comment("clé étrangère: creance_ctx")
//    @JoinColumn(name = "cod_creance_ctx", referencedColumnName = "cod_creance_ctx")
//   private CreanceCtx creanceCtx;
//
//   @ManyToOne(fetch = FetchType.LAZY, optional = false)
//   @OnDelete(action = OnDeleteAction.CASCADE)
//   @Comment("clé étrangère: Produit_ctx")
//    @JoinColumn(name = "cod_produit_ctx", referencedColumnName = "cod_produit_ctx")
//    private ProduitCtx produitCtx;


    @Column(name = "PLAFOND_FACILITE_CAISSE")
    @Comment("PLAFOND FACILITE CAISSE")
    private Double plafondFaciliteCaisse;

//    @Column(name = "ECHEANCE_FACILITE_CAISSE")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
//    @Temporal(TemporalType.DATE)
//    @Comment("ECHEANCE FACILITE CAISSE")
//    private Date echeanceFaciliteCaisse;

    @Column(name = "MNT_GARANTIE")
    @Comment("MNT GARANTIE")
    private Double mntGarantie;

    @Column(name = "MOTIF_CHANG_TAUX")
    @Comment("motif de changement des taux ")
    private String motifChangementTaux;

    @Column(name = "MNT_ENTRE_AGIORSV_CTX")
    private Double mntEntreAgiosReserv;

   @OneToMany(mappedBy = "risqueCtx")
    private Set<DetailRisqueCtx> details;










}
