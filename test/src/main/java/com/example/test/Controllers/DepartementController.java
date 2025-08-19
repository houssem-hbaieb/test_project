package com.example.test.Controllers;

import com.example.test.Models.Departement;
import com.example.test.Repositories.DepartementRepository;
import com.example.test.Services.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departements")
public class DepartementController {

    private final DepartementService departementService;

    private final  DepartementRepository departementRepository;


    @PostMapping
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
        Departement created = departementService.createDepartement(departement);
        return ResponseEntity.created(URI.create("/api/departements/" + created.getId()))
                .body(created);
    }

    @GetMapping
    public ResponseEntity<List<Departement>> getAllDepartements() {
        List<Departement> list = departementService.getAllDepartements();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable Long id) {
        return departementService.getDepartementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Long id,
                                                         @RequestBody Departement updated) {
        try {
            Departement updatedDepartement = departementService.updateDepartement(id, updated);
            return ResponseEntity.ok(updatedDepartement);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) {
        try {
            departementService.deleteDepartement(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Departement>> searchDepartements(@RequestParam String keyword) {
        List<Departement> result = departementRepository.searchDepartements(keyword);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/by-user/{userId}")
    public List<Departement> getDepartementsByUserId(@PathVariable Integer userId) {
        return departementService.getDepartementsByUserId(userId);
    }




}
