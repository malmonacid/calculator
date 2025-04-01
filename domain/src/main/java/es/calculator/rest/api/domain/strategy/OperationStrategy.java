package es.calculator.rest.api.domain.strategy;

import java.math.BigDecimal;

@FunctionalInterface
public interface OperationStrategy {
    BigDecimal calculate(BigDecimal num1, BigDecimal num2);
}
