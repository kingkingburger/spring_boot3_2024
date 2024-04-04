package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "daily_statement_inquiry")
public class DailyStatementInquiry {
  @Id @GeneratedValue private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vendor_code", nullable = false)
  private Vendor vendor;

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
