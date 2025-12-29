package com.mitocode.microservice.product_service.expose.web;

import com.mitocode.microservice.product_service.model.dto.ProductDTO;
import com.mitocode.microservice.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestHeader("token") String flag)  {
        log.info(flag);
        return ResponseEntity.ok(productService.getAllProducts());
    }

     @GetMapping("/product/parameter")
    public ResponseEntity<List<ProductDTO>> getAllProductsWithParam(@RequestParam("tokens") String flag) {
        log.info(flag);
        return ResponseEntity.ok(productService.getAllProducts());
    } 

}