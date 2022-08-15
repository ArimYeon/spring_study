package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 스프링 데이터 JPA 사용
 * 구현체까지 알아서 만들어줌
 */

// JpaRepository를 상속받으면 알아서 구현체를 생성해서 스프링 빈으로 등록까지 해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL의 select  m from Member m where m.name = ? 로 알아서 짜줌
    @Override
    Optional<Member> findByName(String name);
}
