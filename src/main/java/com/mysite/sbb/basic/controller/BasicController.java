package com.mysite.sbb.basic.controller;

import com.mysite.sbb.basic.dto.request.BasicRegisterRequest;
import com.mysite.sbb.basic.entity.Basic;
import com.mysite.sbb.basic.service.BasicService;
import com.mysite.sbb.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/v1/basic")
@Tag(name = "Basic", description = "Awb API")
public class BasicController {

    private final BasicService basicService;
    private static final int DEFAULT_PAGE_SIZE = 24;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> registerBasic(@RequestBody BasicRegisterRequest basicRegisterRequest) {
        basicService.registerBasic(basicRegisterRequest);

        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "성공적으로 입력 되었습니다."
                )
        );
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllBasic() {
        List<Basic> basicList = basicService.getAllBasic();

        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "Basic의 데이터 입니다.",
                        basicList
                )
        );
    }

    // Code를 이용한 검색
    /*@GetMapping("/search")
    public ResponseEntity<ApiResponse> searchBasic(
            @RequestParam(name = "code", required = false) String code
    ) {
        Basic basic = basicService.getBasicByCode(code);

        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "Basic의 데이터 입니다.",
                        basic
                )
        );
    }*/

    // 생성 날짜 기반 검색
    @GetMapping("/searchByCreationDate")
    public ResponseEntity<ApiResponse> getByCreationDate(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime) {
        List<Basic> basicList = basicService.getBasicByCreateTime(startDateTime, endDateTime);

        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "Basic의 데이터 입니다.",
                        basicList
                )
        );
    }
//
//    // 업데이트 날짜 기반 검색
//    @GetMapping("/searchByUpdateDate")
//    public ResponseEntity<ApiResponse> getByUpdateDate(
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime) {
//        List<Basic> basicList = basicService.getBasicByUpdateTime(startDateTime, endDateTime);
//
//        return ResponseEntity.ok().body(
//                ApiResponse.of(
//                        HttpStatus.OK,
//                        "Basic의 데이터 입니다.",
//                        basicList
//                )
//        );
//    }

}
