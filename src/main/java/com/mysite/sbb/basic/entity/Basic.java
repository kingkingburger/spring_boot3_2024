package com.mysite.sbb.basic.entity;


import com.mysite.sbb.basic.service.dto.request.BasicRegisterRequest;
import com.mysite.sbb.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Entity
public class Basic extends BaseTimeEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String code;


    @Builder
    public Basic(String code) {
        this.code = code;
    }

    public static Basic of(BasicRegisterRequest newBasicInfo) {
        return Basic.builder()
                .code(newBasicInfo.code())
                .build();
    }

    public void update(
            String code
    ){
        this.code = code;
    }
}
