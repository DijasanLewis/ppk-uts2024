package com.polstat.pembelajaran_mandiri_ppk.service;

import com.polstat.pembelajaran_mandiri_ppk.dto.PertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.entity.Pertemuan;
import com.polstat.pembelajaran_mandiri_ppk.entity.StatusPertemuan;
import com.polstat.pembelajaran_mandiri_ppk.entity.User;
import com.polstat.pembelajaran_mandiri_ppk.mapper.PertemuanMapper;
import com.polstat.pembelajaran_mandiri_ppk.repository.PertemuanRepository;
import com.polstat.pembelajaran_mandiri_ppk.repository.StatusPertemuanRepository;
import com.polstat.pembelajaran_mandiri_ppk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PertemuanServiceImpl implements PertemuanService {

    @Autowired
    private PertemuanRepository pertemuanRepository;

    @Autowired
    private PertemuanMapper pertemuanMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatusPertemuanRepository statusPertemuanRepository;

    @Override
    public PertemuanDTO createPertemuan(PertemuanDTO pertemuanDTO) {
        Pertemuan pertemuan = pertemuanMapper.toEntity(pertemuanDTO);
        pertemuan = pertemuanRepository.save(pertemuan);

        // Tambahkan status pertemuan untuk semua mahasiswa
        List<User> mahasiswaList = userRepository.findAllByRole("MAHASISWA");
        for (User mahasiswa : mahasiswaList) {
            StatusPertemuan status = StatusPertemuan.builder()
                    .mahasiswa(mahasiswa)
                    .namaLengkapMahasiswa(mahasiswa.getNamaLengkap())
                    .pertemuan(pertemuan)
                    .statusMateri("Belum")
                    .statusPengumpulan("Belum")
                    .statusKuis("Belum")
                    .build();
            statusPertemuanRepository.save(status);
        }

        return pertemuanMapper.toDTO(pertemuan);
    }

    @Override
    public PertemuanDTO getPertemuanById(Long id) {
        Pertemuan pertemuan = pertemuanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pertemuan not found with ID: " + id));
        return pertemuanMapper.toDTO(pertemuan);
    }

    @Override
    public PertemuanDTO updatePertemuan(Long id, PertemuanDTO pertemuanDTO) {
        Pertemuan pertemuan = pertemuanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pertemuan not found with ID: " + id));
        pertemuan.setNamaPertemuan(pertemuanDTO.getNamaPertemuan());
        pertemuan.setLinkMateri(pertemuanDTO.getLinkMateri());
        pertemuan.setLinkPraktikum(pertemuanDTO.getLinkPraktikum());
        pertemuan.setLinkKuis(pertemuanDTO.getLinkKuis());
        pertemuan = pertemuanRepository.save(pertemuan);
        return pertemuanMapper.toDTO(pertemuan);
    }

    @Override
    @Transactional
    public void deletePertemuan(Long id) {
        // Temukan pertemuan terlebih dahulu
        Pertemuan pertemuan = pertemuanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pertemuan not found with ID: " + id));

        // Hapus semua status pertemuan terkait terlebih dahulu
        statusPertemuanRepository.deleteByPertemuan(pertemuan);

        // Kemudian hapus pertemuan
        pertemuanRepository.delete(pertemuan);
    }

    @Override
    public List<PertemuanDTO> getAllPertemuan() {
        return pertemuanRepository.findAll().stream()
                .map(pertemuanMapper::toDTO)
                .collect(Collectors.toList());
    }
}
