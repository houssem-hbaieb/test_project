package com.example.test.Repositories;

import com.example.test.Models.Prestataire;
import com.example.test.Models.TypePrestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PrestataireRepository extends JpaRepository<Prestataire, Long> {


    @Query("SELECT p FROM Prestataire p WHERE p.typeP = :type ORDER BY p.id DESC LIMIT 1")
    Optional<Prestataire> findLastByType(TypePrestation type);

    List<Prestataire> findByDebiteurCtx_numCtx(Long debiteurId);


}
