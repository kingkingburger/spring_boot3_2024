package com.mysite.sbb.item.entity;

import com.mysite.sbb.common.entity.BaseTimeEntity;
import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.item.dto.request.ItemRegisterRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

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

  @Column(nullable = false, columnDefinition = "boolean default true")
  private boolean active = true;

  @Column(nullable = false, length = 100, unique = true)
  private String code;

  @Column(nullable = false)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(length = 100)
  private String specification; // 규격

  @Column(length = 100)
  private String manufacturer; // 제조사

  @Column() private Integer quantity; // 입수량

  @Column(length = 50)
  private String itemType; // 품목유형

  @Lob private String fastSearch; // 빠른검색
  @Column() private Integer purchasePrice; // 매입단가

  @Column(nullable = false)
  private Boolean isPurchasePriceAutoUpdate; // 매입단가자동변경

  @Column(length = 100)
  private String supplierName; // 매입처명

  @Column(nullable = false)
  private Boolean isInventoryManaged; // 재고관리

  @Column() private Integer salesPriceA; // 판매가A
  @Column() private Integer salesPriceB; // 판매가B
  @Column() private Integer salesPriceC; // 판매가C
  @Column() private Integer salesPriceD; // 판매가D
  @Column() private Integer consumerPrice; // 소비자가

  @Column(length = 50)
  private String taxCategory; // 과세구분

  @Column() private Integer optimalInventory; // 적정재고

  @Column(length = 100)
  private String eaBarcode; // EA바코드

  @Column(length = 100)
  private String boxBarcode; // BOX바코드

  @Lob private String notes; // 참고사항

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime lastRestockDate; // 최종입고일

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime lastShipmentDate; // 최종출고일

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime registrationDateTime; // 등록일시

  @Column(length = 50)
  private String registeredBy; // 등록자

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime modificationDateTime; // 변경일시

  @Column(length = 50)
  private String modifiedBy; // 변경자

  @Column(length = 100)
  private String storageLocation; // 보관위치

  @Column(length = 50)
  private Integer transactionCount; // 거래횟수

  //  @ManyToOne(fetch = FetchType.LAZY)
  //  @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "FK_MEMBER_COMPANY"))
  //  private Company company;

  @Builder
  public Item(
      boolean active,
      String code,
      String name,
      String description,
      String specification,
      String manufacturer,
      Integer quantity,
      String itemType,
      String fastSearch,
      Integer purchasePrice,
      Boolean isPurchasePriceAutoUpdate,
      String supplierName,
      Boolean isInventoryManaged,
      Integer salesPriceA,
      Integer salesPriceB,
      Integer salesPriceC,
      Integer salesPriceD,
      Integer consumerPrice,
      String taxCategory,
      Integer optimalInventory,
      String eaBarcode,
      String boxBarcode,
      String notes,
      LocalDateTime lastRestockDate,
      LocalDateTime lastShipmentDate,
      LocalDateTime registrationDateTime,
      String registeredBy,
      LocalDateTime modificationDateTime,
      String modifiedBy,
      String storageLocation,
      Integer transactionCount) {
    this.active = active;
    this.code = code;
    this.name = name;
    this.description = description;
    this.specification = specification;
    this.manufacturer = manufacturer;
    this.quantity = quantity;
    this.itemType = itemType;
    this.fastSearch = fastSearch;
    this.purchasePrice = purchasePrice;
    this.isPurchasePriceAutoUpdate = isPurchasePriceAutoUpdate;
    this.supplierName = supplierName;
    this.isInventoryManaged = isInventoryManaged;
    this.salesPriceA = salesPriceA;
    this.salesPriceB = salesPriceB;
    this.salesPriceC = salesPriceC;
    this.salesPriceD = salesPriceD;
    this.consumerPrice = consumerPrice;
    this.taxCategory = taxCategory;
    this.optimalInventory = optimalInventory;
    this.eaBarcode = eaBarcode;
    this.boxBarcode = boxBarcode;
    this.notes = notes;
    this.lastRestockDate = lastRestockDate;
    this.lastShipmentDate = lastShipmentDate;
    this.registrationDateTime = registrationDateTime;
    this.registeredBy = registeredBy;
    this.modificationDateTime = modificationDateTime;
    this.modifiedBy = modifiedBy;
    this.storageLocation = storageLocation;
    this.transactionCount = transactionCount;
  }

  public static Item of(ItemRegisterRequest newItemInfo) {
    return Item.builder()
        .active(newItemInfo.active())
        .code(newItemInfo.code())
        .name(newItemInfo.name())
        .description(newItemInfo.description())
        .specification(newItemInfo.specification())
        .manufacturer(newItemInfo.manufacturer())
        .quantity(newItemInfo.quantity())
        .itemType(newItemInfo.itemType())
        .fastSearch(newItemInfo.fastSearch())
        .purchasePrice(newItemInfo.purchasePrice())
        .isPurchasePriceAutoUpdate(newItemInfo.isPurchasePriceAutoUpdate())
        .supplierName(newItemInfo.supplierName())
        .isInventoryManaged(newItemInfo.isInventoryManaged())
        .salesPriceA(newItemInfo.salesPriceA())
        .salesPriceB(newItemInfo.salesPriceB())
        .salesPriceC(newItemInfo.salesPriceC())
        .salesPriceD(newItemInfo.salesPriceD())
        .consumerPrice(newItemInfo.consumerPrice())
        .taxCategory(newItemInfo.taxCategory())
        .optimalInventory(newItemInfo.optimalInventory())
        .eaBarcode(newItemInfo.eaBarcode())
        .boxBarcode(newItemInfo.boxBarcode())
        .notes(newItemInfo.notes())
        .lastRestockDate(newItemInfo.lastRestockDate())
        .lastShipmentDate(newItemInfo.lastShipmentDate())
        .registrationDateTime(newItemInfo.registrationDateTime())
        .registeredBy(newItemInfo.registeredBy())
        .modificationDateTime(newItemInfo.modificationDateTime())
        .modifiedBy(newItemInfo.modifiedBy())
        .storageLocation(newItemInfo.storageLocation())
        .transactionCount(newItemInfo.transactionCount())
        .build();
  }

  // 엔티티 내 필드 업데이트 메서드
  public void update(
      String code,
      String name,
      String image,
      String size,
      BigDecimal unitPrice,
      String description,
      Company company) {
    this.code = code;
    this.name = name;
    this.description = description;
    //    this.company = company;
  }
}
