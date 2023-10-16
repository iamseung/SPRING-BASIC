// 회원 저장소 인터페이스
package com.core.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
