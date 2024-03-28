package com.mysite.sbb.company.entity;

import com.mysite.sbb.common.entity.BaseTimeEntity;
import com.mysite.sbb.company.service.dto.request.CompanyRegisterRequest;
import com.mysite.sbb.item.entity.Item;
import com.mysite.sbb.member.entity.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

  @Column(nullable = false, columnDefinition = "boolean default true")
  private boolean active = true;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, length = 100, unique = true)
  private String code;

  @Column(columnDefinition = "TEXT")
  private String fastSearch; // 빠른 검색

  @Column() private String type; // 구분
  @Column() private String basicStockLocation; // 기본재고처
  @Column() private int creditLimit; // 외상한도
  @Column() private int uniPrice; // 단가적용
  @Column() private boolean vat; // 부가세별도
  @Column() private String employee; // 담당사원
  @Column() private String phoneNumber; // 전화번호;
  @Column() private String mobileNumber; // 휴대폰번호;
  @Column() private String faxNumber; // 팩스번호;
  @Column() private String businessName; // 사업자상호;
  @Column() private String businessRegistrationNumber; // 사업자번호;
  @Column() private String representativeName; // 대표자;
  @Column() private String businessType; // 업태;
  @Column() private String businessCategory; // 종목;
  @Column() private String registeredAddress; // 신)도로명주소
  @Column() private String additionalNotes; // 참고사항;
  @Column() private LocalDateTime lastTransactionDate; // 최종거래일;
  @Column() private LocalDateTime registrationDate; // 등록일시;
  @Column() private String registeredBy; // 등록자;
  @Column() private LocalDateTime modificationDate; // 변경일시;
  @Column() private String modifiedBy; // 변경자;
  @Column() private String taxOfficer; // 세금담당자;
  @Column() private String officerMobileNumber; // 담당핸드폰;
  @Column() private String emailAddress; // 이메일주소;
  @Column() private String transactionBasis; // 거래기준;
  @Column() private String orderReceptionId; // 주문접수ID;
  @Column() private String deliveryDay; // 배송요일;
  @Column() private String oldAddress; // 구)지번주소

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Member> memberList = new ArrayList<>();

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Item> itemList = new ArrayList<>();

  @Builder
  public Company(String code) {
    this.code = code;
  }

  public static Company of(CompanyRegisterRequest newCompanyInfo) {
    return Company.builder().code(newCompanyInfo.code()).build();
  }

  public void update(String code) {
    this.code = code;
  }
}
