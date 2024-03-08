package com.mysite.sbb.company.entity;


import com.mysite.sbb.common.entity.BaseTimeEntity;
import com.mysite.sbb.company.service.dto.request.CompanyRegisterRequest;
import com.mysite.sbb.item.entity.Item;
import com.mysite.sbb.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@Entity
public class Company extends BaseTimeEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String code;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Member> memberList = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Item> itemList = new ArrayList<>();


    @Builder
    public Company(String code) {
        this.code = code;
    }

    public static Company of(CompanyRegisterRequest newCompanyInfo) {
        return Company.builder()
                .code(newCompanyInfo.code())
                .build();
    }

    public void update(
            String code
    ){
        this.code = code;
    }
}
