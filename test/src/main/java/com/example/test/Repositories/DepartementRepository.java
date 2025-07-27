package com.example.test.Repositories;

import com.example.test.Models.Departement;
import com.example.test.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
}
