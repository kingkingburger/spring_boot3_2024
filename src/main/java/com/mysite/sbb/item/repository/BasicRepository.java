package com.mysite.sbb.item.repository;

import com.mysite.sbb.basic.entity.Basic;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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


    /**
     * SELECT * FROM Basic
     * ORDER BY created_at DESC
     * LIMIT :pageSize OFFSET :pageNumber
     */
    List<Basic> findAllByOrderByCreatedAtDesc(Pageable page);

    /**
     * SELECT * FROM Basic
     * WHERE basicId < :basicId
     * ORDER BY created_at DESC
     * LIMIT :pageSize OFFSET :pageNumber
     */
    List<Basic> findByIdLessThanOrderByCreatedAtDesc(Long basicId, Pageable page);


    /**
     * SELECT b FROM Basic b
     * WHERE ( b.createdAt >= :startDateTime ) AND ( b.createdAt <= :endDateTime )
     * ORDER BY b.createdAt DESC
     */
    // 기본적으로 생성 날짜 내림차순으로 정렬하고, 특정 기간 내 업데이트된 엔티티를 옵셔널하게 조회합니다.
    @Query("SELECT b FROM Item b WHERE " +
            "( b.createdAt >= :startDateTime ) AND " +
            "( b.createdAt <= :endDateTime ) " +
            "ORDER BY b.createdAt DESC")
    List<Basic> findByOptionalUpdatedAtBetween(
            @Param("startDateTime") Optional<LocalDateTime> startDateTime,
            @Param("endDateTime") Optional<LocalDateTime> endDateTime);


}
