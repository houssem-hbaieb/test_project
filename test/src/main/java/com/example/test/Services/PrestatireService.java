package com.example.test.Services;

import com.example.test.dto.PrestataireDTO;

import java.util.List;

public interface PrestatireService {

    public PrestataireDTO create(PrestataireDTO dto) ;

    public PrestataireDTO findById(Long id) ;

    public PrestataireDTO update(Long id, PrestataireDTO dto) ;


    public void delete(Long id) ;

    List<PrestataireDTO> findByDebiteurId(Long debiteurId) ;

    public List<PrestataireDTO> getAll() ;


}
