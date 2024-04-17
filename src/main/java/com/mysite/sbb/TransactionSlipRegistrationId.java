package com.mysite.sbb;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

@Getter
@Setter
@Embeddable
public class TransactionSlipRegistrationId implements Serializable {
  private static final long serialVersionUID = -4100417727946830713L;

  @Size(max = 255)
  @NotNull
  @Column(name = "item_code", nullable = false)
  private String itemCode;

  @Size(max = 255)
  @NotNull
  @Column(name = "inventory_location", nullable = false)
  private String inventoryLocation;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    TransactionSlipRegistrationId entity = (TransactionSlipRegistrationId) o;
    return Objects.equals(this.itemCode, entity.itemCode)
        && Objects.equals(this.inventoryLocation, entity.inventoryLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemCode, inventoryLocation);
  }
}
