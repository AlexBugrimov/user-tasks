package dev.bug.usertasks;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class UserTasksApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void shouldLoadedApplicationContext() {
        assertThat(applicationContext).isNotNull();
    }

}
