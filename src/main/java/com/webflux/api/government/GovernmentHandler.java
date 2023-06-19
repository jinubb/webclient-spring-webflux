package com.webflux.api.government;

import com.webflux.api.government.application.GovernmentService;
import com.webflux.api.government.dto.response.ReactiveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GovernmentHandler {

    private final GovernmentService governmentService;

    public Mono<ServerResponse> getSubwayArrival(ServerRequest serverRequest) {
        return ReactiveResponse.success(governmentService.getSubwayArrival(serverRequest));
    }
}
