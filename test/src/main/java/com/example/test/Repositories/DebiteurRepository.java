package com.example.test.Repositories;

import com.example.test.Models.DebiteurCtx;
import com.example.test.Models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebiteurRepository extends JpaRepository<Departement, Long> {

    List<DebiteurCtx> findByCodeStructureCtx(Integer codeStructureCtx);

    List<DebiteurCtx> findByUser_Matricule(Integer matricule);

    List<DebiteurCtx> findByEtatCtx(String etatCtx);
}
