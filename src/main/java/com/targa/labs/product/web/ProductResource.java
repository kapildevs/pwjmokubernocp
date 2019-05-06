package com.targa.labs.product.web;

import com.targa.labs.commons.utils.Web;
import com.targa.labs.product.service.ProductService;
import com.targa.labs.commons.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Web.API + "/products")
public class ProductResource {
    private final ProductService productService;
    @GetMapping
    public List<ProductDto> findAll() {
        return this.productService.findAll();
    }
    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return this.productService.findById(id);
    }
    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return this.productService.create(productDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.productService.delete(id);
    }
}