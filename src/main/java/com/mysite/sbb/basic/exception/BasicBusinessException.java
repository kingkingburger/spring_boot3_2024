package com.mysite.sbb.basic.exception;

import lombok.Getter;

@Getter
public class BasicBusinessException extends RuntimeException {
    private final BasicErrorCode statusWithCode;

    public BasicBusinessException(BasicErrorCode statusWithCode){
        super(statusWithCode.getMessage());
        this.statusWithCode = statusWithCode;
    }
}
