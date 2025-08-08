package com.example.test.Repositories;

import com.example.test.Models.DebiteurCtx;
import com.example.test.Models.DebiteurCtxId;
import com.example.test.Models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DebiteurRepository extends JpaRepository<DebiteurCtx, DebiteurCtxId> {

    List<DebiteurCtx> findByCodeStructureCtx(Integer codeStructureCtx);

    List<DebiteurCtx> findByUser_Matricule(Integer matricule);

    List<DebiteurCtx> findByEtatCtx(String etatCtx);

    Optional<DebiteurCtx> findByNumCtx(Integer numCtx);



}
