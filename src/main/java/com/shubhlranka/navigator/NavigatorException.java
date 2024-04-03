package com.shubhlranka.navigator;

import org.springframework.http.HttpStatusCode;

public class NavigatorException extends RuntimeException {

    private HttpStatusCode httpStatusCode;
    public NavigatorException(String message, HttpStatusCode httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

    public HttpStatusCode getHttpStatusCode() {
        return httpStatusCode;
    }

}
