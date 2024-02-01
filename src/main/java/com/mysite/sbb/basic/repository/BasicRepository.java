package com.mysite.sbb.basic.repository;

import com.mysite.sbb.basic.entity.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BasicRepository extends JpaRepository<Basic, Long> {
    // Code를 기준으로 Basic 엔티티 검색
    Basic findByCode(String code);

}