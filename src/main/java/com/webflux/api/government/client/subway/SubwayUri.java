package com.webflux.api.government.client.subway;

import com.webflux.api.government.client.GovernmentUri;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.net.URI;

@ConstructorBinding
@ConfigurationProperties("client.government.subway")
public class SubwayUri extends GovernmentUri {

    private final String searchSubwayArrival;

    public SubwayUri(String host, Integer port, String searchSubwayArrival) {
        super(host, port);
        this.searchSubwayArrival = searchSubwayArrival;
    }

    public URI getSearchSubwayInfo(String text) {
        return super.toUri(this.searchSubwayArrival.replaceFirst("#1", text));
    }
}
