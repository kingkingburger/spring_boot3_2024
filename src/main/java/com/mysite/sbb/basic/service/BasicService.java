package com.mysite.sbb.basic.service;

import com.mysite.sbb.basic.dto.request.BasicRegisterRequest;
import com.mysite.sbb.basic.entity.Basic;
import com.mysite.sbb.basic.exception.BasicBusinessException;
import com.mysite.sbb.basic.exception.BasicErrorCode;
import com.mysite.sbb.basic.repository.BasicRepository;
import com.mysite.sbb.basic.service.dto.response.BasicResponse;
import com.mysite.sbb.common.entity.SortType;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class BasicService {


    private final BasicRepository basicRepository;


    public void registerBasic(BasicRegisterRequest basicRegisterRequest) {
        Basic basic = Basic.of(basicRegisterRequest);
        basicRepository.save(basic);
        log.info("[BasicService] 수정하기");

    }

    public void updateBasic(Long basicId, BasicRegisterRequest request) {
        Basic basic = getBasicEntity(basicId);
        log.info("테스트 basic 입니다1.{}", basic.getCode());
        basic.update(basicId, request.code());
        log.info("테스트 basic 입니다.{} {}", basic.getCode(), request.code());
    }


    public void deleteBasic(Long basicId) {
        Basic basic = getBasicEntity(basicId);
        log.info("[BasicService] basic을 삭제합니다.");
        basicRepository.delete(basic);
    }


    @Transactional(readOnly = true)
    public BasicResponse.BasicSearchResponse searchBasics(Long cursorId, Pageable page, SortType sort) {
        List<Basic> basics = getBasics(cursorId, page, sort);
        Long nextCursorId = getNextCursorId(sort, basics);
        Boolean hasNext = basics.size() >= page.getPageSize();
        return BasicResponse.BasicSearchResponse.of(
                basics.stream()
                        .map(BasicResponse.BasicGetResponse::of)
                        .collect(Collectors.toList()),
                hasNext,
                nextCursorId
        );
    }

    public List<Basic> getAllBasic() {
        return basicRepository.findAll();
    }

    public Basic getBasicByCode(String code) {
        return basicRepository.findByCode(code);
    }

    public List<Basic> getBasicByCreateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return basicRepository.findByCreatedAtBetween(startDateTime, endDateTime);
    }

    public List<Basic> getBasicByUpdateTime(LocalDateTime startDateTime,
                                            LocalDateTime endDateTime,
                                            Pageable page) {
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);

        startDateTime = Optional.ofNullable(startDateTime).orElse(oneWeekAgo);
        endDateTime = Optional.ofNullable(endDateTime).orElse(LocalDateTime.now());

        return basicRepository.findByUpdatedAtBetween(startDateTime, endDateTime);
    }

    private Basic getBasicEntity(Long basicId) {
        return basicRepository.findById(basicId)
                .orElseThrow(() -> new BasicBusinessException(BasicErrorCode.BASIC_NOT_FOUND));
    }

    private Long getNextCursorId(SortType sort, List<Basic> basics) {
        return basics.isEmpty() ?
                null : basics.get(basics.size() - 1).getId();
    }

    private List<Basic> getBasics(Long cursorId, Pageable page, SortType sort) {
        log.info("[BasicServiceImpl] 최신순으로 게시글을 조회합니다.(Reading all basics by latest)");
        return cursorId == null ?
                basicRepository.findAllByOrderByCreatedAtDesc(page) :
                basicRepository.findByIdLessThanOrderByCreatedAtDesc(cursorId, page);

    }

}
