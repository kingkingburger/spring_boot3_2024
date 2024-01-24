package com.mysite.sbb.awb.controller;

import com.mysite.sbb.awb.domain.Awb;
import com.mysite.sbb.awb.dto.AwbRequestDto;
import com.mysite.sbb.awb.service.AwbService;
import com.mysite.sbb.common.dto.BasicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/awb")
public class AwbController {
    private final AwbService awbService;

    @PostMapping("/")
    public BasicResponseDto<Awb> create(@RequestBody AwbRequestDto request) {
        try {
            Awb awb = awbService.create(request);
            return BasicResponseDto.ofSuccess(HttpStatus.CREATED.value(), awb);
        } catch (Exception e) {
            return BasicResponseDto.ofFail(HttpStatus.CREATED.value());
        }
    }
}
