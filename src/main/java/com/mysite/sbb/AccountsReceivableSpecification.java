package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "accounts_receivable_specification")
public class AccountsReceivableSpecification {
  @Id
  @Size(max = 50)
  @Column(name = "vendor_code", nullable = false, length = 50)
  private String vendorCode;

  @MapsId
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vendor_code", nullable = false)
  private Vendor vendorRegistration;

  @Size(max = 255)
  @Column(name = "vendor_name")
  private String vendorName;

  @Column(name = "previous_balance")
  private BigDecimal previousBalance;

  @Column(name = "purchase_period")
  private BigDecimal purchasePeriod;

  @Column(name = "payment_period")
  private BigDecimal paymentPeriod;

  @Column(name = "discount_payment")
  private BigDecimal discountPayment;

  @Column(name = "sales_period")
  private BigDecimal salesPeriod;

  @Column(name = "sales_return")
  private BigDecimal salesReturn;

  @Column(name = "net_sales")
  private BigDecimal netSales;

  @Column(name = "deposit_period")
  private BigDecimal depositPeriod;

  @Column(name = "discount_deposit")
  private BigDecimal discountDeposit;

  @Column(name = "current_balance")
  private BigDecimal currentBalance;

  @Column(name = "sales_profit")
  private BigDecimal salesProfit;

  @Column(name = "profit_rate")
  private BigDecimal profitRate;

  @Size(max = 255)
  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "last_transaction_date")
  private LocalDate lastTransactionDate;

  @Column(name = "credit_limit")
  private BigDecimal creditLimit;

  @Column(name = "transaction_criteria", length = Integer.MAX_VALUE)
  private String transactionCriteria;
}
