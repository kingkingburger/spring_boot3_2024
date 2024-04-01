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
public class TransactionHistoryInquiryId implements Serializable {
  private static final long serialVersionUID = 1818682282553140881L;

  @Size(max = 50)
  @NotNull
  @Column(name = "vendor_code", nullable = false, length = 50)
  private String vendorCode;

  @NotNull
  @Column(name = "transaction_date", nullable = false)
  private LocalDate transactionDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    TransactionHistoryInquiryId entity = (TransactionHistoryInquiryId) o;
    return Objects.equals(this.transactionDate, entity.transactionDate)
        && Objects.equals(this.vendorCode, entity.vendorCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionDate, vendorCode);
  }
}
