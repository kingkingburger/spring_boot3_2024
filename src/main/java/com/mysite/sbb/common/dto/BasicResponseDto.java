package com.mysite.sbb.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class BasicResponseDto<D> {
    private final String resultCode;
    private final Integer code;
    private final D data;

    public static <D> BasicResponseDto<D> ofSuccess(Integer code, D data) {
        return new BasicResponseDto<>("SUCCESS", code, data);
    }

    public static <D> BasicResponseDto<D> ofFail(Integer code) {
        return new BasicResponseDto<>("FAIL", code, null);
    }
}
