package com.vt.product.controller;

import com.vt.product.dto.request.ProductRequest;
import com.vt.product.dto.response.ProductResponse;
import com.vt.product.model.Product;
import com.vt.product.model.enums.ProductCategory;
import com.vt.product.service.ProductService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping()
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {

        Product product = service.save(productRequest);
        ProductResponse productResponse = ProductResponse.builder().id(product.getId()).category(product.getCategory())
                .description(product.getDescription())
          .price(product.getPrice()).build();
        return ResponseEntity.ok(productResponse);
    }
    @GetMapping(path="/all")
    public ResponseEntity<List<ProductResponse>> getAll(){
        List<Product> products = service.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product:products) {
            ProductResponse productResponse = ProductResponse.builder().id(product.getId()).category(product.getCategory())
                    .description(product.getDescription()).price(product.getPrice()).build();
            productResponses.add(productResponse);
        }
        return ResponseEntity.ok(productResponses);
    }
    @GetMapping(path="/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable long id){
        Optional<Product> productOpt=service.findById(id);
        if(productOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Product product = productOpt.get();
            ProductResponse productResponse = ProductResponse.builder().id(product.getId()).category(product.getCategory())
                    .description(product.getDescription())
                    .price(product.getPrice()).build();
            return ResponseEntity.ok(productResponse);
        }
    }
    @GetMapping(path = "/by-category")
    public ResponseEntity<List<ProductResponse>> getByCategory(@RequestParam("category") ProductCategory category){
        List<Product> products= service.findByCategory(category);
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product:products) {
            ProductResponse productResponse = ProductResponse.builder().id(product.getId()).category(product.getCategory())
                    .description(product.getDescription()).price(product.getPrice()).build();
            productResponses.add(productResponse);
        }
        return ResponseEntity.ok(productResponses);

    }

}