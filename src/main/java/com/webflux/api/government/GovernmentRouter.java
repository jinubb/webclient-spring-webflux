package com.webflux.api.government;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GovernmentRouter {

    @Bean
    public RouterFunction<ServerResponse> routeProductApi(final GovernmentHandler governmentHandler) {
        return RouterFunctions.route()
            .GET("/government/bus/route/info/item", governmentHandler::getBusRouteInfoItem)
            .GET("/government/bus/route/station/list", governmentHandler::getBusRouteStationList)
            .GET("/government/bus/route/list", governmentHandler::getBusRouteList)
            .GET("/government/area/bus/route/list", governmentHandler::getAreaBusRouteList)
            .GET("/government/bus/route/line/list", governmentHandler::getBusRouteLineList)
            .build();
    }
}