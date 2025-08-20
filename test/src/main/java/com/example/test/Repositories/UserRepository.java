package com.example.test.Repositories;

import com.example.test.Models.ERole;
import com.example.test.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id NOT IN " +
            "(SELECT ud.userMatricule FROM UserDivision ud WHERE ud.divisionId = :divisionId)")
    List<User> findUsersNotAssignedToDivision(@Param("divisionId") Long divisionId);

    List<User> findByRoles_Name(ERole role);


    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.name <> :adminRole")
    List<User> findAllUsersExceptAdmin(@Param("adminRole") ERole adminRole);



}