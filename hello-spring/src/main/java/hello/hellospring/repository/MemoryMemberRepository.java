package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //키값 생성해주는 역할

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id 세팅
        store.put(member.getId(), member); //store에 저장
        return member; //저장 결과 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null이어도 감싸서 반환 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //member의 name == 파라미터 name인지
                .findAny(); //하나라도 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear(); //store초기화
    }
}
