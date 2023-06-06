package com.webflux.api.government;

import com.webflux.api.government.application.GovernmentService;
import com.webflux.api.government.dto.response.ReactiveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @link <a href="https://www.data.go.kr/data/15080662/openapi.do">경기도 버스노선 조회 open API</a>
 */
@Component
@RequiredArgsConstructor
public class GovernmentHandler {

    private final GovernmentService governmentService;

    /**
     * 노선정보 항목 조회
     * <p>
     *   노선ID에 해당하는 노선의 기본 정보 및 배차 정보를 조회한다
     * </p>
     */
    public Mono<ServerResponse> getBusRouteInfoItem(ServerRequest serverRequest) {
        return ReactiveResponse.success(governmentService.getBusRouteInfoItem(serverRequest));
    }

    public Mono<ServerResponse> getBusRouteStationList(ServerRequest serverRequest) {
        return ReactiveResponse.success(governmentService.getBusRouteStationList(serverRequest));
    }

    public Mono<ServerResponse> getBusRouteList(ServerRequest serverRequest) {
        return ReactiveResponse.success(governmentService.getBusRouteList(serverRequest));
    }

    public Mono<ServerResponse> getAreaBusRouteList(ServerRequest serverRequest) {
        return ReactiveResponse.success(governmentService.getAreaBusRouteList(serverRequest));
    }

    public Mono<ServerResponse> getBusRouteLineList(ServerRequest serverRequest) {
        return ReactiveResponse.success(governmentService.getBusRouteLineList(serverRequest));
    }
}
