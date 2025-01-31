package com.polstat.pembelajaran_mandiri_ppk.service;

import java.util.List;

import com.polstat.pembelajaran_mandiri_ppk.dto.UserDTO;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();
    void changePassword(Long userId, String oldPassword, String newPassword);
}
