package com.example.test.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Departement_SYS")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_departement")
    private String nomDepartement;

    @Column(name = "libelle")
    @Comment("libellé du département")
    private String liblle;

    @Column(name = "Cod_struc")
    @Comment("code structure")
    private String codeStructure;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private Set<Division> divisions = new HashSet<>();


    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<DebiteurCtx> dossiers = new HashSet<>();





}
