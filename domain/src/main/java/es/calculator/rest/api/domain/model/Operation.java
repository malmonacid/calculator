package es.calculator.rest.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    private BigDecimal operand1;
    private BigDecimal operand2;
    private OperationType operationType;
    private BigDecimal result;
}
