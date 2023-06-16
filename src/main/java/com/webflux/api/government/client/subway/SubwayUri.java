package com.webflux.api.government.client.subway;

import com.webflux.api.government.client.GovernmentUri;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("government.client.subway.uri")
public class SubwayUri extends GovernmentUri {

    private final String searchSTNBySubwayLineInfo;

    public SubwayUri(String host, Integer port, String searchSTNBySubwayLineInfo) {
        super(host, port);
        this.searchSTNBySubwayLineInfo = searchSTNBySubwayLineInfo;
    }
}
