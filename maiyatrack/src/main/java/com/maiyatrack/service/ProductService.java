package com.maiyatrack.service;

import com.maiyatrack.dto.ProductDTO;
import com.maiyatrack.entity.Product;
import com.maiyatrack.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setBrandId(productDTO.getBrandId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImageUrl());
        product.setProductUrl(productDTO.getProductUrl());
        product.setPrice(productDTO.getPrice());
        product.setLimitedEdition(productDTO.isLimitedEdition());
        product.setAvailable(productDTO.isAvailable());
        product.setReleaseDate(productDTO.getReleaseDate());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        product.setCategories(productDTO.getCategories());
        product.setTags(productDTO.getTags());
        
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }
    
    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
                
        product.setBrandId(productDTO.getBrandId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImageUrl());
        product.setProductUrl(productDTO.getProductUrl());
        product.setPrice(productDTO.getPrice());
        product.setLimitedEdition(productDTO.isLimitedEdition());
        product.setAvailable(productDTO.isAvailable());
        product.setReleaseDate(productDTO.getReleaseDate());
        product.setUpdatedAt(LocalDateTime.now());
        product.setCategories(productDTO.getCategories());
        product.setTags(productDTO.getTags());
        
        Product updatedProduct = productRepository.save(product);
        return convertToDTO(updatedProduct);
    }
    
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
    
    public ProductDTO getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return convertToDTO(product);
    }
    
    public List<ProductDTO> getProductsByBrand(String brandId) {
        return productRepository.findByBrandId(brandId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<ProductDTO> getLimitedEditionProducts() {
        return productRepository.findByIsLimitedEdition(true).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<ProductDTO> getAvailableProducts() {
        return productRepository.findByIsAvailable(true).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<ProductDTO> getProductsByCategory(String category) {
        return productRepository.findByCategoriesContaining(category).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<ProductDTO> getProductsByTag(String tag) {
        return productRepository.findByTagsContaining(tag).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setBrandId(product.getBrandId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setImageUrl(product.getImageUrl());
        dto.setProductUrl(product.getProductUrl());
        dto.setPrice(product.getPrice());
        dto.setLimitedEdition(product.isLimitedEdition());
        dto.setAvailable(product.isAvailable());
        dto.setReleaseDate(product.getReleaseDate());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setUpdatedAt(product.getUpdatedAt());
        dto.setCategories(product.getCategories());
        dto.setTags(product.getTags());
        return dto;
    }
} 