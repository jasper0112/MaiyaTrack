package com.maiyatrack.service;

import com.maiyatrack.dto.BrandDTO;
import com.maiyatrack.entity.Brand;
import com.maiyatrack.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BrandService {
    
    @Autowired
    private BrandRepository brandRepository;
    
    public BrandDTO createBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setName(brandDTO.getName());
        brand.setDescription(brandDTO.getDescription());
        brand.setWebsite(brandDTO.getWebsite());
        brand.setLogoUrl(brandDTO.getLogoUrl());
        brand.setProductCategories(brandDTO.getProductCategories());
        brand.setActive(brandDTO.isActive());
        brand.setCreatedAt(LocalDateTime.now());
        brand.setUpdatedAt(LocalDateTime.now());
        brand.setLastUpdated(LocalDateTime.now());
        
        Brand savedBrand = brandRepository.save(brand);
        return convertToDTO(savedBrand);
    }
    
    public BrandDTO updateBrand(String id, BrandDTO brandDTO) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
                
        brand.setName(brandDTO.getName());
        brand.setDescription(brandDTO.getDescription());
        brand.setWebsite(brandDTO.getWebsite());
        brand.setLogoUrl(brandDTO.getLogoUrl());
        brand.setProductCategories(brandDTO.getProductCategories());
        brand.setActive(brandDTO.isActive());
        brand.setUpdatedAt(LocalDateTime.now());
        
        Brand updatedBrand = brandRepository.save(brand);
        return convertToDTO(updatedBrand);
    }
    
    public void deleteBrand(String id) {
        brandRepository.deleteById(id);
    }
    
    public BrandDTO getBrandById(String id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        return convertToDTO(brand);
    }
    
    public List<BrandDTO> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<BrandDTO> getActiveBrands() {
        return brandRepository.findByIsActive(true).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<BrandDTO> getBrandsByCategory(String category) {
        return brandRepository.findByProductCategoriesContaining(category).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private BrandDTO convertToDTO(Brand brand) {
        BrandDTO dto = new BrandDTO();
        dto.setId(brand.getId());
        dto.setName(brand.getName());
        dto.setDescription(brand.getDescription());
        dto.setWebsite(brand.getWebsite());
        dto.setLogoUrl(brand.getLogoUrl());
        dto.setProductCategories(brand.getProductCategories());
        dto.setActive(brand.isActive());
        dto.setLastUpdated(brand.getLastUpdated());
        dto.setCreatedAt(brand.getCreatedAt());
        dto.setUpdatedAt(brand.getUpdatedAt());
        return dto;
    }
} 