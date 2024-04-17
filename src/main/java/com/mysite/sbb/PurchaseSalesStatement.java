package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "purchase_sales_statement")
public class PurchaseSalesStatement {
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

  @Column(name = "box")
  private Integer box;

  @Column(name = "ea")
  private Integer ea;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "tax")
  private BigDecimal tax;

  @Column(name = "sales_profit")
  private BigDecimal salesProfit;

  @Column(name = "total")
  private BigDecimal total;

  @Column(name = "margin_rate")
  private BigDecimal marginRate;

  @Column(name = "note", length = Integer.MAX_VALUE)
  private String note;
}
