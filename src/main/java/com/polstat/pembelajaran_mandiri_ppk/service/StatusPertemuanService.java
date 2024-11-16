package com.polstat.pembelajaran_mandiri_ppk.service;

import com.polstat.pembelajaran_mandiri_ppk.dto.StatusPertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.entity.User;

import java.util.List;

public interface StatusPertemuanService {
    StatusPertemuanDTO updateStatus(StatusPertemuanDTO statusPertemuanDTO, Long mahasiswaId);
    List<StatusPertemuanDTO> getStatusByMahasiswa(Long mahasiswaId);
    List<StatusPertemuanDTO> getStatusByPertemuan(Long pertemuanId);
    List<StatusPertemuanDTO> getAllStatusPertemuan();
    void createStatusForNewMahasiswa(User mahasiswa);
}
