package com.example.firstExam.repository;

import com.example.firstExam.Domain.Member;

import java.util.*;

public class MemberMemoryRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();//저장소 선언
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence) ;
        store.put(member.getId(),member) ;
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findall() {
        return new ArrayList<>(store.values());
    }

    public void storeClear(){
        store.clear();
    }
}
