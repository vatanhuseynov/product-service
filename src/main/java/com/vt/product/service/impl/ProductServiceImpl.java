package com.vt.product.service.impl;

import com.vt.product.dto.request.ProductRequest;
import com.vt.product.model.Product;
import com.vt.product.model.enums.ProductCategory;
import com.vt.product.repository.ProductRepository;
import com.vt.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

   private final ProductRepository productRepository;


   @Override
   public Product save(ProductRequest productRequest) {
//      Product product = new Product();
//      product.setCategory(productRequest.getCategory());
//      product.setDescription(productRequest.getDescription());
//      product.setPrice(productRequest.getPrice());
//
      Product product = Product.builder().category(productRequest.getCategory()).
              description(productRequest.getDescription()).price(productRequest.getPrice()).build();
     return productRepository.save(product);
   }

   @Override
   public List<Product> findAll() {
      return productRepository.findAll();
   }

   @Override
   public Optional<Product> findById(long id) {
      return productRepository.findById(id);
   }

   @Override
   public List<Product> findByCategory(ProductCategory category) {
      return productRepository.findByCategory(category);
   }


}
