//회원 서비스 구현체
package com.core.member;

/*
클라이언트인 MemberServiceImpl 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것과 같다고 해서
DI(Dependency Injection) 의존관계 주입이라고 한다!
 */
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    // [생성자 주입]
    // 이렇게 함으로써 MemberRepository 라는 인터페이스 (추상화) 에 의존하게 된다.
    // MemberRepository 에 대한 의존성은 AppConfig 에서 줌으로써 DIP 원칙 보존
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
