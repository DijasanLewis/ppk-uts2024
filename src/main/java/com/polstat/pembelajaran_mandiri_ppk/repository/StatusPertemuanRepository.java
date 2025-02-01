package com.polstat.pembelajaran_mandiri_ppk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polstat.pembelajaran_mandiri_ppk.entity.Pertemuan;
import com.polstat.pembelajaran_mandiri_ppk.entity.StatusPertemuan;
import com.polstat.pembelajaran_mandiri_ppk.entity.User;

public interface StatusPertemuanRepository extends JpaRepository<StatusPertemuan, Long> {
    List<StatusPertemuan> findByMahasiswa(User mahasiswa);
    List<StatusPertemuan> findByPertemuan(Pertemuan pertemuan);
    void deleteByPertemuan(Pertemuan pertemuan);
}
