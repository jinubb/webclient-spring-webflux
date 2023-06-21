package com.webflux.api.government;

import com.webflux.api.government.dto.response.SubwayArrivalDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GovernmentRouter {

    @Bean
    @RouterOperations(
            {
                    @RouterOperation(
                            path = "/government/subway/arrival",
                            produces = {MediaType.APPLICATION_JSON_VALUE},
                            method = RequestMethod.GET,
                            beanClass = GovernmentHandler.class,
                            beanMethod = "getSubwayArrival",
                            operation = @Operation(operationId = "getSubwayArrival",
                                    parameters = {
                                            @Parameter(in = ParameterIn.QUERY, name = "text", example = "신사", required = true),
                                    },
                                    responses = {
                                            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = SubwayArrivalDto.class)))
                                    }
                            )
                    )
            }
    )
    public RouterFunction<ServerResponse> routeProductApi(final GovernmentHandler governmentHandler) {
        return RouterFunctions.route()
                .GET("/government/subway/arrival", governmentHandler::getSubwayArrival)
                .build();
    }
}
