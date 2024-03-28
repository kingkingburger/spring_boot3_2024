package com.mysite.sbb.item.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

public record ItemRegisterRequest(
    @Schema(example = "true") boolean active,
    @Schema(example = "code001") String code,
    @Schema(example = "스마일푸드") String name,
    @Schema(example = "그라운드=분말=분=가루") String description,
    @Schema(example = "10kg/pk") String specification,
    @Schema(example = "CJ") String manufacturer,
    @Schema(example = "1") Integer quantity,
    @Schema(example = "상온1") String itemType,
    @Schema(example = "1234") String fastSearch,
    @Schema(example = "42000") Integer purchasePrice,
    @Schema(example = "true") Boolean isPurchasePriceAutoUpdate,
    @Schema(example = "스마일푸드") String supplierName,
    @Schema(example = "true") Boolean isInventoryManaged,
    @Schema(example = "8000") Integer salesPriceA,
    @Schema(example = "8500") Integer salesPriceB,
    @Schema(example = "9000") Integer salesPriceC,
    @Schema(example = "9500") Integer salesPriceD,
    @Schema(example = "10000") Integer consumerPrice,
    @Schema(example = "면세") String taxCategory,
    @Schema(example = "10") Integer optimalInventory,
    @Schema(example = "vbcfhgdfg") String eaBarcode,
    @Schema(example = "31twetwrh") String boxBarcode,
    @Schema(example = "대봉에서 세움으로 변경") String notes,
    @Schema(example = "code001") LocalDateTime lastRestockDate,
    @Schema(example = "code001") LocalDateTime lastShipmentDate,
    @Schema(example = "code001") LocalDateTime registrationDateTime,
    @Schema(example = "www") String registeredBy,
    @Schema(example = "code001") LocalDateTime modificationDateTime,
    @Schema(example = "aaa") String modifiedBy,
    @Schema(example = "창고") String storageLocation,
    @Schema(example = "57") Integer transactionCount) {

  private static ItemRegisterRequest of(
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
    return new ItemRegisterRequest(
        active,
        code,
        name,
        description,
        specification,
        manufacturer,
        quantity,
        itemType,
        fastSearch,
        purchasePrice,
        isPurchasePriceAutoUpdate,
        supplierName,
        isInventoryManaged,
        salesPriceA,
        salesPriceB,
        salesPriceC,
        salesPriceD,
        consumerPrice,
        taxCategory,
        optimalInventory,
        eaBarcode,
        boxBarcode,
        notes,
        lastRestockDate,
        lastShipmentDate,
        registrationDateTime,
        registeredBy,
        modificationDateTime,
        modifiedBy,
        storageLocation,
        transactionCount);
  }

  @Override
  public String toString() {
    return "ItemRegisterRequest{"
        + "active="
        + active
        + ", code='"
        + code
        + '\''
        + ", name='"
        + name
        + '\''
        + ", description='"
        + description
        + '\''
        + ", specification='"
        + specification
        + '\''
        + ", manufacturer='"
        + manufacturer
        + '\''
        + ", quantity="
        + quantity
        + ", itemType='"
        + itemType
        + '\''
        + ", fastSearch='"
        + fastSearch
        + '\''
        + ", purchasePrice="
        + purchasePrice
        + ", isPurchasePriceAutoUpdate="
        + isPurchasePriceAutoUpdate
        + ", supplierName='"
        + supplierName
        + '\''
        + ", isInventoryManaged="
        + isInventoryManaged
        + ", salesPriceA="
        + salesPriceA
        + ", salesPriceB="
        + salesPriceB
        + ", salesPriceC="
        + salesPriceC
        + ", salesPriceD="
        + salesPriceD
        + ", consumerPrice="
        + consumerPrice
        + ", taxCategory='"
        + taxCategory
        + '\''
        + ", optimalInventory="
        + optimalInventory
        + ", eaBarcode='"
        + eaBarcode
        + '\''
        + ", boxBarcode='"
        + boxBarcode
        + '\''
        + ", notes='"
        + notes
        + '\''
        + ", lastRestockDate="
        + lastRestockDate
        + ", lastShipmentDate="
        + lastShipmentDate
        + ", registrationDateTime="
        + registrationDateTime
        + ", registeredBy='"
        + registeredBy
        + '\''
        + ", modificationDateTime="
        + modificationDateTime
        + ", modifiedBy='"
        + modifiedBy
        + '\''
        + ", storageLocation='"
        + storageLocation
        + '\''
        + '}';
  }
}
