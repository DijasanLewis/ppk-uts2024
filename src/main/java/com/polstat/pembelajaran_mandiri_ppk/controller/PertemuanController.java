package com.polstat.pembelajaran_mandiri_ppk.controller;

import com.polstat.pembelajaran_mandiri_ppk.dto.PertemuanDTO;
import com.polstat.pembelajaran_mandiri_ppk.service.PertemuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pertemuan")
public class PertemuanController {

    @Autowired
    private PertemuanService pertemuanService;

    @PostMapping
    public ResponseEntity<PertemuanDTO> createPertemuan(@RequestBody PertemuanDTO pertemuanDTO) {
        return ResponseEntity.ok(pertemuanService.createPertemuan(pertemuanDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PertemuanDTO> getPertemuanById(@PathVariable Long id) {
        return ResponseEntity.ok(pertemuanService.getPertemuanById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PertemuanDTO> updatePertemuan(@PathVariable Long id, @RequestBody PertemuanDTO pertemuanDTO) {
        return ResponseEntity.ok(pertemuanService.updatePertemuan(id, pertemuanDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePertemuan(@PathVariable Long id) {
        pertemuanService.deletePertemuan(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PertemuanDTO>> getAllPertemuan() {
        return ResponseEntity.ok(pertemuanService.getAllPertemuan());
    }
}
