package com.example.test.Repositories;

import com.example.test.Models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Departement, Long> {
}
