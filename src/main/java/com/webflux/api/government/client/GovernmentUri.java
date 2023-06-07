package com.webflux.api.government.client;

import java.net.URI;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
public class GovernmentUri {


    private static final int HTTPS_PORT = 443;
    private static final int HTTP_PORT = 80;


    private final String host;

    private final Integer port;

    public GovernmentUri(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    /**
     * HTTP 기본 URI 반환
     */
    private String getBaseUri() {
        if (this.port == HTTPS_PORT) {
            return String.format("https://%s", host);
        } else if (this.port == HTTP_PORT) {
            return String.format("http://%s", host);
        } else {
            return String.format("http://%s:%s", host, port);
        }
    }

    /**
     * 요청 URI 반환
     */
    public URI toUri(String uriString) {
        return UriComponentsBuilder.fromUriString(String.format("%s/%s", getBaseUri(), uriString))
            .encode()
            .build()
            .toUri();
    }

    /**
     * 쿼리 파라미터를 포함한 URI 생성
     */
    public URI toUri(String uriString, MultiValueMap<String, String> params) {
        return UriComponentsBuilder.fromUriString(String.format("%s/%s", getBaseUri(), uriString))
            .queryParams(params)
            .encode()
            .build()
            .toUri();
    }
}
