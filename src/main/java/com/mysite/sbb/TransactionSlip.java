package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transaction_slip")
public class TransactionSlip {
  @EmbeddedId private TransactionSlipRegistrationId id;

  @MapsId("itemCode")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "item_code", nullable = false)
  private ItemBasic itemCode;

  @Size(max = 255)
  @Column(name = "transaction_type")
  private String transactionType;

  @Size(max = 255)
  @Column(name = "name")
  private String name;

  @Size(max = 255)
  @Column(name = "specification")
  private String specification;

  @Size(max = 255)
  @Column(name = "unit")
  private String unit;

  @Size(max = 255)
  @Column(name = "manufacturer")
  private String manufacturer;

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

  @Size(max = 255)
  @Column(name = "in_charge_staff")
  private String inChargeStaff;

  @Column(name = "note", length = Integer.MAX_VALUE)
  private String note;

  @Column(name = "cost_price")
  private BigDecimal costPrice;

  @Column(name = "sales_profit")
  private BigDecimal salesProfit;

  @Column(name = "margin_rate")
  private BigDecimal marginRate;

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

  @Column(name = "is_taxed")
  private Boolean isTaxed;

  @Column(name = "internal_unit_price")
  private BigDecimal internalUnitPrice;

  @Column(name = "internal_cost_price")
  private BigDecimal internalCostPrice;

  @Size(max = 255)
  @Column(name = "barcode")
  private String barcode;
}
