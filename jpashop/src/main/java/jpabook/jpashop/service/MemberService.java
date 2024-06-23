package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)    // 조회같은 메서드가 많을경우 이런식으로 선언해주면 빨리 조회가 가능하다
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional(readOnly = false)  // 여기ㅣ 메서드는 등록이기 때문에 이런식으로 false처리를 해준다
    public Long join(Member member){
        validateDuplicateMember(member);  //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){    //이것도 동시에  회원이 같은 name으로 회원등록을 한다면 문제 될 수 있다.
        List<Member> findMembers = memberRepository.finaByName(member.getName());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    //단건 조회일 경우
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }


}
