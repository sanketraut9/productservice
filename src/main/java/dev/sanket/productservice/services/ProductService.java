package dev.sanket.productservice.services;

import dev.sanket.productservice.dtos.GenericProductDto;
import dev.sanket.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    public List<GenericProductDto> getAllProducts();

    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    public GenericProductDto deleteProduct(Long id);
    GenericProductDto updateProductById(Long id, GenericProductDto updatedProduct);
}
