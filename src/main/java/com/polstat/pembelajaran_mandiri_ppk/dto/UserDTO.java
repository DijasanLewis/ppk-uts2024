package com.polstat.pembelajaran_mandiri_ppk.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String email;
    private String role;
    private String namaLengkap;
    private String nidn;
    private String nim;
    private String kelas;
    private String password;
}
