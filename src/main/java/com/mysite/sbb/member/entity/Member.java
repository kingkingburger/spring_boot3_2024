package com.mysite.sbb.member.entity;

import com.mysite.sbb.common.entity.BaseTimeEntity;
import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.member.dto.request.MemberRegisterRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Entity
@Table(name="member", uniqueConstraints = {
        @UniqueConstraint(name = "UK_MEMBER_EMAIL", columnNames = "email")
})
public class Member extends BaseTimeEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(length = 100)
    private String password;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="company_id", foreignKey = @ForeignKey(name = "FK_MEMBER_COMPANY"))
    private Company company;

    @Builder
    public Member(String email, String password, Company company) {
        this.email = email;
        this.password = password;
        this.company = company;
    }

    public static Member of (MemberRegisterRequest newMemberInfo){
        return Member.builder()
                .email(newMemberInfo.email())
                .password(newMemberInfo.password())
                .build();
    }

    public void update(
            final String email,
            final String password,
            final Company company
    ){
        this.email = email;
        this.password = password;
        this.company = company;
    }
}
