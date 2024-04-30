package com.rminaya.mapstructlombokdemo.test;

import com.rminaya.mapstructlombokdemo.dto.GetProduct;
import com.rminaya.mapstructlombokdemo.entity.Product;
import com.rminaya.mapstructlombokdemo.mapper.ProductMapper;
import com.rminaya.mapstructlombokdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// Esta clase inyectará beans del tipo CommandLineRunner
// Es decir, en vez de implementarlo comúnmente en la clase principal, implementaremos su método "run"
@Configuration
public class InitDatabaseProducts {

    @Autowired
    private ProductRepository productRepository;

    // Inyectamos el mapper
    // Opcion 1 CON Spring
    @Autowired
    private ProductMapper productMapper;

    // Opcion 2 SIN Spring
    //private ProductMapper productMapper = ProductMapper.INSTANCE;

    @Bean
    public CommandLineRunner testProductmapperCommand() {
        return args -> {
            // Listamos los productos ENTITY
            List<Product> products = this.productRepository.findAll();
            System.out.println("------------------- PRODUCTS -------------------");

            products.forEach(System.out::println);
            // Listamos los productos DTO
            System.out.println("------------------- PRODUCTS DTO -------------------");
            //products.forEach(product -> System.out.println(this.productMapper.productoToGetDTO(product)));
            List<GetProduct> getProductList = this.productMapper.toGetProductList(products);
            getProductList.forEach(System.out::println);

            System.out.println("------------------- MAPPED PRODUCTS -------------------");
            List<Product> mappedProducts = this.productMapper.toEntityList(getProductList);
            mappedProducts.forEach(System.out::println);
        };
    }

}
