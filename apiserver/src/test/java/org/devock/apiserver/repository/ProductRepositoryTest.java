package org.devock.apiserver.repository;

import java.util.UUID;

import org.devock.apiserver.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testInsert() {
        Product product = Product.builder()
                .pname("Test")
                .pdesc("Test Desc")
                .price(1000).build();

        product.addImageString(UUID.randomUUID() + "_" + "image1.png");
        product.addImageString(UUID.randomUUID() + "_" + "image2.png");

        productRepository.save(product);
    }

}
