package com.example.test.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "type_credit_ctx")
public class TypeCredit {

    @Id
    @Column(name = "ID_TYPE_CREDIT_CTX", unique = true, nullable = false)
    @Comment("id type credit")
    private String idTypeCredit;

    @Column(name = "LIB_TYPE_CREDIT_CTX")
    @Comment("Libelle type credit ")
    private String libelleTypeCredit;

    public TypeCredit(String idTypeCredit) {
        super();
        this.idTypeCredit = idTypeCredit;
    }

}
