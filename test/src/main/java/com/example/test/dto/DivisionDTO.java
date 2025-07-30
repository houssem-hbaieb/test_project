package com.example.test.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DivisionDTO {
    private long id ;
    private String liblle;
    private String codeStructure;
    private Long departementId;
}
