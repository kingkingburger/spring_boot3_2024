package com.mysite.sbb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "daily_statement_inquiry")
public class DailyStatementInquiry {
  @Id
  @Size(max = 255)
  @Column(name = "vendor_name", nullable = false)
  private String vendorName;

  @Column(name = "remark", length = Integer.MAX_VALUE)
  private String remark;

  @Column(name = "cash")
  private BigDecimal cash;

  @Column(name = "cash_receipt")
  private BigDecimal cashReceipt;

  @Column(name = "discount")
  private BigDecimal discount;

  @Column(name = "deposit_and_note")
  private BigDecimal depositAndNote;

  @Column(name = "credit_card")
  private BigDecimal creditCard;

  @Column(name = "real_time_transfer")
  private BigDecimal realTimeTransfer;
}
