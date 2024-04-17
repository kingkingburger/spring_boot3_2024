package com.mysite.sbb;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inventory_specification")
public class InventorySpecification {
  @Id
  @Size(max = 50)
  @Column(name = "item_code", nullable = false, length = 50)
  private String itemCode;

  @MapsId
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "item_code", nullable = false)
  private ItemBasic ItemBasic;

  @Size(max = 255)
  @Column(name = "item_name")
  private String itemName;

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

  @Column(name = "purchase_price")
  private BigDecimal purchasePrice;

  @Column(name = "carry_over_quantity")
  private Integer carryOverQuantity;

  @Column(name = "incoming_quantity")
  private Integer incomingQuantity;

  @Column(name = "carry_over_amount")
  private BigDecimal carryOverAmount;

  @Column(name = "outgoing_quantity")
  private Integer outgoingQuantity;

  @Column(name = "transfer_in_quantity")
  private Integer transferInQuantity;

  @Column(name = "transfer_out_quantity")
  private Integer transferOutQuantity;

  @Column(name = "current_stock_quantity")
  private Integer currentStockQuantity;

  @Column(name = "current_stock_amount")
  private BigDecimal currentStockAmount;

  @Column(name = "box_inventory")
  private Integer boxInventory;

  @Column(name = "ea_inventory")
  private Integer eaInventory;

  @Column(name = "optimal_inventory")
  private Integer optimalInventory;

  @Column(name = "shortage")
  private Integer shortage;
}
