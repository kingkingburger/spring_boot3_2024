package com.mysite.sbb.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class ResponseDto<D> {
    private final String resultCode;
    private final Integer code;
    private final D data;

    public static <D> ResponseDto<D> ofSuccess(Integer code, D data){
        return new ResponseDto<>("Sucess", code, data);
    }

    public static <D> ResponseDto<D> ofFail(Integer code){
        return new ResponseDto<>("Fail", code, null);
    }
}
