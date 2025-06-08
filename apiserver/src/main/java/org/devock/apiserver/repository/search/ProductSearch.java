package org.devock.apiserver.repository.search;

import org.devock.apiserver.dto.PageRequestDTO;
import org.devock.apiserver.dto.PageResponseDTO;
import org.devock.apiserver.dto.ProductDTO;

public interface ProductSearch {

    PageResponseDTO<ProductDTO> searchList(PageRequestDTO pageRequestDTO);

}
