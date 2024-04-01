package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "basic_inventory_registration")
public class BasicInventoryRegistration {
  @Id
  @Size(max = 255)
  @Column(name = "item_code", nullable = false)
  private String itemCode;

  @MapsId
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "item_code", nullable = false)
  private ItemRegistration itemRegistration;

  @Size(max = 255)
  @Column(name = "item_type")
  private String itemType;

  @Size(max = 255)
  @Column(name = "name")
  private String name;

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

  @Column(name = "basic_inventory_quantity")
  private Integer basicInventoryQuantity;

  @Column(name = "purchase_price")
  private BigDecimal purchasePrice;

  @Column(name = "basic_inventory_amount")
  private BigDecimal basicInventoryAmount;

  @Size(max = 255)
  @Column(name = "supplier_name")
  private String supplierName;
}
