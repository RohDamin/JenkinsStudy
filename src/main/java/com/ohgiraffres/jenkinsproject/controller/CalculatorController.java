package com.ohgiraffres.jenkinsproject.controller;

import com.ohgiraffres.jenkinsproject.dto.CalculatorDTO;
import com.ohgiraffres.jenkinsproject.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health")
    public String healthcheck() {
        return "I'm alive!!!";
    }

    @GetMapping("/plus")
    public ResponseEntity<CalculatorDTO> plusTwoNumbers(CalculatorDTO calculatorDTO) { // 쿼리스트링 형태로 값 받음
        log.info("*** plus 핸들러 실행여부 및 값 확인: " + calculatorDTO);

        /* service 계층에서 더한 값이 돌아오면 */
        int result = calculatorService.plusTwoNumbers(calculatorDTO);

        /* response body에 담길 CalculatorDTO의 sum에 추가한다 */
        calculatorDTO.setSum(result);

        return ResponseEntity
                .ok()
                .body(calculatorDTO);
    }
}