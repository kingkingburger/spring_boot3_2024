package com.mysite.sbb.member.service;

import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.company.repository.CompanyRepository;
import com.mysite.sbb.member.dto.request.MemberRegisterRequest;
import com.mysite.sbb.member.dto.response.MemberInfoResponse;
import com.mysite.sbb.member.entity.Member;
import com.mysite.sbb.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
//@Transactional
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;
    private final CompanyRepository companyRepository;

    @Override
//    @Transactional
    public void registerMember(MemberRegisterRequest request){
        Member newMember = Member.of(request);
        Member entity = request.toEntity(getCompanyEntity(request.companyId()));
        memberRepository.save(entity);
    }

    @Override
//    @Transactional()
    public MemberInfoResponse getMemberInfoByEmail(String email){
        if(!memberRepository.existsMemberByEmail(email)){
            throw new RuntimeException("NOT FOUND MEMBER");
        }

        Member memberInfo = memberRepository.findMemberByEmail(email);
        return MemberInfoResponse.from(memberInfo);
    }

    @Override
    @Transactional()
    public void updateMember(Long memberId, MemberRegisterRequest request){
        Member savedMember = getMemberEntity(memberId);
        Company companyEntity = getCompanyEntity(request.companyId());
        log.info("[MemberService] 멤버를 수정합니다. 게시글 번호: {}", savedMember.getId());
        savedMember.update(
                companyEntity,
                request.email(),
                request.password()
        );
    }


    private Company getCompanyEntity(Long companyId){
        return Optional.ofNullable(companyId)
                .flatMap(companyRepository::findById)
                .orElseThrow(() -> new NotFoundException("company를 찾지 못했습니다."));
    }

    private Member getMemberEntity(Long memberId){
        return Optional.ofNullable(memberId)
                .flatMap(memberRepository::findById)
                .orElseThrow(() -> new NotFoundException("member를 찾지 못했습니다."));
    }



}
