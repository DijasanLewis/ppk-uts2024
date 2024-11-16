package com.polstat.pembelajaran_mandiri_ppk.service;

import com.polstat.pembelajaran_mandiri_ppk.dto.StatusPertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.entity.Pertemuan;
import com.polstat.pembelajaran_mandiri_ppk.entity.StatusPertemuan;
import com.polstat.pembelajaran_mandiri_ppk.entity.User;
import com.polstat.pembelajaran_mandiri_ppk.mapper.StatusPertemuanMapper;
import com.polstat.pembelajaran_mandiri_ppk.repository.StatusPertemuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusPertemuanServiceImpl implements StatusPertemuanService {

    @Autowired
    private StatusPertemuanRepository statusPertemuanRepository;

    @Override
    public StatusPertemuanDTO updateStatus(StatusPertemuanDTO statusPertemuanDTO) {
        StatusPertemuan status = statusPertemuanRepository.findById(statusPertemuanDTO.getId())
                .orElseThrow(() -> new RuntimeException("StatusPertemuan not found with ID: " + statusPertemuanDTO.getId()));
        StatusPertemuan updatedStatus = StatusPertemuanMapper.toEntity(statusPertemuanDTO, status);
        updatedStatus = statusPertemuanRepository.save(updatedStatus);
        return StatusPertemuanMapper.toDTO(updatedStatus);
    }

    @Override
    public List<StatusPertemuanDTO> getStatusByMahasiswa(Long mahasiswaId) {
        User mahasiswa = new User();
        mahasiswa.setId(mahasiswaId);
        return statusPertemuanRepository.findByMahasiswa(mahasiswa).stream()
                .map(StatusPertemuanMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StatusPertemuanDTO> getStatusByPertemuan(Long pertemuanId) {
        Pertemuan pertemuan = new Pertemuan();
        pertemuan.setId(pertemuanId);
        return statusPertemuanRepository.findByPertemuan(pertemuan).stream()
                .map(StatusPertemuanMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StatusPertemuanDTO> getAllStatusPertemuan() {
        return statusPertemuanRepository.findAll().stream()
                .map(StatusPertemuanMapper::toDTO)
                .collect(Collectors.toList());
    }
}
