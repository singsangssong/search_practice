package search.search_practice.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import search.search_practice.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    @EntityGraph(attributePaths = "role")
    boolean existsByEmail(String email);

    @Modifying
    @Transactional
    void deleteByEmail(String email);
}
