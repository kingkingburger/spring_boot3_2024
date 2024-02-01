package com.mysite.sbb.basic.repository;

import com.mysite.sbb.basic.entity.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BasicRepository extends JpaRepository<Basic, Long> {
    // Code를 기준으로 Basic 엔티티 검색
    Basic findByCode(String code);

    // 특정 기간 내에 생성된 Basic 엔티티 검색
    List<Basic> findByCreatedAtBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    // 특정 기간 내에 업데이트된 Basic 엔티티 검색
    List<Basic> findByUpdatedAtBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
