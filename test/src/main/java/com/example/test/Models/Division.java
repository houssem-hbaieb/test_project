package com.example.test.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Division_SYS")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle")
    @Comment("libellé du division")
    private String liblle;

    @Column(name = "Cod_struc")
    @Comment("code structure")
    private String codeStructure;


    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;


    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<DebiteurCtx> dossiers = new HashSet<>();


    @OneToMany(mappedBy = "division", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<UserDivision> userDivisions;
}
