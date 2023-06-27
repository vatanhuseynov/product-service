package com.vt.product.controller;

import com.vt.product.dto.request.ProductRequest;
import com.vt.product.model.Product;
import com.vt.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping()
    public ResponseEntity<Product> download(@RequestBody ProductRequest productRequest) {

        return ResponseEntity.ok(service.save(productRequest));
    }
}