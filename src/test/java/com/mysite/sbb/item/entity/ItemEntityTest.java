package com.mysite.sbb.item.entity;

import com.mysite.sbb.company.dto.request.CompanyRegisterRequest;
import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.item.dto.request.ItemRegisterRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemEntityTest {
    @Test
    @DisplayName("상품이 생성되는지 확인하는 테스트")
    void createItem(){
        ItemRegisterRequest newItemInfo = new ItemRegisterRequest("code001", "name001", new BigDecimal("0.1"), "description test");

        // given
        Item item = Item.builder()
                .code(newItemInfo.code())
                .name(newItemInfo.name())
                .unitPrice(newItemInfo.unitPrice())
                .description(newItemInfo.description())
                .build();

        // when, then
        Assertions.assertThat(item.getCode()).isEqualTo("code001");
        Assertions.assertThat(item.getName()).isEqualTo("name001");
        Assertions.assertThat(item.getDescription()).isEqualTo("description test");
        Assertions.assertThat(item.getUnitPrice()).isEqualTo(new BigDecimal("0.1")); // 수정됨
    }
}