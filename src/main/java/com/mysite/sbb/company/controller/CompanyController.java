package com.mysite.sbb.company.controller;

import com.mysite.sbb.common.response.ApiResponse;
import com.mysite.sbb.company.service.CompanyService;
import com.mysite.sbb.company.service.dto.request.CompanyRegisterRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
@Tag(name = "Company", description = "company API")
public class CompanyController {

    private final CompanyService companyService;
    private static final int DEFAULT_PAGE_SIZE = 24;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> registerCompany(@RequestBody CompanyRegisterRequest companyRegisterRequest) {
        companyService.registerCompany(companyRegisterRequest);

        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK,
                        "성공적으로 입력 되었습니다."
                )
        );
    }

//    @GetMapping("/")
//    public ResponseEntity<ApiResponse> getAllCompany() {
//        List<CompanyResponse.CompanyGetResponse> companyList = companyService.getAllCompany();
//
//        return ResponseEntity.ok().body(
//                ApiResponse.of(
//                        HttpStatus.OK,
//                        "Company의 데이터 입니다.",
//                        companyList
//                )
//        );
//    }

}
