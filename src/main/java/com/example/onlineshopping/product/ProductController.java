package com.example.onlineshopping.product;


import com.example.onlineshopping.product.dto.ProductCreateDto;
import com.example.onlineshopping.product.dto.ProductResponseDto;
import com.example.onlineshopping.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService productService;


    @GetMapping("/")
    public String getTrendingProducts(Model model){
        List<ProductResponseDto> all = productService.getAll();
        model.addAttribute("products", all);
        System.out.println(all.get(1));
        return "index";
    }

    @GetMapping("/product")
    public String get(@RequestParam("name") String name,Model model){
        Product byName = productService.getByName(name);
        model.addAttribute("product",byName);
        return "product/product";
    }

//    @GetMapping("/")
//    public String getProduct( Model model){
//        List<ProductResponseDto> responseDtoList=productService.getAll();
//        model.addAttribute("products" , responseDtoList);
//        System.out.println(responseDtoList.get(1));
//        return "search";
//    }


    @PostMapping
    public ProductResponseDto create(@RequestBody ProductCreateDto productCreateDto){
        return productService.create(productCreateDto);
    }

   /* @GetMapping("/{productId}")
    public ProductResponseDto get(@PathVariable("productId") UUID id){
        return productService.get(id);
    }*/

    @GetMapping("/products")
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
    @GetMapping("/product/search")
    public void searchProducts( String name){
         productService.findByName(name);
    }
}
