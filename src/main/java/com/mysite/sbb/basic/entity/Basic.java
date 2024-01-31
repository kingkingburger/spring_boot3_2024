package com.mysite.sbb.basic.entity;

import com.mysite.sbb.basic.dto.request.BasicRegisterRequest;
import com.mysite.sbb.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Entity
public class Basic extends BaseTimeEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(length = 100)
    private String password;

    @Builder
    public Basic(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Basic of (BasicRegisterRequest newMemberInfo){
        return Basic.builder()
                .email(newMemberInfo.email())
                .password(newMemberInfo.password())
                .build();
    }
}
