package com.mysite.sbb.basic.repository;

import com.mysite.sbb.basic.entity.Basic;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * "org.springframework.data.repository.query.Param.value()" because the return value of "java.lang.reflect.Parameter.getAnnotation(java.lang.Class)" is null 에러나서
 * @Hidden으로 swagger에서 jpa를 인식하지 못하게 함
 */
@Hidden
@Repository
public interface BasicRepository extends JpaRepository<Basic, Long> {
    // Code를 기준으로 Basic 엔티티 검색
    Basic findByCode(String code);

    // 특정 기간 내에 생성된 Basic 엔티티 검색
    List<Basic> findByCreatedAtBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    // 특정 기간 내에 업데이트된 Basic 엔티티 검색
    List<Basic> findByUpdatedAtBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
