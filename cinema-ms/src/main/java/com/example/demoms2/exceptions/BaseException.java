package com.example.demoms2.exceptions;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BaseException extends Exception {

    public BaseException(String message){
        super(message);
    }

    @Override
    @JsonSerialize
    public String getMessage() {
        return super.getMessage();
    }
}
