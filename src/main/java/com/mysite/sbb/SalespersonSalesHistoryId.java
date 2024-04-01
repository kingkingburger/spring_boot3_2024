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
public class SalespersonSalesHistoryId implements Serializable {
  private static final long serialVersionUID = 9154274072388664764L;

  @Size(max = 255)
  @NotNull
  @Column(name = "salesperson_name", nullable = false)
  private String salespersonName;

  @Size(max = 255)
  @NotNull
  @Column(name = "vendor_name", nullable = false)
  private String vendorName;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    SalespersonSalesHistoryId entity = (SalespersonSalesHistoryId) o;
    return Objects.equals(this.salespersonName, entity.salespersonName)
        && Objects.equals(this.vendorName, entity.vendorName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(salespersonName, vendorName);
  }
}
