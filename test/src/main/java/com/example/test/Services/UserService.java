package com.example.test.Services;

import com.example.test.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Integer id);
    void deleteUser(Integer id);
    public List<UserDTO> getUsersNotAssignedToDivision(Long divisionId);
}
