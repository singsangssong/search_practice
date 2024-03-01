package search.search_practice.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                // 필드 매칭 활성화. 소스객체와 대상 객체의 필드이름이 동일하면 자동 매핑
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                // 접근 lv을 private으로 설정. private 필드 접근 허용 + 해당 필드도 매핑 대상에 포함됨.
                .setMatchingStrategy(MatchingStrategies.LOOSE);
                // 매칭 전략을 LOOSE로 설정. 타입변환이 가능하면 매핑해버림.

        return modelMapper;
    }
}
