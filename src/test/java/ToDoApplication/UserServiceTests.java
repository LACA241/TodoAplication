package ToDoApplication;

import ToDoApplication.model.User;
import ToDoApplication.service.UserService;
import org.apache.el.stream.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTests {
@Autowired
    UserService userService;

@Test
void findUserOk(){
    Optional<User> userOptional=userService.findByIduser(1L);
    assertThat(userOptional).isNotNull();
    assertThat(userOptional.get()).isEqualTo("Peter");
}
}
