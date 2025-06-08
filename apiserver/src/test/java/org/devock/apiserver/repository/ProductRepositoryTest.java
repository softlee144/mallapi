package org.devock.apiserver.repository;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.devock.apiserver.domain.Product;
import org.devock.apiserver.dto.PageRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testInsert() {

        for (int i = 0; i < 10; i++) {
            Product product = Product.builder()
                    .pname("Test2")
                    .pdesc("Test2 Desc")
                    .price(1000).build();

            product.addImageString(UUID.randomUUID() + "_" + "image1.png");
            product.addImageString(UUID.randomUUID() + "_" + "image2.png");

            productRepository.save(product);
        }

    }

    @Test
    public void testRead2() {
        Long pno = 1L;

        Optional<Product> result = productRepository.selectOne(pno);

        Product product = result.orElseThrow();

        log.info(product);

        log.info(product.getImageList());
    }

    @Commit
    @Transactional
    @Test
    public void testDelete() {
        Long pno = 2L;
        productRepository.updateToDelete(pno, true);
    }

    @Test
    public void testUpdate() {
        Product product = productRepository.selectOne(1L).get();

        product.changePrice(3000);

        product.clearList();

        product.addImageString(UUID.randomUUID() + "_" + "pimage1.png");
        product.addImageString(UUID.randomUUID() + "_" + "pimage2.png");
        product.addImageString(UUID.randomUUID() + "_" + "pimage2.png");

        productRepository.save(product);

    }

    @Test
    public void testList() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());

        Page<Object[]> result = productRepository.selectList(pageable);

        result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));
    }

    // @Test
    // public void testSearch() {
    // PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

    // productRepository.searchList(pageRequestDTO);
    // }

}
