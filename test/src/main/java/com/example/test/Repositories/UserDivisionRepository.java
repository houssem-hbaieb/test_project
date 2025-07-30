package com.example.test.Repositories;

import com.example.test.Models.UserDivision;
import com.example.test.Models.UserDivisionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDivisionRepository extends JpaRepository<UserDivision, UserDivisionId> {

    Optional<UserDivision> findByUserMatricule(Long matricule);

    List<UserDivision> findByDivisionId(Long divisionId);


}
