package org.devock.apiserver.repository;

import org.devock.apiserver.domain.Todo;
import org.devock.apiserver.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {

}
