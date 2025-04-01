package es.calculator.rest.api.application.useCases.operations;


import es.calculator.rest.api.domain.model.Operation;
import es.calculator.rest.api.domain.model.OperationOut;
import es.calculator.rest.api.domain.model.OperationType;
import es.calculator.rest.api.domain.ports.in.OperationServicePort;
import es.calculator.rest.api.domain.strategy.OperationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CalculatorUseCase implements OperationServicePort {

    private final Map<OperationType, OperationStrategy> operationStrategies;

    @Override
    public OperationOut calculate(Operation operation) {
        try {
            final var strategy = this.operationStrategies.get(operation.getOperationType());

            if (strategy == null) {
                throw new UnsupportedOperationException("Operation not supported: " + operation.getOperationType());
            }

            final BigDecimal result = strategy.calculate(operation.getOperand1(), operation.getOperand2());
            return new OperationOut(result, "Operation executed successfully");

        } catch (final RuntimeException e) {
            throw new UnsupportedOperationException("Unexpected exception:" + e.getMessage());
        }
    }
}
