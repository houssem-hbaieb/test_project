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
@IdClass(DebiteurCtxId.class)
@Table(name = "debiteur_ctx")
public class DebiteurCtx {

    @Id
    @Column(name = "num_ctx", nullable = false)
    @Comment("Numero de dossier contentieux")
    private Integer numCtx;

    @Id
    @Column(name = "cod_strc_ctx", nullable = false)
    @Comment("Code de la structure ")
    private Integer codeStructureCtx;

    @Column(name = "etat_ctx")
    @Comment("Etat du dossier contentieux : ouvert/cloturé")
    private String etatCtx;

    @Column(name = "sort_ctx")
    @Comment("sort du dossier contentieux: accepté/refoulé/avec reserves")
    private String sortCtx;

    @Column(name = "motif_sort_ctx")
    @Comment("Motif du sort")
    private String motifSortCtx;

    @Column(name = "date_trans_ctx")
    @Comment("Date du trasnfert au contentieux")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    private Date dateTransfertCtx;

    @Column(name = "solde_recouv_ctx")
    @Comment("Solde en instance de recouvrement")
    private Double soldeRecouvrementCtx;

    @Column(name = "date_clot_ctx")
    @Temporal(TemporalType.DATE)
    @Comment("Date de cloture du dossier contentieux")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    private Date dateClotureCtx;

    @Column(name = "motif_clot_ctx")
    @Comment("Motif de cloture du dossier contentieux")
    private String motifClotureCtx;

    @Temporal(TemporalType.DATE)
    @Comment("Date de cloture du dossier contentieux")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Column(name = "DATE_CREATION_CTX")
    private Date dateCreationCtx;

    @Column(name = "MATR_CREATION_CTX")
    private Integer matriculeCreationCtx;

    @Column(name = "date_maj_ctx")
    private Date dateMajCtx;

    @Column(name = "matr_maj_ctx")
    private Integer matriculeMajCtx;

    @Temporal(TemporalType.DATE)
    @Comment("Date de cloture du dossier contentieux")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Column(name = "DATE_DECISION_CTX")
    private Date dateDecisionCtx;

    @Temporal(TemporalType.DATE)
    @Comment("Date de cloture du dossier contentieux")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr-FR", timezone = "GMT+01:00")
    @Column(name = "DATE_RECEPTION_DOSSIER")
    private Date dateReceptionDossier;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(name = "CODE_CENTRE_DEC", referencedColumnName = "CODE_CENTRE_DEC")
//    private CentreDecisionCtx centreDecisionCtx;

    @OneToMany(mappedBy = "debiteurCtx")
    @JsonIgnore
    private Set<RisqueCtx> risqueCtx;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "departement_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_debiteur_departement"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Departement departement;



    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "division_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_debiteur_division"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Division division;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_matricule", referencedColumnName = "matricule", foreignKey = @ForeignKey(name = "fk_debiteur_user"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User user;

    private static final long serialVersionUID = 1L;



}
