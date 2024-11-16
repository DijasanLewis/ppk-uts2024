package com.polstat.pembelajaran_mandiri_ppk.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PertemuanDTO {
    private Long id;
    private String namaPertemuan;
    private String linkMateri;
    private String linkPraktikum;
    private String linkKuis;
}
