package org.devock.apiserver.repository.search;

import org.devock.apiserver.domain.Todo;
import org.devock.apiserver.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TodoSearch {

    Page<Todo> search1(PageRequestDTO pageRequestDTO);
}
