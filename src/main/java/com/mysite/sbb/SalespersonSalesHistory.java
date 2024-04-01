package com.mysite.sbb;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "salesperson_sales_history")
public class SalespersonSalesHistory {
  @EmbeddedId private SalespersonSalesHistoryId id;

  @Column(name = "sales_amount")
  private BigDecimal salesAmount;

  @Column(name = "payment_amount")
  private BigDecimal paymentAmount;

  @Column(name = "discount_amount")
  private BigDecimal discountAmount;

  @Column(name = "cost")
  private BigDecimal cost;

  @Column(name = "sales_profit")
  private BigDecimal salesProfit;

  @Column(name = "margin_rate")
  private BigDecimal marginRate;
}
