package com.polstat.pembelajaran_mandiri_ppk.service;

import com.polstat.pembelajaran_mandiri_ppk.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();
}
