package com.example.test.Controllers;

import com.example.test.Models.RisqueCtx;
import com.example.test.Services.RisqueService;
import com.example.test.dto.RisqueCtxDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/risques")
public class RisqueController {

    private final RisqueService risqueCtxService;

    @GetMapping("/debiteur")
    public List<RisqueCtx> getRisquesByDebiteur(
            @RequestParam Integer numCtx,
            @RequestParam Integer codStrcCtx) {
        return risqueCtxService.getRisquesByDebiteur(numCtx, codStrcCtx);
    }

    @PostMapping
    public ResponseEntity<RisqueCtxDTO> createRisque(@RequestBody RisqueCtxDTO dto) {
        RisqueCtxDTO saved = risqueCtxService.createRisque(dto);
        return ResponseEntity.ok(saved);
    }

}
