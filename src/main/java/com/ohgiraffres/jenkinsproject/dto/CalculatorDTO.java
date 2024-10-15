package com.ohgiraffres.jenkinsproject.dto;

import lombok.*;

// @Data로 만들면 필요없는 메서드? 도 만들어짐 (hashcode, equal 같은 것 & setter 지양)
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class CalculatorDTO {

    @NonNull // -> RequiredArgsConstructor 만들때 사용 (num1, num2 초기화하는 생성자 만들어짐)
    private int num1;

    @NonNull
    private int num2;
    private int sum;

}
