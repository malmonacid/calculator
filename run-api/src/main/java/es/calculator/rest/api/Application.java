package es.calculator.rest.api;

import es.calculator.rest.api.domain.model.OperationType;
import es.calculator.rest.api.domain.strategy.OperationStrategy;
import es.calculator.rest.api.domain.strategy.impl.AdditionStrategy;
import es.calculator.rest.api.domain.strategy.impl.SubtractionStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
@ConfigurationPropertiesScan
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Map<OperationType, OperationStrategy> operationStrategies(
            AdditionStrategy additionStrategy,
            SubtractionStrategy subtractionStrategy) {
        return Map.of(
                OperationType.SUM, additionStrategy,
                OperationType.SUBTRACTION, subtractionStrategy
        );
    }

}
