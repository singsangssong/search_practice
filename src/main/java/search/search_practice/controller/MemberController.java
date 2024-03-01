package search.search_practice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import search.search_practice.dto.MemberDTO;
import search.search_practice.service.MemberService;

@RestController
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody MemberDTO memberDTO) throws Exception {

        log.info("-----------------회원 가입 시작-----------------");
        log.info(memberDTO);

        try {
            memberService.join(memberDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/modify")
    public ResponseEntity<Void> modify(@RequestBody MemberDTO memberDTO) throws Exception {
        log.info("-----------------회원 정보 수정 시작---------------------");
        log.info(memberDTO);

        try {
            memberService.modify(memberDTO);
        } catch (Exception e) { // 만약 DB에 현재 회원의 정보가 존재하지 않는다면
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody MemberDTO memberDTO) throws Exception {
        log.info("-----------------회원 정보 삭제 시작---------------------");
        log.info(memberDTO);

        try {
            memberService.delete(memberDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
