package com.example.onlineshopping.product;

import com.example.onlineshopping.product.dto.ProductCreateDto;
import com.example.onlineshopping.product.dto.ProductResponseDto;
import com.example.onlineshopping.product.entity.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public ProductResponseDto create(ProductCreateDto productCreateDto) {

//        Product product = new Product();
//        product.setName(productCreateDto.getName());
//        product.setPrice(productCreateDto.getPrice());
//        product.setDateOfManufacture(productCreateDto.getDateOfManufacture());
//        product.setExpirationDate(productCreateDto.getExpirationDate());

        Product product = modelMapper.map(productCreateDto, Product.class);

        productRepository.save(product);

        return new ProductResponseDto(product.getId(),product.getName(),product.getPrice() , product.getDateOfManufacture(),product.getExpirationDate());
    }

    @Transactional
    public ProductResponseDto get(UUID id) {

        Product product = productRepository.findById(id).get();

        return new ProductResponseDto(product.getId(),product.getName(),product.getPrice() , product.getDateOfManufacture(),product.getExpirationDate());
    }

    @Transactional
    public List<ProductResponseDto> getAll() {

        List<Product> all = productRepository.findAll();

        return all.stream().map(product -> new ProductResponseDto(product.getId(),
                product.getName(),product.getPrice(), product.getDateOfManufacture() , product.getExpirationDate())).toList();

    }

    @Transactional
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public ProductResponseDto update(ProductCreateDto productCreateDto, UUID id) {

        Product product = productRepository.findById(id).get();
        product.setName(productCreateDto.getName());
        product.setPrice(productCreateDto.getPrice());
        product.setDateOfManufacture(productCreateDto.getDateOfManufacture());
        product.setExpirationDate(productCreateDto.getExpirationDate());

        productRepository.save(product);

        return new ProductResponseDto(product.getId(),product.getName(),product.getPrice(),product.getDateOfManufacture(),product.getExpirationDate());

    }
}
