package com.example.firstExam.service;

import com.example.firstExam.Domain.Member;
import com.example.firstExam.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        //중복회원 방지
        duplicateMember(member);
        memberRepository.save(member);
        return  member.getId();


    }

    private void duplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 중복 된 회원 입니다.");
        });
    }

    public List<Member> findMembers(){
        return memberRepository.findall();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);

    }
}
