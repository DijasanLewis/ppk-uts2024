package com.polstat.pembelajaran_mandiri_ppk.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusPertemuanDTO {
    private Long id;
    private Long mahasiswaId;
    private String namaLengkapMahasiswa;
    private Long pertemuanId;
    private String statusMateri;
    private LocalDateTime tanggalStatusMateri;
    private String linkPengerjaanPraktikum;
    private String statusPengumpulan;
    private LocalDateTime tanggalStatusPengumpulan;
    private Integer skorPraktikum;
    private String statusKuis;
    private LocalDateTime tanggalStatusKuis;
    private Integer skorKuis;
}
