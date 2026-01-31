package com.mitocode.microservice.product_service.expose.web;

import com.mitocode.microservice.product_service.model.dto.ProductDTO;
import com.mitocode.microservice.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProducts()  throws InterruptedException{
        TimeUnit.SECONDS.sleep(2L);
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/product/{flag}")
    public ResponseEntity<List<ProductDTO>> getAllProductsWithFlag(@PathVariable("flag") boolean flag)  throws Exception{
        if(flag) {
            throw new Exception("Probando CB");
        }
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/product/parameter")
    public ResponseEntity<List<ProductDTO>> getAllProductsWithParam(@RequestParam("tokens") String flag) {
        log.info(flag);
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

}