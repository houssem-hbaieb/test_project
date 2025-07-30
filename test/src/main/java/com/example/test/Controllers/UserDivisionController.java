package com.example.test.Controllers;

import com.example.test.Models.User;
import com.example.test.Services.UserDivisionService;
import com.example.test.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/userdivision")
public class UserDivisionController {

    private final UserDivisionService userDivisionService;

    @GetMapping("/users-by-division/{divisionId}")
    public ResponseEntity<List<UserDTO>> getUsersByDivision(@PathVariable Long divisionId) {
        List<UserDTO> users = userDivisionService.getUsersByDivision(divisionId);
        return ResponseEntity.ok(users);
    }




}
