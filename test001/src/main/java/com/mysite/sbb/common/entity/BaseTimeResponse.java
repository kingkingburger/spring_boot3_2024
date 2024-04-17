package com.mysite.sbb.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Entity Response의 기본이 되는 시간 칼럼을 반환합니다..
 *
 * @MappedSuperclass로 이 클래스의 필드들은 상속 받는 엔티티의 테이블 컬럼으로 포함됩니다.
 * @EntityListeners(AuditingEntityListener.class) 엔티티의 변화를 감지하는 리스너를 설정합니다.
 */
@Getter
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder //  부모 클래스의 필드들도 자동으로 빌더에 포함되어, 자식 클래스의 객체를 생성할 때 부모 클래스의 필드들도 생성합니다.
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeResponse {

    @CreatedDate
    @Column(name = "createdAt", updatable = false)
    public LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updatedAt")
    public LocalDateTime updatedAt;

    @Setter
    @Column(name = "deletedAt")
    public LocalDateTime deletedAt;

    public void checkingDeletedAt(LocalDateTime now) {
        this.deletedAt = now;
    }
}
