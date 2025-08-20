package com.example.test.Repositories;

import com.example.test.Models.Departement;
import com.example.test.Models.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {

    List<Division> findByDepartementId(Long departementId);


    List<Division> findByUserId(Integer userId);


}
