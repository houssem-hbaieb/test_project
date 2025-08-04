package com.example.test.Repositories;

import com.example.test.Models.Departement;
import com.example.test.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Long> {


    @Query("SELECT d FROM Departement d WHERE LOWER(d.nomDepartement) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(d.codeStructure) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(d.liblle) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Departement> searchDepartements(@Param("keyword") String keyword);
}
