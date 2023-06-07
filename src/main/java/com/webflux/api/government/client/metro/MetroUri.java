package com.webflux.api.government.client.metro;

import com.webflux.api.government.client.GovernmentUri;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("government.client.metro.uri")
public class MetroUri extends GovernmentUri {

    private final String searchSTNBySubwayLineInfo;

    public MetroUri(String host, Integer port, String searchSTNBySubwayLineInfo) {
        super(host, port);
        this.searchSTNBySubwayLineInfo = searchSTNBySubwayLineInfo;
    }
}
