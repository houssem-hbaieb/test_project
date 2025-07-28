package com.example.test.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stade_ctx")
public class StadeCtx {


    @Id
    @Column(name = "cod_stade_ctx")
    @Comment("Code du stade")
    private Integer codeStadeCtx;

    @Column(name = "lib_stade_ctx")
    @Comment("Libellé du produit")
    private String libelleStadeCtx;

    public StadeCtx(Integer codeStadeCtx) {
        super();
        this.codeStadeCtx = codeStadeCtx;
    }
}
