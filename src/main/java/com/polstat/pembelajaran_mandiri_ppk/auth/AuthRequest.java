package com.polstat.pembelajaran_mandiri_ppk.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
