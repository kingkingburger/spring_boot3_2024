package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "final_transaction_price")
public class FinalTransactionPrice {
  @Id
  @Size(max = 50)
  @Column(name = "item_code", nullable = false, length = 50)
  private String itemCode;

  @MapsId
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "item_code", nullable = false)
  private ItemBasic ItemBasic;

  @Size(max = 255)
  @Column(name = "item_name")
  private String itemName;

  @Size(max = 255)
  @Column(name = "specification")
  private String specification;

  @Size(max = 255)
  @Column(name = "unit")
  private String unit;

  @Size(max = 255)
  @Column(name = "manufacturer")
  private String manufacturer;

  @Column(name = "quantity_per_unit")
  private Integer quantityPerUnit;

  @Column(name = "box")
  private Integer box;

  @Column(name = "ea")
  private Integer ea;

  @Column(name = "total_quantity")
  private Integer totalQuantity;

  @Column(name = "discount_before_price")
  private BigDecimal discountBeforePrice;

  @Column(name = "discount_rate")
  private BigDecimal discountRate;

  @Column(name = "unit_price")
  private BigDecimal unitPrice;

  @Column(name = "event_price")
  private BigDecimal eventPrice;

  @Column(name = "last_transaction_date")
  private LocalDate lastTransactionDate;

  @Column(name = "total_amount")
  private BigDecimal totalAmount;

  @Column(name = "supply_price")
  private BigDecimal supplyPrice;

  @Column(name = "vat")
  private BigDecimal vat;

  @Size(max = 255)
  @Column(name = "vendor_barcode")
  private String vendorBarcode;

  @Column(name = "transaction_count")
  private Integer transactionCount;
}
