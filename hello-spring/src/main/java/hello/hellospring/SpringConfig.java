package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // Configuration에 있는 Bean 어노테이션을 보고 스프링 빈에 등록시켜줌
    @Bean
    public MemberService memberService(){
        // 스프링 빈에 있는 MemberRepository를 주입해줌
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
