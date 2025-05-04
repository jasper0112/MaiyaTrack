package com.maiyatrack.controller;

import com.maiyatrack.dto.BrandDTO;
import com.maiyatrack.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    
    @Autowired
    private BrandService brandService;
    
    @PostMapping
    public ResponseEntity<BrandDTO> createBrand(@RequestBody BrandDTO brandDTO) {
        BrandDTO createdBrand = brandService.createBrand(brandDTO);
        return ResponseEntity.ok(createdBrand);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<BrandDTO> updateBrand(@PathVariable String id, @RequestBody BrandDTO brandDTO) {
        BrandDTO updatedBrand = brandService.updateBrand(id, brandDTO);
        return ResponseEntity.ok(updatedBrand);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable String id) {
        brandService.deleteBrand(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getBrandById(@PathVariable String id) {
        BrandDTO brand = brandService.getBrandById(id);
        return ResponseEntity.ok(brand);
    }
    
    @GetMapping
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        List<BrandDTO> brands = brandService.getAllBrands();
        return ResponseEntity.ok(brands);
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<BrandDTO>> getActiveBrands() {
        List<BrandDTO> brands = brandService.getActiveBrands();
        return ResponseEntity.ok(brands);
    }
    
    @GetMapping("/category/{category}")
    public ResponseEntity<List<BrandDTO>> getBrandsByCategory(@PathVariable String category) {
        List<BrandDTO> brands = brandService.getBrandsByCategory(category);
        return ResponseEntity.ok(brands);
    }
} 