package dev.sanket.productservice.cotroller;

import dev.sanket.productservice.dtos.GenericProductDto;
import dev.sanket.productservice.exceptions.NotFoundException;
import dev.sanket.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public GenericProductDto getProductBId(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping()
    public GenericProductDto createProduct(GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProduct(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.resolve(200));
    }


    @PutMapping("{id}")
    public GenericProductDto updateProductById(@PathVariable("id") Long id,GenericProductDto updatedProduct){
        return productService.updateProductById(id,updatedProduct);
    }


    //This is specific to this controller
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException) {
//        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
//                HttpStatus.NOT_FOUND);
//    }

}
