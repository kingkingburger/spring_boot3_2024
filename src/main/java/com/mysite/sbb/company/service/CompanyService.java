package com.mysite.sbb.company.service;

import com.mysite.sbb.company.service.dto.request.CompanyRegisterRequest;
import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.company.repository.CompanyRepository;
import com.mysite.sbb.company.service.dto.request.CompanyRegisterRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {


    private final CompanyRepository companyRepository;


    public void registerCompany(CompanyRegisterRequest companyRegisterRequest) {
        Company company = Company.of(companyRegisterRequest);
        companyRepository.save(company);
        log.info("[CompanyService] 입력하기");
    }

    public void updateCompany(Long companyId, CompanyRegisterRequest request) {
        Company company = getCompanyEntity(companyId);
        company.update(request.code());
    }


//    public void deleteCompany(Long companyId) {
//        Company company = getCompanyEntity(companyId);
//        log.info("[CompanyService] company을 삭제합니다.");
//        companyRepository.delete(company);
//    }


//    @Transactional(readOnly = true)
//    public CompanyResponse.CompanySearchResponse searchCompanys(Long cursorId, Pageable page, SortType sort) {
//        List<Company> companys = getCompanys(cursorId, page, sort);
//        Long nextCursorId = getNextCursorId(sort, companys);
//        Boolean hasNext = companys.size() >= page.getPageSize();
//        return CompanyResponse.CompanySearchResponse.of(
//                companys.stream()
//                        .map(CompanyResponse.CompanyGetResponse::of)
//                        .collect(Collectors.toList()),
//                hasNext,
//                nextCursorId
//        );
//    }
//
//    public List<CompanyResponse.CompanyGetResponse> getAllCompany() {
//        List<Company> companyList = companyRepository.findAll();
//
//        return CompanyResponse.CompanyGetResponse.ofList(
//                companyList
//        );
//    }
//
//    public Company getCompanyByCode(String code) {
//        return companyRepository.findByCode(code);
//    }
//
//    public List<Company> getCompanyByCreateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
//        return companyRepository.findByCreatedAtBetween(startDateTime, endDateTime);
//    }
//
//    public List<Company> getCompanyByUpdateTime(LocalDateTime startDateTime,
//                                            LocalDateTime endDateTime,
//                                            Pageable page) {
//        LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);
//
//        startDateTime = Optional.ofNullable(startDateTime).orElse(oneWeekAgo);
//        endDateTime = Optional.ofNullable(endDateTime).orElse(LocalDateTime.now());
//
//        return companyRepository.findByUpdatedAtBetween(startDateTime, endDateTime);
//    }
//
    private Company getCompanyEntity(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new NotFoundException("회사를 찾지 못하였습니다."));
    }
//
//    private Long getNextCursorId(SortType sort, List<Company> companys) {
//        return companys.isEmpty() ?
//                null : companys.get(companys.size() - 1).getId();
//    }
//
//    private List<Company> getCompanys(Long cursorId, Pageable page, SortType sort) {
//        log.info("[CompanyServiceImpl] 최신순으로 게시글을 조회합니다.(Reading all companys by latest)");
//        return cursorId == null ?
//                companyRepository.findAllByOrderByCreatedAtDesc(page) :
//                companyRepository.findByIdLessThanOrderByCreatedAtDesc(cursorId, page);
//
//    }

}
