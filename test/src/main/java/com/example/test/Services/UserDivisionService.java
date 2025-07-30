package com.example.test.Services;

import com.example.test.Models.User;
import com.example.test.dto.UserDTO;

import java.util.List;

public interface UserDivisionService {

    public List<UserDTO> getUsersByDivision(Long divisionId);
}
