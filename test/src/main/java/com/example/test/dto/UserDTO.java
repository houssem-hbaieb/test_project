package com.example.test.dto;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    private long matricule;
    private String email;
    private String nom;
    private String prenom;
    private int code_structure;
    private Set<String> roles;
}
