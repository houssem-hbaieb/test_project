package com.example.test.Services.impl;

import com.example.test.Models.Departement;
import com.example.test.Models.Division;
import com.example.test.Models.User;
import com.example.test.Models.UserDivision;
import com.example.test.Repositories.DepartementRepository;
import com.example.test.Repositories.DivisionRepository;
import com.example.test.Repositories.UserDivisionRepository;
import com.example.test.Repositories.UserRepository;
import com.example.test.Services.DivisionService;
import com.example.test.dto.DivisionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository divisionRepository;
    private final DepartementRepository departementRepository;
    private final UserRepository userRepository;
    private final UserDivisionRepository userDivisionRepository;


    @Override
    public Division addDivision(DivisionDTO dto) {
        Departement departement = departementRepository.findById(dto.getDepartementId())
                .orElseThrow(() -> new RuntimeException("Département introuvable"));

        Division division = new Division();
        division.setLiblle(dto.getLiblle());
        division.setCodeStructure(dto.getCodeStructure());
        division.setDepartement(departement);
        return divisionRepository.save(division);
    }

    @Override
    public Division updateDivision(Long id, DivisionDTO dto) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Division introuvable"));

        Departement departement = departementRepository.findById(dto.getDepartementId())
                .orElseThrow(() -> new RuntimeException("Département introuvable"));

        division.setLiblle(dto.getLiblle());
        division.setCodeStructure(dto.getCodeStructure());
        division.setDepartement(departement);
        return divisionRepository.save(division);
    }

    @Override
    public void deleteDivision(Long id) {
        divisionRepository.deleteById(id);
    }

    @Override
    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    @Override
    public Division getDivisionById(Long id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Division> getDivisionsByDepartementId(Long departementId) {
        return   divisionRepository.findByDepartementId(departementId);

    }

    @Override
    public UserDivision assignUserToDivision(int  userMatricule, Long divisionId) {
        User user = userRepository.findById(userMatricule)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Division division = divisionRepository.findById(divisionId)
                .orElseThrow(() -> new RuntimeException("Division not found"));

        UserDivision userDivision = new UserDivision();
        userDivision.setUserMatricule(userMatricule);
        userDivision.setDivisionId(divisionId);
        userDivision.setUser(user);
        userDivision.setDivision(division);

        return userDivisionRepository.save(userDivision);
    }


}
