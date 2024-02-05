package com.mysite.sbb.basic.controller;

import com.mysite.sbb.basic.dto.request.BasicRegisterRequest;
import com.mysite.sbb.basic.entity.Basic;
import com.mysite.sbb.basic.service.BasicService;
import com.mysite.sbb.basic.service.dto.response.BasicResponse;
import com.mysite.sbb.common.entity.SortType;
import com.mysite.sbb.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.xml.ws.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
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

    /**
     * 모든 Basic을 조회하는 엔드포인트 입니다.
     *
     * @param cursorId 다음 페이지의 커서 ID
     * @param size     페이지 크기
     * @param sort     정렬 방식 - 최신순(latest), 인기순(popular)
     * @return ResponseEntity<Object> 객체
     */
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<BasicResponse.BasicSearchResponse>> searchBoards(
            @RequestParam(name = "cursorId", required = false) Long cursorId,
            @RequestParam(name = "size", required = false) Integer size,
            @RequestParam(name = "sort", defaultValue = "LATEST") SortType sort
    ) {
        if (size == null) size = DEFAULT_PAGE_SIZE;
        BasicResponse.BasicSearchResponse response = basicService.searchBasics(
                cursorId,
                PageRequest.of(0, size),
                sort);
        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "성공적으로 모든 게시글 정보를 조회하였습니다.",
                        response
                )
        );
    }

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

    // 업데이트 날짜 기반 검색
    @GetMapping("/searchByUpdateDate")
    public ResponseEntity<ApiResponse> getByUpdateDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime) {
        List<Basic> basicList = basicService.getBasicByUpdateTime(
                startDateTime,
                endDateTime,
                PageRequest.of(0, 10));

        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "Basic의 데이터 입니다.",
                        basicList
                )
        );
    }

    @PutMapping("/{basicId}")
    public ResponseEntity<ApiResponse> updateBasic(
            @PathVariable("basicId") Long basicId,
            @RequestBody @Valid BasicRegisterRequest request
    ) {
        System.out.println(request.code());
        basicService.updateBasic(basicId, request);
        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "성공적으로 수정하였습니다.",
                        true
                )
        );
    }

    @DeleteMapping("/{basicId}")
    public ResponseEntity<ApiResponse> deleteBasic(
            @PathVariable("basicId") Long basicId
    ) {
        basicService.deleteBasic(basicId);
        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "성공적으로 삭제되었습니다.",
                        true
                )
        );
    }
}
