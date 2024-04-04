package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transaction_history_inquiry")
public class TransactionHistoryInquiry {
  @Id @GeneratedValue private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vendor", nullable = false)
  private Vendor vendor;

  @Size(max = 255)
  @Column(name = "vendor_name")
  private String vendorName;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "tax")
  private BigDecimal tax;

  @Column(name = "total")
  private BigDecimal total;

  @Column(name = "purchase_cost")
  private BigDecimal purchaseCost;

  @Column(name = "sales_profit")
  private BigDecimal salesProfit;
}
