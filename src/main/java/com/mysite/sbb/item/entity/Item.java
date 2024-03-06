package com.mysite.sbb.item.entity;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.mysite.sbb.common.entity.BaseTimeEntity;
import com.mysite.sbb.item.dto.request.ItemRegisterRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
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

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String size = "{}"; // 실제 사용 시 적절한 클래스 타입으로 변환 필요

    @Column(name = "unit_price", precision = 19, scale = 2)
    private BigDecimal unitPrice;

    @Column(name="description", columnDefinition = "TEXT")
    private String description;

    @Builder
    public Item(String code,
                String name,
//                String image,
//                String size,
                BigDecimal unitPrice,
                String description) {
        this.code = code;
        this.name = name;
//        this.image = image;
//        this.size = size;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public static Item of(ItemRegisterRequest newItemInfo) {
        return Item.builder()
                .code(newItemInfo.code())
                .name(newItemInfo.name())
                .unitPrice(newItemInfo.unitPrice())
                .description(newItemInfo.description())
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
