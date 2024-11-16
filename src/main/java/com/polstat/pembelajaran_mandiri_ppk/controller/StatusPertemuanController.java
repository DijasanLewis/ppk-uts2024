package com.polstat.pembelajaran_mandiri_ppk.controller;

import com.polstat.pembelajaran_mandiri_ppk.dto.StatusPertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.service.StatusPertemuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-pertemuan")
public class StatusPertemuanController {

    @Autowired
    private StatusPertemuanService statusPertemuanService;

    @PutMapping
    public ResponseEntity<StatusPertemuanDTO> updateStatus(@RequestBody StatusPertemuanDTO statusPertemuanDTO) {
        return ResponseEntity.ok(statusPertemuanService.updateStatus(statusPertemuanDTO));
    }

    @GetMapping("/mahasiswa/{id}")
    public ResponseEntity<List<StatusPertemuanDTO>> getStatusByMahasiswa(@PathVariable Long id) {
        return ResponseEntity.ok(statusPertemuanService.getStatusByMahasiswa(id));
    }

    @GetMapping("/pertemuan/{id}")
    public ResponseEntity<List<StatusPertemuanDTO>> getStatusByPertemuan(@PathVariable Long id) {
        return ResponseEntity.ok(statusPertemuanService.getStatusByPertemuan(id));
    }

    @GetMapping
    public ResponseEntity<List<StatusPertemuanDTO>> getAllStatusPertemuan() {
        return ResponseEntity.ok(statusPertemuanService.getAllStatusPertemuan());
    }
}
