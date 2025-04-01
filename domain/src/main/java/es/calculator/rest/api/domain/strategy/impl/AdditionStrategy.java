package es.calculator.rest.api.domain.strategy.impl;

import es.calculator.rest.api.domain.strategy.OperationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AdditionStrategy implements OperationStrategy {
    @Override
    public BigDecimal calculate(BigDecimal num1, BigDecimal num2) {
        return num1.add(num2);
    }
}
