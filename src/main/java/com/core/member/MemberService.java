//회원 서비스 인터페이스
package com.core.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
