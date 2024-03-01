package search.search_practice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/*
* 데이터 추가시간 및 수정시간을 함께 저장하는 곳
* 모든 Entity에 함께 동작하기에 공통으로 칼럼 지정하고 쉽게 저장됨.
* */

@MappedSuperclass // 공통되는 매핑 정보를 한곳에서 관리할 수 있도록 해줌.
@EntityListeners(value = {AuditingEntityListener.class})
// entity에 이벤트가 발생하면 함께 동작하는 어노테이션. 이중 날짜 수정이 AuditingEntityListener
@Getter
abstract class TimeRecordEntity {
    @CreatedDate // 처음 event가 발생하면 생성됨.
    @Column(name = "regDate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate // 수정한 날짜가 저장됨.
    @Column(name = "modDate")
    private LocalDateTime modDate;
}
