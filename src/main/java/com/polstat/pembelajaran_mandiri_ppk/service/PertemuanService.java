package com.polstat.pembelajaran_mandiri_ppk.service;

import com.polstat.pembelajaran_mandiri_ppk.dto.PertemuanDTO;

import java.util.List;

public interface PertemuanService {
    PertemuanDTO createPertemuan(PertemuanDTO pertemuanDTO);
    PertemuanDTO getPertemuanById(Long id);
    PertemuanDTO updatePertemuan(Long id, PertemuanDTO pertemuanDTO);
    void deletePertemuan(Long id);
    List<PertemuanDTO> getAllPertemuan();
}
