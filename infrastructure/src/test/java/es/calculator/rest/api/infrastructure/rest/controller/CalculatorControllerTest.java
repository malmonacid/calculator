package es.calculator.rest.api.infrastructure.rest.controller;

import es.calculator.rest.api.domain.ports.in.OperationServicePort;
import es.calculator.rest.api.infrastructure.rest.controller.controller.CalculatorController;
import es.calculator.rest.api.infrastructure.rest.controller.mapper.OperationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.OperationRequestDTO;
import org.openapitools.model.OperationResponseDTO;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {

    @Mock
    private OperationServicePort operationServicePort;

    @Mock
    private OperationMapper operationMapper;

    @InjectMocks
    private CalculatorController calculatorController;

    private OperationRequestDTO operationRequestDTO;
    private OperationResponseDTO operationResponseDTO;

    @BeforeEach
    public void setUp() {
        this.operationRequestDTO = new OperationRequestDTO();
        this.operationRequestDTO.setOperand1(BigDecimal.valueOf(10));
        this.operationRequestDTO.setOperand2(BigDecimal.valueOf(5));
        this.operationRequestDTO.setOperation(OperationRequestDTO.OperationEnum.SUM);

        this.operationResponseDTO = new OperationResponseDTO();
        this.operationResponseDTO.setResult(BigDecimal.valueOf(15.0));
    }

    @Test
    public void testPerformOperation_success() {
        // Setup Mock behavior
        when(this.operationMapper.toResponse(any())).thenReturn(this.operationResponseDTO);

        // Call the controller method
        final ResponseEntity<OperationResponseDTO> response = this.calculatorController.performOperation(this.operationRequestDTO);

        // Verify the result
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(BigDecimal.valueOf(15.0), response.getBody().getResult());

        // Verify that the methods in the service and mapper were called
        verify(this.operationMapper, times(1)).toDomain(this.operationRequestDTO);
        verify(this.operationServicePort, times(1)).calculate(any());
        verify(this.operationMapper, times(1)).toResponse(any());
    }
}
