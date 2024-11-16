package com.polstat.pembelajaran_mandiri_ppk.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pertemuan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pertemuan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String namaPertemuan;

    private String linkMateri;
    private String linkPraktikum; // Optional
    private String linkKuis; // Optional
}
