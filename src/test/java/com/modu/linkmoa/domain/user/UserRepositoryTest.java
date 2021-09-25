package com.modu.linkmoa.domain.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("등록")
    public void save() throws Exception {

        // given
        Strategy strategy = Strategy.GOOGLE;
        String socialId = "107851073233461381620";
        String email = "opr99@naver.com";

        userRepository.save(User.builder()
                .strategy(strategy)
                .socialId(socialId)
                .email(email)
                .build());

        // when
        List<User> userList = userRepository.findAll();

        // then
        User user = userList.get(0);
        assertThat(user.getStrategy()).isEqualTo(strategy);
        assertThat(user.getSocialId()).isEqualTo(socialId);
        assertThat(user.getEmail()).isEqualTo(email);
    }
}