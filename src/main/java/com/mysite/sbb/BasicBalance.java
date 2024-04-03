package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "basic_balance")
public class BasicBalance {
  @Id
  @Size(max = 255)
  @Column(name = "vendor_code", nullable = false)
  private String vendorCode;

  @MapsId
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vendor_code", nullable = false)
  private Vendor vendor;

  @Size(max = 255)
  @Column(name = "name")
  private String name;

  @Size(max = 255)
  @Column(name = "type")
  private String type;

  @Size(max = 255)
  @Column(name = "phone_number")
  private String phoneNumber;

  @Size(max = 255)
  @Column(name = "mobile_phone")
  private String mobilePhone;

  @Size(max = 255)
  @Column(name = "business_number")
  private String businessNumber;

  @Size(max = 255)
  @Column(name = "representative")
  private String representative;

  @Column(name = "basic_amount")
  private BigDecimal basicAmount;
}
