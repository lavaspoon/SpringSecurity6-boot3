package devlava.springsecurity6.repository;

import devlava.springsecurity6.entity.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername() throws Exception {
        //given

        //when
        User user = userRepository.findByUsername("admin").orElseThrow();
        //then
        System.out.println("user = " + user);
    }
}