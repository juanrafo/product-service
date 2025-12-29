package com.mitocode.microservice.product_service.model.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class ProductDTO {

    @Id
    private String productId;
    private String productName;
    private String productType;
    private Long price;
    private Integer stock;
    private Integer port;

}
