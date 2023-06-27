package com.vt.product.service;

import com.vt.product.dto.request.ProductRequest;
import com.vt.product.model.Product;

public interface ProductService {
    Product save(ProductRequest productRequest);
}
