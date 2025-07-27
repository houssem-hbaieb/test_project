package com.example.test.Services;

import com.example.test.Models.Departement;

import java.util.List;
import java.util.Optional;

public interface DepartementService {

    Departement createDepartement(Departement departement);
    List<Departement> getAllDepartements();
    Optional<Departement> getDepartementById(Long id);
    Departement updateDepartement(Long id, Departement departement);
    void deleteDepartement(Long id);
}
