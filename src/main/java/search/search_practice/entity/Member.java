package search.search_practice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "role")
public class Member extends TimeRecordEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String phoneNumber;

    @ElementCollection(fetch = FetchType.LAZY)
    // 별도의 table에서 관리함. 지연 로딩에 의해 실제 사용전까지 DB에 로딩되지 않음.
    @Builder.Default
    private Set<MemberRole> role = new HashSet<>();

    public void changePassword(String pw) { this.password = pw; }

    public void setRole(MemberRole role) {
        this.role.add(role); }
    // 직접 set함수 작성하는데, role처럼 enum을 다룰 때는 add함수 사용해야함.
}
