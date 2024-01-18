package dev.sanket.productservice.services;

import dev.sanket.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    public List<GenericProductDto> getAllProducts();

    public GenericProductDto getProductById(Long id);

    public GenericProductDto createProduct(GenericProductDto genericProductDto);


}
