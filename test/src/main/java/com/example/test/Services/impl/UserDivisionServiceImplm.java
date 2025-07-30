package com.example.test.Services.impl;

import com.example.test.Models.User;
import com.example.test.Models.UserDivision;
import com.example.test.Repositories.UserDivisionRepository;
import com.example.test.Services.UserDivisionService;
import com.example.test.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDivisionServiceImplm implements UserDivisionService {
    private final UserDivisionRepository userDivisionRepository;
    @Override
    public List<UserDTO> getUsersByDivision(Long divisionId) {
        List<UserDivision> userDivisions = userDivisionRepository.findByDivisionId(divisionId);
        return userDivisions.stream()
                .map(UserDivision::getUser)
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());


    }


    private UserDTO convertToUserDTO(User user) {
        Set<String> roleNames = user.getRoles()
                .stream()
                .map(role -> role.getName().name())
                .collect(Collectors.toSet());

        return UserDTO.builder()
                .id(user.getId())
                .matricule(user.getMatricule())
                .email(user.getEmail())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .code_structure(user.getCode_structure())
                .roles(roleNames)
                .build();
    }




    }

