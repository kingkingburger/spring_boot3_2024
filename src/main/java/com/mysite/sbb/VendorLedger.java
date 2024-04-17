package com.mysite.sbb;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vendor_ledger")
public class VendorLedger {
  @EmbeddedId private VendorLedgerId id;

  @Size(max = 255)
  @Column(name = "category")
  private String category;

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

  @Column(name = "sales_payment")
  private BigDecimal salesPayment;

  @Column(name = "purchase_payment")
  private BigDecimal purchasePayment;

  @Column(name = "current_balance")
  private BigDecimal currentBalance;

  @Column(name = "note", length = Integer.MAX_VALUE)
  private String note;
}
