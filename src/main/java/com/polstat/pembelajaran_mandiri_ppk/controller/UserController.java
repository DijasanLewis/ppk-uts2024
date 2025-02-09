package com.polstat.pembelajaran_mandiri_ppk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.polstat.pembelajaran_mandiri_ppk.dto.ChangePasswordRequest;
import com.polstat.pembelajaran_mandiri_ppk.dto.UserDTO;
import com.polstat.pembelajaran_mandiri_ppk.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Mendaftarkan pengguna baru.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pengguna berhasil didaftarkan"),
        @ApiResponse(responseCode = "409", description = "Email sudah terdaftar")
    })
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.registerUser(userDTO));
    }

    @Operation(summary = "Mengambil data pengguna berdasarkan ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Data pengguna ditemukan"),
        @ApiResponse(responseCode = "404", description = "Pengguna tidak ditemukan")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Operation(summary = "Memperbarui data pengguna.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Data pengguna berhasil diperbarui"),
        @ApiResponse(responseCode = "404", description = "Pengguna tidak ditemukan")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(id, userDTO));
    }

    @Operation(summary = "Menghapus pengguna berdasarkan ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Pengguna berhasil dihapus"),
        @ApiResponse(responseCode = "404", description = "Pengguna tidak ditemukan")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Mengambil semua data pengguna.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Berhasil mengambil semua data pengguna")
    })
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "Mengubah kata sandi pengguna.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Kata sandi berhasil diubah"),
        @ApiResponse(responseCode = "400", description = "Kata sandi lama salah")
    })
    @PutMapping("/{id}/change-password")
    public ResponseEntity<Void> changePassword(@PathVariable Long id, @RequestBody ChangePasswordRequest request) {
        userService.changePassword(id, request.getOldPassword(), request.getNewPassword());
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Mengambil profil pengguna yang sedang login.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profil pengguna berhasil diambil"),
            @ApiResponse(responseCode = "404", description = "Pengguna tidak ditemukan")
    })
    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getCurrentUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return ResponseEntity.ok(userService.getCurrentUserProfile(email));
    }
}
