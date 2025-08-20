package com.example.test.Services;

import com.example.test.Models.ERole;
import com.example.test.Models.User;
import com.example.test.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Integer id);

    void deleteUser(Integer id);

    public List<UserDTO> getUsersNotAssignedToDivision(Long divisionId);

    public List<UserDTO> findUsersByRole(ERole role);

    public List<UserDTO> getAllUsersExceptAdmin();

    UserDTO addRoleToUser(Integer userId, ERole role);

    UserDTO removeRoleFromUser(Integer userId, ERole role);

}