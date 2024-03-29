package com.mysite.sbb.member.controller;

import com.mysite.sbb.basic.service.dto.request.BasicRegisterRequest;
import com.mysite.sbb.common.response.ApiResponse;
import com.mysite.sbb.member.dto.request.MemberRegisterRequest;
import com.mysite.sbb.member.dto.response.MemberInfoResponse;
import com.mysite.sbb.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerMember(@RequestBody MemberRegisterRequest request) {
        memberService.registerMember(request);

        log.info("hello {}", request);
        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "성공적으로 회원가입이 되었습니다."
                )
        );
    }

    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse> getMemberInfo(@PathVariable("email") String email) {
        MemberInfoResponse memberInfo = memberService.getMemberInfoByEmail(email);

        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "해당 이메일에 대한 회원정보가 성공적으로 조회되었습니다.",
                        memberInfo)
        );
    }


    @PutMapping("/{memberId}")
    public ResponseEntity<ApiResponse> updateBasic(
            @PathVariable("memberId") Long memberId,
            @RequestBody @Valid MemberRegisterRequest request
    ) {
        memberService.updateMember(memberId, request);
        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "성공적으로 수정하였습니다.",
                        true
                )
        );
    }

}
