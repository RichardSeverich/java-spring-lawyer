package com.lawyer.responses;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * @param <T> Response.
 */
public class Response<T> {

    @Getter @Setter
    private HttpStatus httpStatus;
    @Getter @Setter
    private ResponseBody<T> body;

    /**
     * Constructor.
     */
    public Response() {
        body = new ResponseBody<>();
    }
}
