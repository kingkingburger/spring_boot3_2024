package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "basic_inventory")
public class BasicInventory {
  @Id @GeneratedValue private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "item_code", nullable = false)
  private ItemBasic ItemBasic;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vendor_code", nullable = false)
  private Vendor vendor;

  //  @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = false)
  //  private List<BasicBalance> basicBalanceList = new ArrayList<>();

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
