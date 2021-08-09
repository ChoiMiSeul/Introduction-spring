package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원 저장시 저장된 회원 반환
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String id);
    List<Member> findAll(); //저장된 모든 회원 리스트
}
