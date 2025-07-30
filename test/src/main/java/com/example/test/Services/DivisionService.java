package com.example.test.Services;

import com.example.test.Models.Division;
import com.example.test.Models.UserDivision;
import com.example.test.dto.DivisionDTO;

import java.util.List;

public interface DivisionService {

    Division addDivision(DivisionDTO dto);
    Division updateDivision(Long id, DivisionDTO dto);
    void deleteDivision(Long id);
    List<Division> getAllDivisions();
    Division getDivisionById(Long id);
    List<Division> getDivisionsByDepartementId(Long departementId);
    UserDivision assignUserToDivision(int userMatricule, Long divisionId);




}
