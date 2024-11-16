package com.polstat.pembelajaran_mandiri_ppk.mapper;

import com.polstat.pembelajaran_mandiri_ppk.dto.UserDTO;
import com.polstat.pembelajaran_mandiri_ppk.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .nidn(user.getNidn())
                .nim(user.getNim())
                .kelas(user.getKelas())
                .namaLengkap(user.getNamaLengkap())
                .password(user.getPassword())
                .build();
    }

    public User toEntity(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .role(dto.getRole())
                .nidn(dto.getNidn())
                .nim(dto.getNim())
                .kelas(dto.getKelas())
                .namaLengkap(dto.getNamaLengkap())
                .password(dto.getPassword())
                .build();
    }
}
