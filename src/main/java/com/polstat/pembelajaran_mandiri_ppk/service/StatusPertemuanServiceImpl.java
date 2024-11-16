package com.polstat.pembelajaran_mandiri_ppk.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polstat.pembelajaran_mandiri_ppk.dto.StatusPertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.entity.Pertemuan;
import com.polstat.pembelajaran_mandiri_ppk.entity.StatusPertemuan;
import com.polstat.pembelajaran_mandiri_ppk.entity.User;
import com.polstat.pembelajaran_mandiri_ppk.mapper.StatusPertemuanMapper;
import com.polstat.pembelajaran_mandiri_ppk.repository.PertemuanRepository;
import com.polstat.pembelajaran_mandiri_ppk.repository.StatusPertemuanRepository;
import com.polstat.pembelajaran_mandiri_ppk.repository.UserRepository;

@Service
public class StatusPertemuanServiceImpl implements StatusPertemuanService {

    @Autowired
    private StatusPertemuanRepository statusPertemuanRepository;

    @Autowired
    private StatusPertemuanMapper statusPertemuanMapper;

    @Autowired
    private PertemuanRepository pertemuanRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public StatusPertemuanDTO updateStatus(StatusPertemuanDTO statusPertemuanDTO, Long userId) {
        StatusPertemuan status = statusPertemuanRepository.findById(statusPertemuanDTO.getId())
                .orElseThrow(() -> new RuntimeException("StatusPertemuan not found with ID: " + statusPertemuanDTO.getId()));

        // Verifikasi bahwa pengguna yang sedang login adalah pemilik status atau dosen
        if (!status.getMahasiswa().getId().equals(userId) && !isUserDosen(userId)) {
            throw new RuntimeException("You are not allowed to update this status");
        }

        // Perbarui status berdasarkan DTO
        if (statusPertemuanDTO.getStatusMateri() != null) {
            status.setStatusMateri(statusPertemuanDTO.getStatusMateri());
            status.setTanggalStatusMateri(LocalDateTime.now());
        }
        if (statusPertemuanDTO.getLinkPengerjaanPraktikum() != null) {
            status.setLinkPengerjaanPraktikum(statusPertemuanDTO.getLinkPengerjaanPraktikum());
        }
        if (statusPertemuanDTO.getStatusPengumpulan() != null) {
            status.setStatusPengumpulan(statusPertemuanDTO.getStatusPengumpulan());
            status.setTanggalStatusPengumpulan(LocalDateTime.now());
        }
        if (statusPertemuanDTO.getStatusKuis() != null) {
            status.setStatusKuis(statusPertemuanDTO.getStatusKuis());
            status.setTanggalStatusKuis(LocalDateTime.now());
        }
        if (statusPertemuanDTO.getSkorPraktikum() != null) {
            status.setSkorPraktikum(statusPertemuanDTO.getSkorPraktikum());
        }
        if (statusPertemuanDTO.getSkorKuis() != null) {
            status.setSkorKuis(statusPertemuanDTO.getSkorKuis());
        }

        status = statusPertemuanRepository.save(status);
        return StatusPertemuanMapper.toDTO(status);
    }

    private boolean isUserDosen(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        return "DOSEN".equals(user.getRole());
    }

    @Override
    public void createStatusForNewMahasiswa(User mahasiswa) {
        List<Pertemuan> pertemuanList = pertemuanRepository.findAll();
        for (Pertemuan pertemuan : pertemuanList) {
            StatusPertemuan status = StatusPertemuan.builder()
                    .mahasiswa(mahasiswa)
                    .pertemuan(pertemuan)
                    .statusMateri("Belum")
                    .statusPengumpulan("Belum")
                    .statusKuis("Belum")
                    .build();
            statusPertemuanRepository.save(status);
        }
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
