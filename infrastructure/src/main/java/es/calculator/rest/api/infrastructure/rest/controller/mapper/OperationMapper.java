package es.calculator.rest.api.infrastructure.rest.controller.mapper;

import es.calculator.rest.api.domain.model.Operation;
import es.calculator.rest.api.domain.model.OperationOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.OperationRequestDTO;
import org.openapitools.model.OperationResponseDTO;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    @Mapping(target = "operand1", source = "operand1")
    @Mapping(target = "operationType", source = "operation")
    Operation toDomain(OperationRequestDTO dto);

    OperationResponseDTO toResponse(OperationOut out);
}

