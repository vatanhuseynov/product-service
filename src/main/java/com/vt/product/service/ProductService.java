package com.vt.product.service;

import com.vt.product.dto.request.ProductRequest;
import com.vt.product.model.Product;
import com.vt.product.model.enums.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(ProductRequest productRequest);
    List<Product> findAll();
    Optional<Product> findById(long id);
    List<Product> findByCategory(ProductCategory category);
    void save1();
    void save2();
    void save3();
}
