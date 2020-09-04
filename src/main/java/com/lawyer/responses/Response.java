package com.lawyer.responses;

import org.springframework.http.HttpStatus;

/**
 * @param <T> Response.
 */

public class Response<T> {

    private HttpStatus httpStatus;
    private ResponseBody<T> body;

    /**
     * Constructor.
     */
    public Response() {
        body = new ResponseBody<>();
    }

    /**
     * @return httpStatus.
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * @param httpStatus httpStatus.
     * @return Response.
     */
    public Response<T> setHttpStatus(final HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }


    /**
     * @return Response.
     */
    public ResponseBody<T> getBody() {
        return body;
    }

    /**
     * @param body body.
     * @return Response.
     */
    public Response<T> setBody(final ResponseBody<T> body) {
        this.body = body;
        return this;
    }
}
