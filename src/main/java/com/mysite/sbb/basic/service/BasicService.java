package com.mysite.sbb.basic.service;

import com.mysite.sbb.basic.dto.request.BasicRegisterRequest;
import com.mysite.sbb.basic.entity.Basic;
import com.mysite.sbb.basic.exception.BasicBusinessException;
import com.mysite.sbb.basic.exception.BasicErrorCode;
import com.mysite.sbb.basic.repository.BasicRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public void updateBasic(Long basicId, BasicRegisterRequest request){
        Basic basic = getBasicEntity(basicId);
        log.info("테스트 basic 입니다1.{}", basic.getCode());
        basic.update(basicId, request.code());
        log.info("테스트 basic 입니다.{} {}", basic.getCode(), request.code());
    }


    public void deleteBasic(Long basicId){
        Basic basic = getBasicEntity(basicId);
        log.info("[BasicService] basic을 삭제합니다.");
        basicRepository.delete(basic);
    }




    public List<Basic> getAllBasic() {
        return basicRepository.findAll();
    }

    public Basic getBasicByCode(String code){
        return basicRepository.findByCode(code);
    }

    public List<Basic> getBasicByCreateTime(LocalDateTime startDateTime, LocalDateTime endDateTime){
        return basicRepository.findByCreatedAtBetween(startDateTime, endDateTime);
    }

    public List<Basic> getBasicByUpdateTime(LocalDateTime startDateTime, LocalDateTime endDateTime){
        return basicRepository.findByUpdatedAtBetween(startDateTime, endDateTime);
    }

    private Basic getBasicEntity(Long basicId){
        return basicRepository.findById(basicId)
                .orElseThrow(() -> new BasicBusinessException(BasicErrorCode.BASIC_NOT_FOUND));
    }

}
