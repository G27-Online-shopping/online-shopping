package com.example.onlineshopping.product;

import com.example.onlineshopping.product.dto.ProductCreateDto;
import com.example.onlineshopping.product.dto.ProductResponseDto;
import com.example.onlineshopping.product.entity.Product;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /*@PostConstruct
    public void init() {
        Product product = new Product(UUID.randomUUID(), "iPhone 15 pro max", 12, LocalDateTime.now(), LocalDateTime.now(),"https://imagineonline.store/cdn/shop/files/iPhone_15_Pro_Max_Blue_Titanium_PDP_Image_Position-1__en-IN_1445x.jpg?v=1694758834","Iphone 15 pro max black 256 Gb");
        productRepository.save(product);
        Product product1 = new Product(UUID.randomUUID(), "Kumho Balon", 12, LocalDateTime.now(), LocalDateTime.now(),"https://www.1010tires.com/images/tires/Kumho/KUMHO-SOLUS-TA11_lg_super.jpg","Kumho Slous 205/65/R15 Vse sezonni");
        productRepository.save(product1);
        Product product2 = new Product(UUID.randomUUID(), "T-Shirt", 12, LocalDateTime.now(), LocalDateTime.now(),"https://pbx2-pbww-prod-pbww-cdn.getprintbox.com/media/productimage/fe050866-8169-4645-ad76-10437425291c/Blank%20T-Shirt_thumb_900x900?mt=1588770269.372995","Xlopok 100% ");
       productRepository.save(product2);
    }*/

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public ProductResponseDto create(ProductCreateDto productCreateDto) {

        Product product = modelMapper.map(productCreateDto, Product.class);

        Product save = productRepository.save(product);

        return modelMapper.map(save, ProductResponseDto.class);
    }

    @Transactional
    public ProductResponseDto get(UUID id) {

        Product product = productRepository.findById(id).get();

        return modelMapper.map(product, ProductResponseDto.class);
    }

    @Transactional
    public List<ProductResponseDto> getAll() {

        List<Product> all = productRepository.findAll();

        return all.stream().map(product -> modelMapper.map(product,ProductResponseDto.class)).toList();
    }

    @Transactional
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public ProductResponseDto update(ProductCreateDto productCreateDto, UUID id) {

        Product product = productRepository.findById(id).get();
        modelMapper.map(product,productCreateDto);

        Product save = productRepository.save(product);

        return modelMapper.map(save, ProductResponseDto.class);
    }

    public Product getByName(String name) {
        return productRepository.findByName(name).get();
    }
}
