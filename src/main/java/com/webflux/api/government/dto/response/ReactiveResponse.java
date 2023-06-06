package com.webflux.api.government.dto.response;

import com.webflux.api.government.dto.response.ResponseContainer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class ReactiveResponse {

    private ReactiveResponse() {
    }

    /**
     * 응답 데이터를 받아 서버 응답 구조로 반환한다.
     *
     * @param object 응답 DTO
     */
    public static Mono<ServerResponse> success(Mono<?> object) {
        return object.map(ResponseContainer::new)
            .flatMap(data -> ServerResponse.ok()
                .body(BodyInserters.fromValue(data)));
    }

}
