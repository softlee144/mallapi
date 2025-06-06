package org.devock.apiserver.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {

    private String fileName;
    // 대표 이미지 설정을 위한 순번
    private int ord;

    public void setOrd(int ord) {
        this.ord = ord;
    }
}
