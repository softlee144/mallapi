package org.devock.apiserver.service;

import org.devock.apiserver.dto.PageRequestDTO;
import org.devock.apiserver.dto.PageResponseDTO;
import org.devock.apiserver.dto.ProductDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface ProductService {
    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);

    Long register(ProductDTO productDTO);

    ProductDTO get(Long pno);

    // void modify(ProductDTO productDTO);

    // void remove(Long pno);
}
