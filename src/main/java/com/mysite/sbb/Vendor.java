package com.mysite.sbb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vendor")
public class Vendor {
  @Id
  @Size(max = 255)
  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "is_inactive")
  private Boolean isInactive;

  @Size(max = 255)
  @Column(name = "name")
  private String name;

  @Size(max = 255)
  @Column(name = "quick_search")
  private String quickSearch;

  @Size(max = 255)
  @Column(name = "type")
  private String type;

  @Size(max = 255)
  @Column(name = "default_inventory")
  private String defaultInventory;

  @Column(name = "credit_limit")
  private BigDecimal creditLimit;

  @Column(name = "pricing_apply")
  private Integer pricingApply;

  @Column(name = "vat_exclusive")
  private Boolean vatExclusive;

  @Size(max = 255)
  @Column(name = "in_charge_staff")
  private String inChargeStaff;

  @Size(max = 255)
  @Column(name = "phone_number")
  private String phoneNumber;

  @Size(max = 255)
  @Column(name = "mobile_phone")
  private String mobilePhone;

  @Size(max = 255)
  @Column(name = "fax_number")
  private String faxNumber;

  @Size(max = 255)
  @Column(name = "business_name")
  private String businessName;

  @Size(max = 255)
  @Column(name = "business_number")
  private String businessNumber;

  @Size(max = 255)
  @Column(name = "representative")
  private String representative;

  @Size(max = 255)
  @Column(name = "business_field")
  private String businessField;

  @Size(max = 255)
  @Column(name = "business_type")
  private String businessType;

  @Column(name = "new_address", length = Integer.MAX_VALUE)
  private String newAddress;

  @Column(name = "note", length = Integer.MAX_VALUE)
  private String note;

  @Column(name = "last_transaction_date")
  private LocalDate lastTransactionDate;

  @Column(name = "registration_date")
  private Instant registrationDate;

  @Size(max = 255)
  @Column(name = "registered_by")
  private String registeredBy;

  @Column(name = "modification_date")
  private Instant modificationDate;

  @Size(max = 255)
  @Column(name = "modified_by")
  private String modifiedBy;

  @Size(max = 255)
  @Column(name = "tax_manager")
  private String taxManager;

  @Size(max = 255)
  @Column(name = "manager_phone")
  private String managerPhone;

  @Size(max = 255)
  @Column(name = "email")
  private String email;

  @Column(name = "transaction_criteria", length = Integer.MAX_VALUE)
  private String transactionCriteria;

  @Size(max = 255)
  @Column(name = "order_reception_id")
  private String orderReceptionId;

  @Size(max = 255)
  @Column(name = "delivery_day")
  private String deliveryDay;

  @Column(name = "old_address", length = Integer.MAX_VALUE)
  private String oldAddress;
}
