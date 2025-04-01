package es.calculator.rest.api.domain.ports.in;

import es.calculator.rest.api.domain.model.Operation;
import es.calculator.rest.api.domain.model.OperationOut;

public interface OperationServicePort {
    OperationOut calculate(Operation operation);
}
