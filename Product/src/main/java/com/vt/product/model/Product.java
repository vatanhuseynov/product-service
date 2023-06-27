package com.vt.product.model;

import com.vt.product.model.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    //@NotNull(message = "Category must be specified.")
    private ProductCategory category;

    @Column(name = "description")
    private String description;

    //@Min(0)
    @Column(name = "price", columnDefinition = "decimal (10,2)")
    private BigDecimal price;
}