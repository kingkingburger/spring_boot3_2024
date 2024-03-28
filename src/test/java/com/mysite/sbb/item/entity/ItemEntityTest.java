package com.mysite.sbb.item.entity;

import static java.lang.StringTemplate.STR;
import static org.junit.jupiter.api.Assertions.*;

import com.mysite.sbb.company.dto.request.CompanyRegisterRequest;
import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.item.dto.request.ItemRegisterRequest;
import java.time.LocalDateTime;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemEntityTest {
  @Test
  @DisplayName("상품이 생성되는지 확인하는 테스트")
  void createItem() {

    LocalDateTime now = LocalDateTime.now();
    ItemRegisterRequest newItemInfo =
        new ItemRegisterRequest(
            true,
            "code001",
            "스마일푸드",
            "그라운드=분말=분=가루",
            "10kg/pk",
            "CJ",
            1,
            "상온1",
            "1234",
            42000,
            true,
            "스마일푸드",
            true,
            8000,
            8500,
            9000,
            9500,
            10000,
            "면세",
            10,
            "vbcfhgdfg",
            "31twetwrh",
            "대봉에서 세움으로 변경",
            now,
            now,
            now,
            "www",
            now,
            STR."aaa",
            "창고",
            57);

    // given
    //    Item item =
    //        Item.builder()
    //            .code(newItemInfo.code())
    //            .name(newItemInfo.name())
    //            .description(newItemInfo.description())
    //            .build();

    // when, then
    //    Assertions.assertThat(item.getCode()).isEqualTo("code001");
    //    Assertions.assertThat(item.getName()).isEqualTo("name001");
    //    Assertions.assertThat(item.getDescription()).isEqualTo("description test");
  }

  @Test
  @DisplayName("물품를 업데이트 확인하는 테스트")
  void updateItem() {
    //    ItemRegisterRequest newItemInfo =
    //        new ItemRegisterRequest("code001", "name001", new BigDecimal("0.1"), "description
    // test");
    CompanyRegisterRequest requestCompany = new CompanyRegisterRequest("COM001");

    // given
    //    Item item =
    //        Item.builder()
    //            .code(newItemInfo.code())
    //            .name(newItemInfo.name())
    //            .description(newItemInfo.description())
    //            .build();
    Company company = Company.builder().code(requestCompany.code()).build();

    // when
    //    item.update("code002", "name002", "", "", new BigDecimal("0.2"), "description test2",
    // company);

    // then
    //    Assertions.assertThat(item.getCode()).isEqualTo("code002");
    //    Assertions.assertThat(item.getName()).isEqualTo("name002");
    //    Assertions.assertThat(item.getDescription()).isEqualTo("description test2");
    //    Assertions.assertThat(item.getCompany()).isEqualTo(company);
  }
}
