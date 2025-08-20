package com.example.test.Repositories;

import com.example.test.Models.DebiteurCtx;
import com.example.test.Models.DebiteurCtxId;
import com.example.test.Models.RisqueCtx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RisqueRepository extends JpaRepository<RisqueCtx, Long> {

    @Query("""
    SELECT r
    FROM RisqueCtx r
    JOIN r.debiteurCtx d
    WHERE d.numCtx = :numCtx
      AND d.codeStructureCtx = :codeStructureCtx
  """)
    List<RisqueCtx> findByDebiteur(@Param("numCtx") Integer numCtx,
                                   @Param("codeStructureCtx") Integer codeStructureCtx);
}
