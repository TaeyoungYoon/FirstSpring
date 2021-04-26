package com.example.firstExam;

import com.example.firstExam.repository.MemberMemoryRepository;
import com.example.firstExam.repository.MemberRepository;
import com.example.firstExam.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemberMemoryRepository();
    }
}
