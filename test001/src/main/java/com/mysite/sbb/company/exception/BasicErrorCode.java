package com.mysite.sbb.company.exception;

import com.mysite.sbb.common.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum BasicErrorCode implements ErrorCode {

    BASIC_NOT_FOUND(HttpStatus.NOT_FOUND, "Basic을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
