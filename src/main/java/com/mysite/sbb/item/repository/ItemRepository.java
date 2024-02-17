package com.mysite.sbb.item.repository;

import com.mysite.sbb.basic.entity.Basic;
import com.mysite.sbb.item.entity.Item;
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
public interface ItemRepository extends JpaRepository<Item, Long> {
    /**
     * SELECT b FROM Basic b
     * WHERE ( b.createdAt >= :startDateTime ) AND ( b.createdAt <= :endDateTime )
     * ORDER BY b.createdAt DESC
     */
    // 기본적으로 생성 날짜 내림차순으로 정렬하고, 특정 기간 내 업데이트된 엔티티를 옵셔널하게 조회합니다.
    @Query("SELECT b FROM Company b WHERE " +
            "( b.createdAt >= :startDateTime ) AND " +
            "( b.createdAt <= :endDateTime ) " +
            "ORDER BY b.createdAt DESC")
    List<Basic> findByOptionalUpdatedAtBetween(
            @Param("startDateTime") Optional<LocalDateTime> startDateTime,
            @Param("endDateTime") Optional<LocalDateTime> endDateTime);


}
