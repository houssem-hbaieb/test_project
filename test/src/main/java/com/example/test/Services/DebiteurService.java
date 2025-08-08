package com.example.test.Services;

import com.example.test.Models.DebiteurCtx;
import com.example.test.dto.DebiteurCtxDTO;

import java.util.List;

public interface DebiteurService {

    DebiteurCtxDTO create(DebiteurCtxDTO dto);
    List<DebiteurCtxDTO> getAll();
    DebiteurCtxDTO getById(Integer id);
    DebiteurCtxDTO update(Integer id, DebiteurCtxDTO dto);
    DebiteurCtx affecterDossierADepartement(Integer numCtx, Long departementId);
    public DebiteurCtx affecterDossierADivision(Integer numCtx, Long divisionId);
    public DebiteurCtx affecterDossierAUser(Integer numCtx, Integer userId);
}
