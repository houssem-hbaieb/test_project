package com.example.test.Controllers;

import com.example.test.Models.ERole;
import com.example.test.Services.UserService;
import com.example.test.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/not-assigned/{divisionId}")
    public ResponseEntity<List<UserDTO>> getUsersNotAssignedToDivision(@PathVariable Long divisionId) {
        List<UserDTO> users = userService.getUsersNotAssignedToDivision(divisionId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/chargees")
    public List<UserDTO> getAllChargees() {
        return userService.findUsersByRole(ERole.ROLE_CHARGEE);
    }

    @GetMapping("/sauf_admin")
    public ResponseEntity<List<UserDTO>> getAllRoleExpectAdmin() {
        return ResponseEntity.ok(userService.getAllUsersExceptAdmin());
    }


    @PostMapping("/{userId}/roles/{role}")
    public ResponseEntity<UserDTO> addRoleToUser(
            @PathVariable Integer userId,
            @PathVariable ERole role
    ) {
        return ResponseEntity.ok(userService.addRoleToUser(userId, role));
    }

    @DeleteMapping("/{userId}/roles/{role}")
    public ResponseEntity<UserDTO> removeRoleFromUser(
            @PathVariable Integer userId,
            @PathVariable ERole role
    ) {
        return ResponseEntity.ok(userService.removeRoleFromUser(userId, role));
    }






}
