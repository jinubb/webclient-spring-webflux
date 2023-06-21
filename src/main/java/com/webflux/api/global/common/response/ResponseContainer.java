package com.webflux.api.global.common.response;

import lombok.Getter;

@Getter
public class ResponseContainer<T> {

    private static final int SUCCESS = 0;
    private static final int FAIL = 0;

    private final int status;
    private final String message;
    private T data;

    /**
     * 성공 응답
     */
    public ResponseContainer() {
        this.status = SUCCESS;
        this.message = "success";
    }


    /**
     * 응답 데이터를 포함하는 성공 응답
     *
     * @param data 응답 데이터
     */
    public ResponseContainer(T data) {
        this.status = SUCCESS;
        this.message = "success";
        this.data = data;
    }

    /**
     * 오류 응답
     */
    public ResponseContainer(Throwable throwable) {
        this.status = FAIL;
        this.message = throwable.getLocalizedMessage();
    }

}
