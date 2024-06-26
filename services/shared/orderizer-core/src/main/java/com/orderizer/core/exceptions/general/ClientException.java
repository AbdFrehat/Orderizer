package com.orderizer.core.exceptions.general;

import com.orderizer.core.models.responses.ErrorResponse;
import lombok.Getter;

@Getter
public class ClientException extends RuntimeException{

    private final int statusCode;

    private final String message;

    private final ErrorResponse errorResponse;

    public ClientException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
        this.errorResponse = null;
    }

    public ClientException(String message, int statusCode, ErrorResponse errorResponse) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
        this.errorResponse = errorResponse;
    }

}
