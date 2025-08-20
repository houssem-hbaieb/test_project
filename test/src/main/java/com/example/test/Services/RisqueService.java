package com.example.test.Services;

import com.example.test.Models.RisqueCtx;
import com.example.test.dto.RisqueCtxDTO;

import java.util.List;

public interface RisqueService {


    public List<RisqueCtx> getRisquesByDebiteur(Integer numCtx, Integer codeStructureCtx);

    public RisqueCtxDTO createRisque(RisqueCtxDTO dto);
}
