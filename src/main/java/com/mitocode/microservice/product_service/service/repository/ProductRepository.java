package com.mitocode.microservice.product_service.service.repository;

import com.mitocode.microservice.product_service.model.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, String> {
}
