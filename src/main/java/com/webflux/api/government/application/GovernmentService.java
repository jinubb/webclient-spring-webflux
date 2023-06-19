package com.webflux.api.government.application;

import com.webflux.api.government.client.subway.SubwayClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GovernmentService {

    private final SubwayClient subwayClient;

    public Mono<?> getSubwayArrival(ServerRequest serverRequest) {
        return subwayClient.requestSubwayInfo(serverRequest.queryParam("text")
                        .orElseThrow(() -> new IllegalArgumentException("Request query must be \"text\"")))
                .onErrorResume(Mono::error);
    }
}
