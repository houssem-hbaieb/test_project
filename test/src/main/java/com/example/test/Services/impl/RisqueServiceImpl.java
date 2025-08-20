package com.example.test.Services.impl;

import com.example.test.Mapper.RisqueMapper;
import com.example.test.Models.RisqueCtx;
import com.example.test.Repositories.RisqueRepository;
import com.example.test.Services.RisqueService;
import com.example.test.dto.RisqueCtxDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RisqueServiceImpl implements RisqueService {

    private final RisqueRepository risqueRepo;

    private final RisqueMapper risqueMapper;

    @Override
    public List<RisqueCtx> getRisquesByDebiteur(Integer numCtx, Integer codeStructureCtx) {
        return risqueRepo.findByDebiteur(numCtx, codeStructureCtx);
    }

    @Override
    public RisqueCtxDTO createRisque(RisqueCtxDTO dto) {
        RisqueCtx risque = risqueMapper.toEntity(dto);

        RisqueCtx saved = risqueRepo.save(risque);

        return risqueMapper.toDTO(saved);
    }


}
