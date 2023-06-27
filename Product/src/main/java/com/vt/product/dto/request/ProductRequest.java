package com.vt.product.dto.request;

import com.vt.product.model.enums.ProductCategory;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductRequest {
    private ProductCategory category;

    private String description;
    //@Min(0)
    private BigDecimal price;
}

