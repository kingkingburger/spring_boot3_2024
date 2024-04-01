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
public class TransactionDataModificationId implements Serializable {
  private static final long serialVersionUID = 3773403007268931464L;

  @Size(max = 255)
  @NotNull
  @Column(name = "slip_number", nullable = false)
  private String slipNumber;

  @NotNull
  @Column(name = "sequence_number", nullable = false)
  private Integer sequenceNumber;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    TransactionDataModificationId entity = (TransactionDataModificationId) o;
    return Objects.equals(this.sequenceNumber, entity.sequenceNumber)
        && Objects.equals(this.slipNumber, entity.slipNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sequenceNumber, slipNumber);
  }
}
