package com.mysite.sbb.company.exception;

import com.mysite.sbb.basic.exception.BasicErrorCode;
import lombok.Getter;

@Getter
public class BasicBusinessException extends RuntimeException {
    private final BasicErrorCode statusWithCode;

    public BasicBusinessException(BasicErrorCode statusWithCode){
        super(statusWithCode.getMessage());
        this.statusWithCode = statusWithCode;
    }
}
