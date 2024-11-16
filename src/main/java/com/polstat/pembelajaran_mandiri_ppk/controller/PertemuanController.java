package com.polstat.pembelajaran_mandiri_ppk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polstat.pembelajaran_mandiri_ppk.dto.PertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.service.PertemuanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/pertemuan")
public class PertemuanController {

    @Autowired
    private PertemuanService pertemuanService;

    @Operation(summary = "Membuat pertemuan baru.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pertemuan berhasil dibuat")
    })
    @PostMapping
    public ResponseEntity<PertemuanDTO> createPertemuan(@RequestBody PertemuanDTO pertemuanDTO) {
        return ResponseEntity.ok(pertemuanService.createPertemuan(pertemuanDTO));
    }

    @Operation(summary = "Mengambil data pertemuan berdasarkan ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Data pertemuan ditemukan"),
        @ApiResponse(responseCode = "404", description = "Pertemuan tidak ditemukan")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PertemuanDTO> getPertemuanById(@PathVariable Long id) {
        return ResponseEntity.ok(pertemuanService.getPertemuanById(id));
    }

    @Operation(summary = "Memperbarui data pertemuan.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Data pertemuan berhasil diperbarui"),
        @ApiResponse(responseCode = "404", description = "Pertemuan tidak ditemukan")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PertemuanDTO> updatePertemuan(@PathVariable Long id, @RequestBody PertemuanDTO pertemuanDTO) {
        return ResponseEntity.ok(pertemuanService.updatePertemuan(id, pertemuanDTO));
    }

    @Operation(summary = "Menghapus pertemuan berdasarkan ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Pertemuan berhasil dihapus"),
        @ApiResponse(responseCode = "404", description = "Pertemuan tidak ditemukan")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePertemuan(@PathVariable Long id) {
        pertemuanService.deletePertemuan(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Mengambil semua data pertemuan.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Berhasil mengambil semua data pertemuan")
    })
    @GetMapping
    public ResponseEntity<List<PertemuanDTO>> getAllPertemuan() {
        return ResponseEntity.ok(pertemuanService.getAllPertemuan());
    }
}
