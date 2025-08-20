package com.example.test.Controllers;

import com.example.test.Models.Departement;
import com.example.test.Models.Division;
import com.example.test.Models.UserDivision;
import com.example.test.Services.DivisionService;
import com.example.test.dto.DivisionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/division")
public class DivisionController {

    private final DivisionService divisionService;

    @PostMapping
    public ResponseEntity<?> addDivision(@RequestBody DivisionDTO dto) {
        return ResponseEntity.ok(divisionService.addDivision(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDivision(@PathVariable Long id, @RequestBody DivisionDTO dto) {
        return ResponseEntity.ok(divisionService.updateDivision(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDivision(@PathVariable Long id) {
        divisionService.deleteDivision(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<?>> getAll() {
        return ResponseEntity.ok(divisionService.getAllDivisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(divisionService.getDivisionById(id));
    }

    @GetMapping("/by-departement/{departementId}")
    public ResponseEntity<List<?>>  getByDepartementId(@PathVariable Long departementId) {
        return ResponseEntity.ok(divisionService.getDivisionsByDepartementId(departementId));
    }

    @PostMapping("/assign")
    public ResponseEntity<?> assignUserToDivision(@RequestParam int userMatricule, @RequestParam Long divisionId) {
        UserDivision result = divisionService.assignUserToDivision(userMatricule, divisionId);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/by-user/{userId}")
    public List<Division> getDivisionByUserId(@PathVariable Integer userId) {
        return divisionService.getDivisionByUserId(userId);
    }
}
