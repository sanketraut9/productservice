package dev.sanket.productservice.cotroller;

import dev.sanket.productservice.dtos.GenericProductDto;
import dev.sanket.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController (@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return (List<GenericProductDto>) productService.getAllProducts();
    }

    @GetMapping("{id}")
    public GenericProductDto getProductBId(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PostMapping()
    public GenericProductDto createProduct(GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }
}
