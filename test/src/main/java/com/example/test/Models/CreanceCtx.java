package com.example.test.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "creance_ctx")
public class CreanceCtx implements Serializable {

    private static final long serialVersionUID = -5469485922969833704L;

    @Id
    @Column(name = "cod_creance_ctx", columnDefinition = "NUMBER (2,0)")
    @Comment("Code du creance")
    private Integer codCreanceCtx;

    @Column(name = "lib_creance_ctx")
    @Comment("Libellé du creance")
    private String libelleCreanceCtx;
}
