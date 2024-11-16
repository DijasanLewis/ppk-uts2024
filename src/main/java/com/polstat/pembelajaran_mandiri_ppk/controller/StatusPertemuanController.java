package com.polstat.pembelajaran_mandiri_ppk.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.polstat.pembelajaran_mandiri_ppk.dto.StatusPertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.service.StatusPertemuanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/status-pertemuan")
public class StatusPertemuanController {

    private static final Logger logger = LoggerFactory.getLogger(StatusPertemuanController.class);

    @Autowired
    private StatusPertemuanService statusPertemuanService;

    @Operation(summary = "Memperbarui status pertemuan untuk mahasiswa.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Status berhasil diperbarui"),
        @ApiResponse(responseCode = "403", description = "Tidak diizinkan untuk memperbarui status ini")
    })
    @PutMapping
    public ResponseEntity<StatusPertemuanDTO> updateStatus(
            @RequestBody StatusPertemuanDTO statusPertemuanDTO,
            @RequestParam Long userId) {
        return ResponseEntity.ok(statusPertemuanService.updateStatus(statusPertemuanDTO, userId));
    }

    @Operation(summary = "Mengambil status pertemuan berdasarkan ID mahasiswa.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Status pertemuan ditemukan"),
        @ApiResponse(responseCode = "404", description = "Mahasiswa tidak ditemukan")
    })
    @GetMapping("/mahasiswa/{id}")
    public ResponseEntity<List<StatusPertemuanDTO>> getStatusByMahasiswa(@PathVariable Long id) {
        return ResponseEntity.ok(statusPertemuanService.getStatusByMahasiswa(id));
    }

    @Operation(summary = "Mengambil status pertemuan berdasarkan ID pertemuan.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Status pertemuan ditemukan"),
        @ApiResponse(responseCode = "404", description = "Pertemuan tidak ditemukan")
    })
    @GetMapping("/pertemuan/{id}")
    public ResponseEntity<List<StatusPertemuanDTO>> getStatusByPertemuan(@PathVariable Long id) {
        logger.info("Dosen accessing status pertemuan for pertemuan ID: {}", id);
        List<StatusPertemuanDTO> statusList = statusPertemuanService.getStatusByPertemuan(id);
        logger.info("Returning {} status entries for pertemuan ID: {}", statusList.size(), id);
        return ResponseEntity.ok(statusList);
    }

    @Operation(summary = "Mengambil semua status pertemuan.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Berhasil mengambil semua status pertemuan")
    })
    @GetMapping
    public ResponseEntity<List<StatusPertemuanDTO>> getAllStatusPertemuan() {
        return ResponseEntity.ok(statusPertemuanService.getAllStatusPertemuan());
    }
}
