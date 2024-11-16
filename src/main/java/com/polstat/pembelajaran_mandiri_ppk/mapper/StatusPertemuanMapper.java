package com.polstat.pembelajaran_mandiri_ppk.mapper;

import com.polstat.pembelajaran_mandiri_ppk.dto.StatusPertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.entity.StatusPertemuan;
import org.springframework.stereotype.Component;

@Component
public class StatusPertemuanMapper {
    public static StatusPertemuanDTO toDTO(StatusPertemuan status) {
        return StatusPertemuanDTO.builder()
                .id(status.getId())
                .mahasiswaId(status.getMahasiswa().getId())
                .pertemuanId(status.getPertemuan().getId())
                .statusMateri(status.getStatusMateri())
                .tanggalStatusMateri(status.getTanggalStatusMateri())
                .linkPengerjaanPraktikum(status.getLinkPengerjaanPraktikum())
                .statusPengumpulan(status.getStatusPengumpulan())
                .tanggalStatusPengumpulan(status.getTanggalStatusPengumpulan())
                .skorPraktikum(status.getSkorPraktikum())
                .statusKuis(status.getStatusKuis())
                .tanggalStatusKuis(status.getTanggalStatusKuis())
                .skorKuis(status.getSkorKuis())
                .build();
    }

    public static StatusPertemuan toEntity(StatusPertemuanDTO dto, StatusPertemuan status) {
        status.setStatusMateri(dto.getStatusMateri());
        status.setTanggalStatusMateri(dto.getTanggalStatusMateri());
        status.setLinkPengerjaanPraktikum(dto.getLinkPengerjaanPraktikum());
        status.setStatusPengumpulan(dto.getStatusPengumpulan());
        status.setTanggalStatusPengumpulan(dto.getTanggalStatusPengumpulan());
        status.setSkorPraktikum(dto.getSkorPraktikum());
        status.setStatusKuis(dto.getStatusKuis());
        status.setTanggalStatusKuis(dto.getTanggalStatusKuis());
        status.setSkorKuis(dto.getSkorKuis());
        return status;
    }
}
