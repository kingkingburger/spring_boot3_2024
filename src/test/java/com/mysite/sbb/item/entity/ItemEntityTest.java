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
  void createItem() {
    ItemRegisterRequest newItemInfo =
        new ItemRegisterRequest("code001", "name001", new BigDecimal("0.1"), "description test");

    // given
    Item item =
        Item.builder()
            .code(newItemInfo.code())
            .name(newItemInfo.name())
            .description(newItemInfo.description())
            .build();

    // when, then
    Assertions.assertThat(item.getCode()).isEqualTo("code001");
    Assertions.assertThat(item.getName()).isEqualTo("name001");
    Assertions.assertThat(item.getDescription()).isEqualTo("description test");
  }

  @Test
  @DisplayName("물품를 업데이트 확인하는 테스트")
  void updateItem() {
    ItemRegisterRequest newItemInfo =
        new ItemRegisterRequest("code001", "name001", new BigDecimal("0.1"), "description test");
    CompanyRegisterRequest requestCompany = new CompanyRegisterRequest("COM001");

    // given
    Item item =
        Item.builder()
            .code(newItemInfo.code())
            .name(newItemInfo.name())
            .description(newItemInfo.description())
            .build();
    Company company = Company.builder().code(requestCompany.code()).build();

    // when
    item.update("code002", "name002", "", "", new BigDecimal("0.2"), "description test2", company);

    // then
    Assertions.assertThat(item.getCode()).isEqualTo("code002");
    Assertions.assertThat(item.getName()).isEqualTo("name002");
    Assertions.assertThat(item.getDescription()).isEqualTo("description test2");
    //    Assertions.assertThat(item.getCompany()).isEqualTo(company);
  }
}
