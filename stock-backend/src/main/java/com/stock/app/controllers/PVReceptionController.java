package com.stock.app.controllers;

import com.stock.app.models.PVReception;
import com.stock.app.services.PVReceptionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pvreceptions")
@AllArgsConstructor
public class PVReceptionController {

    private final PVReceptionService pvReceptionService;

    @GetMapping
    public ResponseEntity<Page<PVReception>> getAllPVReceptions(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        Page<PVReception> pvReceptions = pvReceptionService.getAllPVReceptions(page, size);
        return ResponseEntity.ok(pvReceptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PVReception> getPVReceptionById(@PathVariable Long id) {
        PVReception pvReception = pvReceptionService.getPVReceptionById(id);
        return pvReception != null ?
                ResponseEntity.ok(pvReception) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PVReception> addPVReception(@RequestBody PVReception pvReception) {
        PVReception newPVReception = pvReceptionService.addPVReception(pvReception);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPVReception);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PVReception> updatePVReception(@PathVariable Long id, @RequestBody PVReception pvReception) {
        pvReception.setId(id);
        PVReception updatedPVReception = pvReceptionService.updatePVReception(pvReception);
        return ResponseEntity.ok(updatedPVReception);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePVReceptionById(@PathVariable Long id) {
        pvReceptionService.deletePVReceptionById(id);
        return ResponseEntity.noContent().build();
    }
}
