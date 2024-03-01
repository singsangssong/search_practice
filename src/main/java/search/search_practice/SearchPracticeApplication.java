package search.search_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SearchPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchPracticeApplication.class, args);
    }

}
