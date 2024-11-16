package com.polstat.pembelajaran_mandiri_ppk.service;

import com.polstat.pembelajaran_mandiri_ppk.dto.StatusPertemuanDTO;

import java.util.List;

public interface StatusPertemuanService {
    StatusPertemuanDTO updateStatus(StatusPertemuanDTO statusPertemuanDTO);
    List<StatusPertemuanDTO> getStatusByMahasiswa(Long mahasiswaId);
    List<StatusPertemuanDTO> getStatusByPertemuan(Long pertemuanId);
    List<StatusPertemuanDTO> getAllStatusPertemuan();
}
