package com.mysite.sbb.item.exception;

import com.mysite.sbb.basic.exception.BasicErrorCode;
import lombok.Getter;

@Getter
public class BasicBusinessException extends RuntimeException {
    private final com.mysite.sbb.basic.exception.BasicErrorCode statusWithCode;

    public BasicBusinessException(BasicErrorCode statusWithCode){
        super(statusWithCode.getMessage());
        this.statusWithCode = statusWithCode;
    }
}
