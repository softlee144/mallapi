package org.devock.apiserver.repository.search;

import java.util.List;

import org.devock.apiserver.domain.Product;
import org.devock.apiserver.domain.QProduct;
import org.devock.apiserver.domain.QProductImage;
import org.devock.apiserver.dto.PageRequestDTO;
import org.devock.apiserver.dto.PageResponseDTO;
import org.devock.apiserver.dto.ProductDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.jpa.JPQLQuery;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProductSearchImpl extends QuerydslRepositorySupport implements ProductSearch {

    public ProductSearchImpl() {
        super(ProductSearch.class);
    }

    @Override
    public PageResponseDTO<ProductDTO> searchList(PageRequestDTO pageRequestDTO) {

        log.info("================================= searchList =============================");

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() - 1, // 페이지 번호는 0부터 시작하므로 -1
                pageRequestDTO.getSize(),
                Sort.by("pno").descending());

        QProduct product = QProduct.product;
        QProductImage productImage = QProductImage.productImage;

        JPQLQuery<Product> query = from(product);

        // 대표 이미지(ord = 0)만 조인
        query.leftJoin(product.imageList, productImage)
                .where(productImage.ord.eq(0));

        // 페이징 적용
        getQuerydsl().applyPagination(pageable, query);

        // 결과 조회
        List<Product> productList = query.fetch();

        // 전체 개수 조회
        long count = query.fetchCount();

        // 로그 출력
        log.info("===================================");
        log.info(productList);

        return null;
    }
}
