package com.mitocode.microservice.product_service.service;

import com.mitocode.microservice.product_service.model.dto.ProductDTO;
import com.mitocode.microservice.product_service.service.repository.ProductRepository;
import com.mitocode.microservice.product_service.util.KafkaUtil;
import com.mitocode.microservices.commonmodels.model.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Value("${server.port}")
    private Integer port;

    private final KafkaUtil kafkaUtil;

    public List<ProductDTO> getAllProducts() {

        Iterable<ProductEntity> itProducts = productRepository.findAll();

        kafkaUtil.sendMessage("Kafka Send Message - Fetched all products from port: " + port);

        return StreamSupport.stream(itProducts.spliterator(), false).map(productEntity -> {
            ProductDTO productDTO = ProductDTO.builder().build();
            BeanUtils.copyProperties(productEntity, productDTO);
            productDTO.setPort(port);
            return productDTO;
        }).collect(Collectors.toList());


    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = ProductEntity.builder().build();
        BeanUtils.copyProperties(productDTO, productEntity);
        ProductEntity savedProduct = productRepository.save(productEntity);
        ProductDTO savedProductDTO = ProductDTO.builder().build();
        BeanUtils.copyProperties(savedProduct, savedProductDTO);
        savedProductDTO.setPort(port);
        return savedProductDTO;
    }

}
