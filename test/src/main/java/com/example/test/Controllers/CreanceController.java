package com.example.test.Controllers;

import com.example.test.Models.DebiteurCtx;
import com.example.test.Services.DebiteurService;
import com.example.test.dto.DebiteurCtxDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
    @RequestMapping("/api/dossier")
public class CreanceController {

    private final DebiteurService creanceService;


    @PostMapping
    public ResponseEntity<DebiteurCtxDTO> createDebiteur(@RequestBody DebiteurCtxDTO dto) {
        return ResponseEntity.ok(creanceService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<DebiteurCtxDTO>> getAllDebiteurs() {
        return ResponseEntity.ok(creanceService.getAll());
    }

    @GetMapping("/{numCtx}")
    public ResponseEntity<DebiteurCtxDTO> getDebiteurByNumCtx(@PathVariable Integer numCtx) {
        return ResponseEntity.ok(creanceService.getById(numCtx));
    }

    @PutMapping("/{numCtx}")
    public ResponseEntity<DebiteurCtxDTO> updateDebiteur(@PathVariable Integer numCtx,
                                                         @RequestBody DebiteurCtxDTO dto) {
        return ResponseEntity.ok(creanceService.update(numCtx, dto));
    }



    @PutMapping("/{numCtx}/departement/{departementId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<DebiteurCtx> affecterDepartement(
            @PathVariable Integer numCtx,
            @PathVariable Long departementId
    ) {
        return ResponseEntity.ok(creanceService.affecterDossierADepartement(numCtx, departementId));
    }


    @PutMapping("/{numCtx}/division/{divisionId}")
//    @PreAuthorize("hasRole('CHEFDEPARTEMENT')")
    public ResponseEntity<DebiteurCtx> affecterDivision(
            @PathVariable Integer numCtx,
            @PathVariable Long divisionId
    ) {
        return ResponseEntity.ok(creanceService.affecterDossierADivision(numCtx, divisionId));
    }


    @PutMapping("/{numCtx}/user/{userId}")
//    @PreAuthorize("hasAnyRole('CHEFDEPARTEMENT', 'CHEFDIVISION')")
    public ResponseEntity<DebiteurCtx> affecterUser(
            @PathVariable Integer numCtx,
            @PathVariable Integer userId
    ) {
        return ResponseEntity.ok(creanceService.affecterDossierAUser(numCtx, userId));
    }

    @GetMapping("/departement/{departementId}")
    public ResponseEntity<List<DebiteurCtxDTO>> getByDepartement(@PathVariable Long departementId) {
        return ResponseEntity.ok(creanceService.getByDepartementId(departementId));
    }






}
