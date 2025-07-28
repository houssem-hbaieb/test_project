package com.example.test.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Produit_Ctx")
public class ProduitCtx {

    @Id
    @Basic(optional = false)
    @Column(name = "cod_produit_ctx", unique = true, nullable = false)
    @Comment("Code produit")
    private Integer codeProduitCtx;

    @Column(name = "lib_produit_ctx")
    @Comment("Libelle produit ")
    private String libelleProduitCtx;

    @Column(name = "decl_produit_ctx")
    @Comment("declaration du produit ")
    private String declarationProduitCtx;

    @Column(name="PRD_COMPTA")
    private Integer produitComptable;
}
