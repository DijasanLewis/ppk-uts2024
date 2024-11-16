package com.polstat.pembelajaran_mandiri_ppk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "status_pertemuan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusPertemuan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mahasiswa_id", nullable = false)
    private User mahasiswa;

    @ManyToOne
    @JoinColumn(name = "pertemuan_id", nullable = false)
    private Pertemuan pertemuan;

    private String statusMateri; // Belum atau Sudah
    private LocalDateTime tanggalStatusMateri;

    private String linkPengerjaanPraktikum; // URL hasil praktikum
    private String statusPengumpulan; // Belum atau Sudah
    private LocalDateTime tanggalStatusPengumpulan;

    private Integer skorPraktikum;

    private String statusKuis; // Belum atau Sudah
    private LocalDateTime tanggalStatusKuis;
    private Integer skorKuis;

    @PrePersist
    @PreUpdate
    public void updateTimestamps() {
        if (statusMateri != null && tanggalStatusMateri == null) {
            this.tanggalStatusMateri = LocalDateTime.now();
        }
        if (statusPengumpulan != null && tanggalStatusPengumpulan == null) {
            this.tanggalStatusPengumpulan = LocalDateTime.now();
        }
        if (statusKuis != null && tanggalStatusKuis == null) {
            this.tanggalStatusKuis = LocalDateTime.now();
        }
    }
}
