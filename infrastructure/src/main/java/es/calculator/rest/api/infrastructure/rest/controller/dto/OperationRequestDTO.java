package es.calculator.rest.api.infrastructure.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationRequestDTO {
    private int num1;
    private int num2;
    private String operation;
}