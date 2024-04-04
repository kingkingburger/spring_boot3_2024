package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "quotation_transaction_price")
public class QuotationTransactionPrice {
  @Id @GeneratedValue private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vendor_code", nullable = false)
  private Vendor vendor;

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

  @Column(name = "unit_price")
  private BigDecimal unitPrice;

  @Column(name = "supply_price")
  private BigDecimal supplyPrice;

  @Column(name = "vat")
  private BigDecimal vat;

  @Column(name = "total_amount")
  private BigDecimal totalAmount;

  @Column(name = "purchase_price")
  private BigDecimal purchasePrice;

  @Column(name = "sales_profit")
  private BigDecimal salesProfit;

  @Column(name = "profit_rate")
  private BigDecimal profitRate;

  @Column(name = "note", length = Integer.MAX_VALUE)
  private String note;
}
