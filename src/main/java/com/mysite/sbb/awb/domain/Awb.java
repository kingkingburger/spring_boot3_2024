package com.hyundai.poc.awb.domain;

import com.hyundai.poc.scc.domain.Scc;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Awb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column()
    private String barcode;

    @Column()
    private int separateNumber;

    @Column()
    private int waterVolume;

    @Column()
    private int squareVolume;

    @Column()
    private int width;

    @Column()
    private int length;

    @Column()
    private int depth;

    @Column()
    private int weight;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "awb_scc",
            joinColumns = @JoinColumn(name = "awb_id"),
            inverseJoinColumns = @JoinColumn(name = "scc_id")
    )
    private List<Scc> sccList;
}