package com.example.test.Controllers;

import com.example.test.Services.PrestatireService;
import com.example.test.dto.PrestataireDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/prestataires")
public class PrestataireController {


    private final PrestatireService prestataireService;


    @PostMapping
    public ResponseEntity<PrestataireDTO> create(@RequestBody PrestataireDTO dto) {
        return ResponseEntity.ok(prestataireService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestataireDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(prestataireService.findById(id));
    }

    @GetMapping("/debiteur/{debiteurId}")
    public ResponseEntity<List<PrestataireDTO>> findByDebiteur(@PathVariable Long debiteurId) {
        return ResponseEntity.ok(prestataireService.findByDebiteurId(debiteurId));
    }

    @GetMapping
    public ResponseEntity<List<PrestataireDTO>> getAll() {
        return ResponseEntity.ok(prestataireService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestataireDTO> update(@PathVariable Long id, @RequestBody PrestataireDTO dto) {
        return ResponseEntity.ok(prestataireService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        prestataireService.delete(id);
        return ResponseEntity.noContent().build();
    }








}
