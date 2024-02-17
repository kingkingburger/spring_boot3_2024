package com.mysite.sbb.company.entity;


import com.mysite.sbb.basic.service.dto.request.BasicRegisterRequest;
import com.mysite.sbb.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@Entity
public class Company extends BaseTimeEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String code;


    @Builder
    public Company(String code) {
        this.code = code;
    }

    public static Company of(BasicRegisterRequest newBasicInfo) {
        return Company.builder()
                .code(newBasicInfo.code())
                .build();
    }

    public void update(
            String code
    ){
        this.code = code;
    }
}
