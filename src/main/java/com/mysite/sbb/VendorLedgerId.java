package com.mysite.sbb;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

@Getter
@Setter
@Embeddable
public class VendorLedgerId implements Serializable {
  private static final long serialVersionUID = 8441376574280759208L;

  @Size(max = 50)
  @NotNull
  @Column(name = "number", nullable = false, length = 50)
  private String number;

  @NotNull
  @Column(name = "transaction_date", nullable = false)
  private LocalDate transactionDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    VendorLedgerId entity = (VendorLedgerId) o;
    return Objects.equals(this.number, entity.number)
        && Objects.equals(this.transactionDate, entity.transactionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, transactionDate);
  }
}
