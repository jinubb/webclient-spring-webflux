package com.webflux.api.government.client.subway;

import com.webflux.api.government.client.GovernmentClient;
import com.webflux.api.government.client.subway.dto.SubwayInfoClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SubwayClient extends GovernmentClient {

    private final ParameterizedTypeReference<SubwayInfoClientDto> SubwayInfoType = new ParameterizedTypeReference<>() {
    };

    private final SubwayUri subwayUri;

    public Mono<List<SubwayInfoClientDto.RealtimeArrival>> requestSubwayInfo(String text) {
        return super.callWebClientApi(HttpMethod.GET, subwayUri.getSearchSubwayInfo(text), SubwayInfoType)
                .onErrorResume(Mono::error)
                .mapNotNull(SubwayInfoClientDto::getRealtimeArrivals);
    }

}
