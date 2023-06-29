package com.vt.product;

import com.vt.product.model.Product;
import com.vt.product.model.enums.ProductCategory;
import com.vt.product.repository.ProductRepository;
import com.vt.product.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    public CommandLineRunner tx(ProductService productService){
        return args -> {
     productService.save3();

        };
    }
}
