package com.mysite.sbb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item_registration")
public class ItemRegistration {
  @Id
  @Size(max = 255)
  @Column(name = "item_code", nullable = false)
  private String itemCode;

  @Column(name = "is_inactive")
  private Boolean isInactive;

  @Size(max = 255)
  @Column(name = "name")
  private String name;

  @Size(max = 255)
  @Column(name = "specification")
  private String specification;

  @Size(max = 255)
  @Column(name = "manufacturer")
  private String manufacturer;

  @Column(name = "quantity_per_unit")
  private Integer quantityPerUnit;

  @Size(max = 255)
  @Column(name = "type")
  private String type;

  @Size(max = 255)
  @Column(name = "quick_search")
  private String quickSearch;

  @Column(name = "purchase_price")
  private BigDecimal purchasePrice;

  @Column(name = "auto_price_change")
  private Boolean autoPriceChange;

  @Size(max = 255)
  @Column(name = "supplier_name")
  private String supplierName;

  @Column(name = "inventory_manage")
  private Boolean inventoryManage;

  @Column(name = "sale_price_a")
  private BigDecimal salePriceA;

  @Column(name = "sale_price_b")
  private BigDecimal salePriceB;

  @Column(name = "sale_price_c")
  private BigDecimal salePriceC;

  @Column(name = "sale_price_d")
  private BigDecimal salePriceD;

  @Column(name = "consumer_price")
  private BigDecimal consumerPrice;

  @Size(max = 255)
  @Column(name = "tax_category")
  private String taxCategory;

  @Column(name = "optimal_inventory")
  private Integer optimalInventory;

  @Size(max = 255)
  @Column(name = "ea_barcode")
  private String eaBarcode;

  @Size(max = 255)
  @Column(name = "box_barcode")
  private String boxBarcode;

  @Column(name = "note", length = Integer.MAX_VALUE)
  private String note;

  @Column(name = "last_incoming")
  private LocalDate lastIncoming;

  @Column(name = "last_outgoing")
  private LocalDate lastOutgoing;

  @Column(name = "registration_date")
  private Instant registrationDate;

  @Size(max = 255)
  @Column(name = "registered_by")
  private String registeredBy;

  @Column(name = "modification_date")
  private Instant modificationDate;

  @Size(max = 255)
  @Column(name = "modified_by")
  private String modifiedBy;

  @Size(max = 255)
  @Column(name = "storage_location")
  private String storageLocation;

  @Column(name = "transaction_count")
  private Integer transactionCount;
}
