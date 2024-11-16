package com.polstat.pembelajaran_mandiri_ppk.mapper;

import com.polstat.pembelajaran_mandiri_ppk.dto.StatusPertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.entity.StatusPertemuan;

public class StatusPertemuanMapper {
    public static StatusPertemuanDTO toDTO(StatusPertemuan statusPertemuan) {
        if (statusPertemuan == null) return null;
        StatusPertemuanDTO dto = new StatusPertemuanDTO();
        dto.setId(statusPertemuan.getId());
        dto.setMahasiswaId(statusPertemuan.getMahasiswa().getId());
        dto.setPertemuanId(statusPertemuan.getPertemuan().getId());
        dto.setStatusMateri(statusPertemuan.getStatusMateri());
        dto.setTanggalStatusMateri(statusPertemuan.getTanggalStatusMateri());
        dto.setLinkPengerjaanPraktikum(statusPertemuan.getLinkPengerjaanPraktikum());
        dto.setStatusPengumpulan(statusPertemuan.getStatusPengumpulan());
        dto.setTanggalStatusPengumpulan(statusPertemuan.getTanggalStatusPengumpulan());
        dto.setSkorPraktikum(statusPertemuan.getSkorPraktikum());
        dto.setStatusKuis(statusPertemuan.getStatusKuis());
        dto.setTanggalStatusKuis(statusPertemuan.getTanggalStatusKuis());
        dto.setSkorKuis(statusPertemuan.getSkorKuis());
        return dto;
    }
}
