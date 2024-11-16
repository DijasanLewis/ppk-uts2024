package com.polstat.pembelajaran_mandiri_ppk.service;

import com.polstat.pembelajaran_mandiri_ppk.dto.PertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.entity.Pertemuan;
import com.polstat.pembelajaran_mandiri_ppk.mapper.PertemuanMapper;
import com.polstat.pembelajaran_mandiri_ppk.repository.PertemuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PertemuanServiceImpl implements PertemuanService {

    @Autowired
    private PertemuanRepository pertemuanRepository;

    @Autowired
    private PertemuanMapper pertemuanMapper;

    @Override
    public PertemuanDTO createPertemuan(PertemuanDTO pertemuanDTO) {
        Pertemuan pertemuan = pertemuanMapper.toEntity(pertemuanDTO);
        pertemuan = pertemuanRepository.save(pertemuan);
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
    public void deletePertemuan(Long id) {
        if (!pertemuanRepository.existsById(id)) {
            throw new RuntimeException("Pertemuan not found with ID: " + id);
        }
        pertemuanRepository.deleteById(id);
    }

    @Override
    public List<PertemuanDTO> getAllPertemuan() {
        return pertemuanRepository.findAll().stream()
                .map(pertemuanMapper::toDTO)
                .collect(Collectors.toList());
    }
}
