package com.example.test.Services.impl;

import com.example.test.Models.Departement;
import com.example.test.Repositories.DepartementRepository;
import com.example.test.Services.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartementServiceImpl implements DepartementService {

    private final DepartementRepository departementRepository;


    @Override
    public Departement createDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Optional<Departement> getDepartementById(Long id) {
        return departementRepository.findById(id);
    }

    @Override
    public Departement updateDepartement(Long id, Departement departement) {
        return departementRepository.findById(id).map(dept -> {
            dept.setNomDepartement(departement.getNomDepartement());
            dept.setLiblle(departement.getLiblle());
            dept.setCodeStructure(departement.getCodeStructure());
            return departementRepository.save(dept);
        }).orElseThrow(() -> new RuntimeException("Departement not found"));    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);

    }

    @Override
    public List<Departement> getDepartementsByUserId(Integer userId) {
        return departementRepository.findByUserId(userId);

    }
}
