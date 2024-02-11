package com.mysite.sbb.item.exception;

import lombok.Getter;

@Getter
public class BasicBusinessException extends RuntimeException {
    private final BasicErrorCode statusWithCode;

    public BasicBusinessException(BasicErrorCode statusWithCode){
        super(statusWithCode.getMessage());
        this.statusWithCode = statusWithCode;
    }
}
