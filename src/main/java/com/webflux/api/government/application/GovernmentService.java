package com.webflux.api.government.application;

import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

public class GovernmentService {

    public Mono<?> getBusRouteInfoItem(ServerRequest serverRequest) {
        return Mono.empty();
    }

    public Mono<?> getBusRouteStationList(ServerRequest serverRequest) {
        return Mono.empty();
    }

    public Mono<?> getBusRouteList(ServerRequest serverRequest) {
        return Mono.empty();
    }

    public Mono<?> getAreaBusRouteList(ServerRequest serverRequest) {
        return Mono.empty();
    }

    public Mono<?> getBusRouteLineList(ServerRequest serverRequest) {
        return Mono.empty();
    }
}
