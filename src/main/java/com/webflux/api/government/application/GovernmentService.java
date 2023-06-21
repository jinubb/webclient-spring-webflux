package com.webflux.api.government.application;

import com.webflux.api.government.client.subway.SubwayClient;
import com.webflux.api.government.dto.response.SubwayArrivalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class GovernmentService {

    private final SubwayClient subwayClient;

    public Flux<SubwayArrivalDto> getSubwayArrival(ServerRequest serverRequest) {
        return subwayClient.requestSubwayInfo(serverRequest.queryParam("text")
                        .orElseThrow(() -> new IllegalArgumentException("Request query must be \"text\"")))
                .flatMapMany(Flux::fromIterable)
                .map(subwayInfoClientDto -> SubwayArrivalDto.builder()
                        .statnId(subwayInfoClientDto.getStatnId())
                        .statnNm(subwayInfoClientDto.getStatnNm())
                        .recptnDt(subwayInfoClientDto.getRecptnDt())
                        .trainLineNm(subwayInfoClientDto.getTrainLineNm())
                        .subwayId(subwayInfoClientDto.getSubwayId())
                        .arvlCd(subwayInfoClientDto.getArvlCd())
                        .arvlMsg2(subwayInfoClientDto.getArvlMsg2())
                        .arvlMsg3(subwayInfoClientDto.getArvlMsg3())
                        .build());
    }
}
