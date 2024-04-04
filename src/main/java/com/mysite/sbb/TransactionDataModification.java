package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transaction_data_modification")
public class TransactionDataModification {
  @Id @GeneratedValue private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vendor_code", nullable = false)
  private Vendor vendor;

  @Column(name = "transaction_date")
  private LocalDate transactionDate;

  @Size(max = 255)
  @Column(name = "transaction_type")
  private String transactionType;

  @Size(max = 255)
  @Column(name = "vendor_name")
  private String vendorName;

  @Size(max = 255)
  @Column(name = "inventory_location")
  private String inventoryLocation;

  @Size(max = 255)
  @Column(name = "item_name")
  private String itemName;

  @Size(max = 255)
  @Column(name = "specification")
  private String specification;

  @Size(max = 255)
  @Column(name = "unit")
  private String unit;

  @Column(name = "box")
  private Integer box;

  @Column(name = "ea")
  private Integer ea;

  @Column(name = "total_quantity")
  private Integer totalQuantity;

  @Column(name = "unit_price")
  private BigDecimal unitPrice;

  @Column(name = "supply_price")
  private BigDecimal supplyPrice;

  @Column(name = "vat")
  private BigDecimal vat;

  @Column(name = "total_amount")
  private BigDecimal totalAmount;

  @Column(name = "purchase_cost")
  private BigDecimal purchaseCost;

  @Column(name = "sales_profit")
  private BigDecimal salesProfit;

  @Column(name = "margin_rate")
  private BigDecimal marginRate;

  @Size(max = 255)
  @Column(name = "in_charge_staff")
  private String inChargeStaff;

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
}
