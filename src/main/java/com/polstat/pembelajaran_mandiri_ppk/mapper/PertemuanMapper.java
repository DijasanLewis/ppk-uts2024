package com.polstat.pembelajaran_mandiri_ppk.mapper;

import com.polstat.pembelajaran_mandiri_ppk.dto.PertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.entity.Pertemuan;
import org.springframework.stereotype.Component;

@Component
public class PertemuanMapper {
    public PertemuanDTO toDTO(Pertemuan pertemuan) {
        return PertemuanDTO.builder()
                .id(pertemuan.getId())
                .namaPertemuan(pertemuan.getNamaPertemuan())
                .linkMateri(pertemuan.getLinkMateri())
                .linkPraktikum(pertemuan.getLinkPraktikum())
                .linkKuis(pertemuan.getLinkKuis())
                .build();
    }

    public Pertemuan toEntity(PertemuanDTO dto) {
        return Pertemuan.builder()
                .id(dto.getId())
                .namaPertemuan(dto.getNamaPertemuan())
                .linkMateri(dto.getLinkMateri())
                .linkPraktikum(dto.getLinkPraktikum())
                .linkKuis(dto.getLinkKuis())
                .build();
    }
}
