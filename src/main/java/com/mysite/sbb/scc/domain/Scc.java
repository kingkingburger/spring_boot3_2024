package com.hyundai.poc.scc.domain;

import com.hyundai.poc.awb.domain.Awb;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor
@Table
public class Scc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column()
    private String code;

    @ElementCollection
    @Column(name = "ban_list", nullable = true)
    private List<String> banList;

    @ManyToMany(mappedBy = "sccList")
    private List<Awb> awbs;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;


    //빌더
    @Builder
    public Scc(String code, List<String> banList) {
        this.code = code;
        this.banList = banList;
    }
}
