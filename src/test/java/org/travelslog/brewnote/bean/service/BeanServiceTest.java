package org.travelslog.brewnote.bean.service;

import org.travelslog.brewnote.bean.Entity.Bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.*;

@Testcontainers
@SpringBootTest
public class BeanServiceTest {

    @Container
    static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16")
            .withDatabaseName("brewnote_test")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void overrideProps(DynamicPropertyRegistry r) {
        // 컨테이너가 랜덤 포트로 뜨기 때문에, 런타임에 URL을 주입해야 함
        r.add("spring.datasource.url", postgres::getJdbcUrl);
        r.add("spring.datasource.username", postgres::getUsername);
        r.add("spring.datasource.password", postgres::getPassword);

        // Flyway로 스키마 생성(테이블 생성)
        r.add("spring.flyway.enabled", () -> true);

        r.add("spring.jpa.hibernate.ddl-auto", () -> "none");
    }

    @Autowired BeanService beanService;

    @Test
    void create_get_update_delete() {
        Long id = beanService.create("Ethiopia Guji");

        Bean b1 = beanService.get(id);
        assertThat(b1.getBeanName()).isEqualTo("Ethiopia Guji");

        beanService.update(id, "Kenya AA", null, 25000, null);

        Bean b2 = beanService.get(id);
        assertThat(b2.getBeanName()).isEqualTo("Kenya AA");
        assertThat(b2.getPrice()).isEqualTo(25000);

        beanService.delete(id);
        assertThatThrownBy(() -> beanService.get(id))
                .isInstanceOf(IllegalArgumentException.class); // 예외 타입에 맞춰 나중에 구체화
    }
}