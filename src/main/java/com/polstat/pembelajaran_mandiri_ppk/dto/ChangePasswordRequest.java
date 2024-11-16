package com.polstat.pembelajaran_mandiri_ppk.dto;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String oldPassword;
    private String newPassword;
} 