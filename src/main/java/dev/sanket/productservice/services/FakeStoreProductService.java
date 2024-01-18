package dev.sanket.productservice.services;

import dev.sanket.productservice.dtos.FakeStoreProductDto;
import dev.sanket.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private String produtUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductUrl = "https://fakestoreapi.com/products/";
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService (RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }


    public List<GenericProductDto> getAllProducts(){
        System.out.println("Getting all products");

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> response = restTemplate
                .getForEntity(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class
                );

        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();

        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            GenericProductDto genericProductDto = new GenericProductDto();

            genericProductDto.setId(fakeStoreProductDto.getId());
            genericProductDto.setDescription(fakeStoreProductDto.getDescription());
            genericProductDto.setTitle(fakeStoreProductDto.getTitle());
            genericProductDto.setImage(fakeStoreProductDto.getImage());
            genericProductDto.setCategary(fakeStoreProductDto.getCategary());
            genericProductDto.setPrice(fakeStoreProductDto.getPrice());

            genericProductDtos.add(genericProductDto);
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        System.out.println("Getting product by id");

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate
                .getForEntity(
                        produtUrl,
                        FakeStoreProductDto.class,
                        id
                );

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategary(fakeStoreProductDto.getCategary());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());

        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        System.out.println("Creating new Product");
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate
                .postForEntity(
                        createProductUrl,
                        product,
                        FakeStoreProductDto.class
                );

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategary(fakeStoreProductDto.getCategary());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());

        return genericProductDto;
    }
}
