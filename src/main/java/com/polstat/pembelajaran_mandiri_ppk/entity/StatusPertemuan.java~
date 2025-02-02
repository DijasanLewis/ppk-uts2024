package com.polstat.pembelajaran_mandiri_ppk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// Menandakan bahwa kelas ini adalah entitas JPA yang akan dipetakan ke tabel database
@Entity
@Table(name = "status_pertemuan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusPertemuan {
    // Menandakan bahwa ini adalah primary key dengan strategi auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relasi ManyToOne dengan entitas User, menghubungkan ke kolom mahasiswa_id
    @ManyToOne
    @JoinColumn(name = "mahasiswa_id", nullable = false)
    private User mahasiswa;

    // Relasi ManyToOne dengan entitas Pertemuan, menghubungkan ke kolom pertemuan_id
    @ManyToOne
    @JoinColumn(name = "pertemuan_id", nullable = false)
    private Pertemuan pertemuan;

    // Status materi, bisa "Belum" atau "Sudah"
    private String statusMateri;
    // Tanggal ketika status materi diubah
    private LocalDateTime tanggalStatusMateri;

    // URL untuk hasil praktikum
    private String linkPengerjaanPraktikum;
    // Status pengumpulan, bisa "Belum" atau "Sudah"
    private String statusPengumpulan;
    // Tanggal ketika status pengumpulan diubah
    private LocalDateTime tanggalStatusPengumpulan;

    // Skor untuk praktikum
    private Integer skorPraktikum;

    // Status kuis, bisa "Belum" atau "Sudah"
    private String statusKuis;
    // Tanggal ketika status kuis diubah
    private LocalDateTime tanggalStatusKuis;
    // Skor untuk kuis
    private Integer skorKuis;

    // Metode ini akan dipanggil sebelum entitas disimpan atau diperbarui
    @PrePersist
    @PreUpdate
    public void updateTimestamps() {
        // Jika statusMateri tidak null dan tanggalStatusMateri belum diatur, atur dengan waktu saat ini
        if (statusMateri != null && tanggalStatusMateri == null) {
            this.tanggalStatusMateri = LocalDateTime.now();
        }
        // Jika statusPengumpulan tidak null dan tanggalStatusPengumpulan belum diatur, atur dengan waktu saat ini
        if (statusPengumpulan != null && tanggalStatusPengumpulan == null) {
            this.tanggalStatusPengumpulan = LocalDateTime.now();
        }
        // Jika statusKuis tidak null dan tanggalStatusKuis belum diatur, atur dengan waktu saat ini
        if (statusKuis != null && tanggalStatusKuis == null) {
            this.tanggalStatusKuis = LocalDateTime.now();
        }
    }
}
