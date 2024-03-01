package search.search_practice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import search.search_practice.dto.MemberDTO;
import search.search_practice.entity.Member;
import search.search_practice.entity.MemberRole;
import search.search_practice.repository.MemberRepository;

import java.net.PasswordAuthentication;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;

    /*
    * 회원가입
    *
    * 1. private key를 통해 회원email 정보를 확인
    * 2. 회원 정보가 이미 있는 거면 빠꾸먹임
    * 3. email 겹치는거 없으면 일반 회원으로 가입시킴.
    * */
    @Override
    public void join(MemberDTO memberDTO) throws Exception {
        boolean exist = memberRepository.existsByEmail(memberDTO.getEmail());

        if(exist) { // 현재 입력한 정보가 이미 있는 정보라면
            throw new Exception();
        }

        Member member = modelMapper.map(memberDTO, Member.class);
        member.setRole(MemberRole.MEMBER);
        // 비밀번호 암호화해야함.
        memberRepository.save(member);
    }

    /*
    * 회원정보 수정
    * 1. email을 통해서 기존에 존재하는 회원인지 확인
    * 2. 없는 회원이면 빠꾸
    * 3. 있는 회원이면 기존 정보를 새롭게 수정해줌
    *
    * save로 기존 회원정보를 지우고 새롭게 저장하면 등록기간이랑 수정기간이 모두 바뀔까?
    *
    * */
   @Override
    public void modify(MemberDTO memberDTO) throws Exception {
       boolean exist = memberRepository.existsByEmail(memberDTO.getEmail());

       if(!exist) { // 현재 회원 정보가 존재하지 않는다면
           throw new Exception();
       }

       Member member = modelMapper.map(memberDTO, Member.class); // 회원 lv 설정?
       // 비밀번호 암호화해야함.
       memberRepository.save(member);
   }

   @Override
    public void delete(MemberDTO memberDTO) throws Exception {
       boolean exist = memberRepository.existsByEmail(memberDTO.getEmail());

       if(!exist) {
           throw new Exception();
       }

       memberRepository.deleteByEmail(memberDTO.getEmail());
   }
}
