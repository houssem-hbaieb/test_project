package com.example.test.Services.impl;

import com.example.test.Models.ERole;
import com.example.test.Models.Role;
import com.example.test.Models.User;
import com.example.test.Repositories.RoleRepository;
import com.example.test.Repositories.UserRepository;
import com.example.test.Services.UserService;
import com.example.test.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return mapToDTO(user);    }


    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getUsersNotAssignedToDivision(Long divisionId) {
        return userRepository.findUsersNotAssignedToDivision(divisionId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findUsersByRole(ERole role) {
        return userRepository.findByRoles_Name(role).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public List<UserDTO> getAllUsersExceptAdmin() {
        return userRepository.findAllUsersExceptAdmin(ERole.ROLE_ADMIN).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO addRoleToUser(Integer userId, ERole role) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec id: " + userId));

        Role roleEntity = roleRepository.findByName(role)
                .orElseThrow(() -> new RuntimeException("Rôle introuvable : " + role.name()));

        user.getRoles().add(roleEntity);
        userRepository.save(user);

        return mapToDTO(user);
    }

    @Override
    public UserDTO removeRoleFromUser(Integer userId, ERole role) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec id: " + userId));

        Role roleEntity = roleRepository.findByName(role)
                .orElseThrow(() -> new RuntimeException("Rôle introuvable : " + role.name()));

        user.getRoles().remove(roleEntity);
        userRepository.save(user);

        return mapToDTO(user);
    }

    private UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .matricule(user.getMatricule())
                .email(user.getEmail())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .code_structure(user.getCode_structure())
                .roles(user.getRoles().stream()
                        .map(role -> role.getName().name())
                        .collect(Collectors.toSet()))
                .build();
    }


}
