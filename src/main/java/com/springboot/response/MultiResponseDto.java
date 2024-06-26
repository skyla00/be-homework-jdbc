package com.springboot.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

//getter 가 없으면, 조회가 안됨. dto 에는 꼭 넣어주어야 함!
@Getter
@NoArgsConstructor
public class MultiResponseDto<T> {
    // 제네릭을 쓰는 이유: 타입을 제한하기 위해서. 타입 매개변수가 지금 list에 쓰임. 타입매개변수만 써도 반환하는 건 list.

    private List<T> data;
    private PageInfo pageInfo;

//    public MultiResponseDto(List<T> data, PageInfo pageInfo) {
//        this.data = data;
//        this.pageInfo = pageInfo;
//    }

    public MultiResponseDto(List<T> data, Page page) {
        this.data = data;
        this.pageInfo = new PageInfo(page.getNumber() + 1, page.getSize(),
                page.getTotalElements(), page.getTotalPages());
    }
}