package com.mysite.sbb.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


/**
 * Entity의 기본이 되는 시간 칼럼을 생생해줍니다.
 * @MappedSuperclass로 이 클래스의 필드들은 상속 받는 엔티티의 테이블 컬럼으로 포함됩니다.
 * @EntityListeners(AuditingEntityListener.class) 엔티티의 변화를 감지하는 리스너를 설정합니다.
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreationTimestamp
    @Column(name="created", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated")
    private LocalDateTime updatedAt;

    @Setter
    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;

    public void checkingDeletedAt(LocalDateTime now){
        this.deletedAt = now;
    }
}
