package com.maiyatrack.repository;

import com.maiyatrack.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByBrandId(String brandId);
    List<Product> findByIsLimitedEdition(boolean isLimitedEdition);
    List<Product> findByIsAvailable(boolean isAvailable);
    List<Product> findByCategoriesContaining(String category);
    List<Product> findByTagsContaining(String tag);
    Optional<Product> findByProductUrl(String productUrl);
} 