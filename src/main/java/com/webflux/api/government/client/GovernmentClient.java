package com.webflux.api.government.client;

import java.net.URI;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Slf4j
public class GovernmentClient {

    private static final Integer BUFFER_MAX_SIZE = 10 * 1024 * 1024; // 10M
    private WebClient webClient;

    /**
     * <pre>
     * WebClient 옵션
     * - ExchangeStrategies : 버퍼 사이즈 설정
     *
     * </pre>
     */
    @PostConstruct
    private void init() {
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
            .codecs(configurer -> configurer.defaultCodecs()
                .maxInMemorySize(BUFFER_MAX_SIZE)) // default 256K
            .build();

        webClient = WebClient.builder()
            .exchangeStrategies(exchangeStrategies)
            .build();
    }

    /**
     * WebClient API 요청
     *
     * @param httpMethod                 HTTP 요청 방식
     * @param uri                        URI
     * @param parameterizedTypeReference 반환 타입
     */
    protected <T> Mono<T> callWebClientApi(HttpMethod httpMethod, URI uri,
        ParameterizedTypeReference<T> parameterizedTypeReference) {
        return webClient.method(httpMethod)
            .uri(uri)
            .retrieve()
            .bodyToMono(parameterizedTypeReference)
            // TODO : 오류 트래킹이 가능하도록 sentry로 오류 정보를 더 많이 담아 보내도록 변경
            .doOnError(throwable -> log.error("WebClient Error occurred at : {} ", throwable.getLocalizedMessage()));
    }

    /**
     * WebClient API 요청
     *
     * @param httpMethod                 HTTP 요청 방식
     * @param uri                        URI
     * @param parameterizedTypeReference 반환 타입
     * @param authorization              세션 key
     */
    protected <T> Mono<T> callWebClientApi(HttpMethod httpMethod, URI uri,
        ParameterizedTypeReference<T> parameterizedTypeReference, String authorization) {
        return webClient.method(httpMethod)
            .uri(uri)
            .header("authorization", authorization)
            .retrieve()
            .bodyToMono(parameterizedTypeReference)
            // TODO : 오류 트래킹이 가능하도록 sentry로 오류 정보를 더 많이 담아 보내도록 변경
            .doOnError(throwable -> log.error("WebClient Error occurred at : {} ", throwable.getLocalizedMessage()));
    }

    /**
     * 요청 본문을 포함한 WebClient API 요청
     *
     * @param httpMethod                 HTTP 요청 방식
     * @param uri                        URI
     * @param parameterizedTypeReference 반환 타입
     * @param requestBody                요청 본문
     */
    protected <T> Mono<T> callWebClientApi(HttpMethod httpMethod, URI uri,
        ParameterizedTypeReference<T> parameterizedTypeReference, Object requestBody) {
        return webClient.method(httpMethod)
            .uri(uri)
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(parameterizedTypeReference)
            .doOnError(throwable -> log.error("WebClient Error occurred at : {} ", throwable.getLocalizedMessage()));
    }
}
