package com.example.onlineshopping.product;


import com.example.onlineshopping.product.dto.ProductCreateDto;
import com.example.onlineshopping.product.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService productService;

    @PostMapping
    public ProductResponseDto create(@RequestBody ProductCreateDto productCreateDto){
        return productService.create(productCreateDto);
    }

    @GetMapping("/{productId}")
    public ProductResponseDto get(@PathVariable("productId") UUID id){
        return productService.get(id);
    }

    @GetMapping
    public List<ProductResponseDto> getAll(){
        return productService.getAll();
    }

    @PutMapping
    public ProductResponseDto update(@RequestBody ProductCreateDto productCreateDto , UUID id){
        return productService.update(productCreateDto ,id);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable("productId") UUID id){
        productService.delete(id);
    }
}
