package es.calculator.rest.api.infrastructure.rest.controller.controller;

import es.calculator.rest.api.domain.ports.in.OperationServicePort;
import es.calculator.rest.api.infrastructure.rest.controller.mapper.OperationMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.ApiApi;
import org.openapitools.model.OperationRequestDTO;
import org.openapitools.model.OperationResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@AllArgsConstructor
@Slf4j
@Validated
public class CalculatorController implements ApiApi {

    private final OperationServicePort operationServicePort;
    private final OperationMapper operationMapper;


    @Override
    @PostMapping(value = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperationResponseDTO> performOperation(@RequestBody OperationRequestDTO operationRequestDTO) {
        log.info("[CalculatorController - /performOperation] Perform calculate operation with body: {}",
                operationRequestDTO);
        return ResponseEntity.ok(this.operationMapper.toResponse(
                this.operationServicePort.calculate(this.operationMapper.toDomain(operationRequestDTO))));
    }
}

