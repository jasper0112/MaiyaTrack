package com.maiyatrack.repository;

import com.maiyatrack.entity.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface BrandRepository extends MongoRepository<Brand, String> {
    Optional<Brand> findByName(String name);
    List<Brand> findByIsActive(boolean isActive);
    List<Brand> findByProductCategoriesContaining(String category);
} 