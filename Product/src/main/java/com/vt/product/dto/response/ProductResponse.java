package com.vt.product.dto.response;

import com.vt.product.model.enums.ProductCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductResponse {
    private Long id;
    private ProductCategory category;

    private String description;

    private BigDecimal price;
}

