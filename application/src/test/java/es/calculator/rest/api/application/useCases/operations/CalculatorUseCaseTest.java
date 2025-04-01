package es.calculator.rest.api.application.useCases.operations;

import es.calculator.rest.api.domain.model.Operation;
import es.calculator.rest.api.domain.model.OperationOut;
import es.calculator.rest.api.domain.model.OperationType;
import es.calculator.rest.api.domain.strategy.OperationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CalculatorUseCaseTest {

    @InjectMocks
    private CalculatorUseCase calculatorUseCase;

    @Mock
    private Map<OperationType, OperationStrategy> operationStrategies;

    @Mock
    private OperationStrategy additionStrategy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calculate_shouldReturnCorrectResultForAddition() {
        // Arrange
        final BigDecimal num1 = BigDecimal.valueOf(10);
        final BigDecimal num2 = BigDecimal.valueOf(5);
        final OperationType operationType = OperationType.SUM;
        final Operation operation = Operation.builder().operand1(num1).operand2(num2).operationType(operationType).build();

        when(this.operationStrategies.get(operationType)).thenReturn(this.additionStrategy);
        when(this.additionStrategy.calculate(num1, num2)).thenReturn(BigDecimal.valueOf(15));

        // Act
        final OperationOut result = this.calculatorUseCase.calculate(operation);

        // Assert
        assertEquals(BigDecimal.valueOf(15), result.getResult());
    }

}

