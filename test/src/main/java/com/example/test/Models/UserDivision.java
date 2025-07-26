package com.example.test.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_division")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserDivisionId.class)
public class UserDivision {

    @Id
    @Column(name = "user_matricule")
    private Long userMatricule;

    @Id
    @Column(name = "division_id")
    private Long divisionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_matricule", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id", insertable = false, updatable = false)
    private Division division;


}
