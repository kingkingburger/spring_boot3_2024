package com.mysite.sbb.item.entity;


import com.mysite.sbb.basic.service.dto.request.BasicRegisterRequest;
import com.mysite.sbb.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@Entity
public class Item extends BaseTimeEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String code;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 255)
    private String image;

    @Column(columnDefinition = "jsonb")
    private String size; // 실제 사용 시 적절한 클래스 타입으로 변환 필요

    @Column(name = "unit_price", precision = 19, scale = 2)
    private BigDecimal unitPrice;

    @Lob
    private String description;

    @Builder
    public Item(String code) {
        this.code = code;
    }

    public static Item of(BasicRegisterRequest newBasicInfo) {
        return Item.builder()
                .code(newBasicInfo.code())
                .build();
    }

    // 엔티티 내 필드 업데이트 메서드
    public void update(String code,
                       String name,
                       String image,
                       String size,
                       BigDecimal unitPrice,
                       String description) {
        this.code = code;
        this.name = name;
        this.image = image;
        this.size = size;
        this.unitPrice = unitPrice;
        this.description = description;
    }
}
