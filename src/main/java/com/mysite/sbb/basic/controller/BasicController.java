package com.mysite.sbb.basic.controller;

import com.mysite.sbb.basic.service.BasicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/v1/basic")
public class BasicController {

    private final BasicService basicService;


}
