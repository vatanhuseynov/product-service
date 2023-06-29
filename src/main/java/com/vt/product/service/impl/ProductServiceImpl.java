package com.vt.product.service.impl;

import com.vt.product.dto.request.ProductRequest;
import com.vt.product.model.Product;
import com.vt.product.model.enums.ProductCategory;
import com.vt.product.repository.ProductRepository;
import com.vt.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionOperations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

   private final ProductRepository productRepository;
   private final TransactionOperations transactionTemplate;

   @Override
   public Product save(ProductRequest productRequest) {
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

   @Override
   public void save1() {
      productRepository.save(Product.builder().description("Aaa").price(BigDecimal.valueOf(12.0)).category(ProductCategory.BOOKS).build());
      if(true){
         throw new RuntimeException();
      }
      productRepository.save(Product.builder().description("martin").price(BigDecimal.valueOf(22.0)).category(ProductCategory.BOOKS).build());

   }

   @Override
   public void save2() {
      transactionTemplate.executeWithoutResult(transactionStatus -> {
         productRepository.save(Product.builder().description("Aaa").price(BigDecimal.valueOf(12.0)).category(ProductCategory.BOOKS).build());
         if(true){
            throw new RuntimeException();
         }
         productRepository.save(Product.builder().description("martin").price(BigDecimal.valueOf(22.0)).category(ProductCategory.BOOKS).build());

      });
   }

   @Override
   @Transactional
   public void save3() {
      productRepository.save(Product.builder().description("Aaa").price(BigDecimal.valueOf(12.0)).category(ProductCategory.BOOKS).build());
      if(true){
         throw new RuntimeException();
      }
      productRepository.save(Product.builder().description("martin").price(BigDecimal.valueOf(22.0)).category(ProductCategory.BOOKS).build());
   }


}
