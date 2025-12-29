package com.mitocode.microservice.product_service.model.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "product")
public class ProductEntity {

    @Id
    private String productId;
    private String productName;
    private String productType;
    private Long price;
    private Integer stock;

}
