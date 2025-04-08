package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        //create categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));

        // create product
        //1st product
        Product phone = new Product();
        phone.setName("smartPhone");
        phone.setDescription("Latest model smartPhone with amazing features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);
        //2nd product

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High-Performance Laptop for work and play");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);
        //3rd product
        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("warm and cozy jacket for winter.");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(129.99);
        jacket.setCategory(clothing);
        //4th
        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High-Speed Blender for smooothies and more");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(89.99);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,blender));
    }
}
