package com.mysite.sbb;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "company")
public class Company {
  @Id @GeneratedValue private Integer id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "code_number", nullable = false)
  private Long codeNumber;

  @Column(name = "not_used")
  private Boolean notUsed;

  @Column(name = "client_name")
  private String clientName;

  @Column(name = "quick_search")
  private String quickSearch;

  @Column(name = "classification")
  private String classification;

  @Column(name = "default_stock_place")
  private String defaultStockPlace;

  @Column(name = "credit_limit")
  private Double creditLimit;

  @Column(name = "unit_price_application")
  private String unitPriceApplication;

  @Column(name = "tax_excluded")
  private Boolean taxExcluded;

  @Column(name = "employee_in_charge")
  private String employeeInCharge;

  @Column(name = "telephone_number")
  private String telephoneNumber;

  @Column(name = "mobile_phone_number")
  private String mobilePhoneNumber;

  @Column(name = "fax_number")
  private String faxNumber;

  @Column(name = "business_name")
  private String businessName;

  @Column(name = "business_number")
  private String businessNumber;

  @Column(name = "representative")
  private String representative;

  @Column(name = "business_condition")
  private String businessCondition;

  @Column(name = "business_type")
  private String businessType;

  @Column(name = "new_road_name_address")
  private String newRoadNameAddress;

  @Column(name = "notes")
  private String notes;

  @Column(name = "last_transaction_date")
  private LocalDate lastTransactionDate;

  @Column(name = "registration_date_time")
  private LocalDateTime registrationDateTime;

  @Column(name = "registrar")
  private String registrar;

  @Column(name = "modification_date_time")
  private LocalDateTime modificationDateTime;

  @Column(name = "modifier")
  private String modifier;

  @Column(name = "tax_manager")
  private String taxManager;

  @Column(name = "manager_mobile_phone")
  private String managerMobilePhone;

  @Column(name = "email_address")
  private String emailAddress;

  @Column(name = "transaction_base")
  private String transactionBase;

  @Column(name = "order_reception_id")
  private String orderReceptionID;

  @Column(name = "delivery_day")
  private String deliveryDay;

  @Column(name = "old_lot_number_address")
  private String oldLotNumberAddress;
}
