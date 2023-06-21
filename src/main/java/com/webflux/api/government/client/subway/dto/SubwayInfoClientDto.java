package com.webflux.api.government.client.subway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubwayInfoClientDto {

    private Object errorMessage;
    @JsonProperty("realtimeArrivalList")
    private List<RealtimeArrival> realtimeArrivals;

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RealtimeArrival {

        private String statnId; // 지하철역ID
        private String statnNm; // 지하철역명
        private String recptnDt; // 요청시간
        private String trainLineNm; // 도착지방면
        private String subwayId; // 호선 (1001:1호선, 1002:2호선, 1003:3호선, 1004:4호선, 1005:5호선 1006:6호선, 1007:7호선, 1008:8호선, 1009:9호선, 1061:중앙선1063:경의중앙선, 1065:공항철도, 1067:경춘선, 1075:수의분당선 1077:신분당선, 1092:우이신설선)
        private String arvlCd; // 도착코드 (0:진입, 1:도착, 2:출발, 3:전역출발, 4:전역진입, 5:전역도착, 99:운행중)
        private String arvlMsg2; // 첫번째도착메세지 (도착, 출발 , 진입 등)
        private String arvlMsg3; // 두번째도착메시지 (종합운동장 도착, 12분 후 (광명사거리) 등)
    }
}
