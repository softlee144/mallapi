package org.devock.apiserver.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// getter, setter 동시 충족
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;

    private String title;

    private String content;

    private String writer;

    private boolean complete;

    private LocalDate dueDate;
}
