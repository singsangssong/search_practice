package search.search_practice.service;


import search.search_practice.dto.MemberDTO;

public interface MemberService {
    void join(MemberDTO memberDTO) throws Exception;

    void modify(MemberDTO memberDTO) throws Exception;

    void delete(MemberDTO memberDTO) throws Exception;
}
