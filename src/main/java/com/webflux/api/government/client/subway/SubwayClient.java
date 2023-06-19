package com.webflux.api.government.client.subway;

import com.webflux.api.government.client.GovernmentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class SubwayClient extends GovernmentClient {

    private final ParameterizedTypeReference<Object> objectType = new ParameterizedTypeReference<>() {
    };

    private final SubwayUri subwayUri;

    public Mono<Object> requestSubwayInfo(String text) {
        return super.callWebClientApi(HttpMethod.GET, subwayUri.getSearchSubwayInfo(text), objectType);
    }

}
