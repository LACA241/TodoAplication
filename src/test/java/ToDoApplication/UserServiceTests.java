package ToDoApplication;

import ToDoApplication.Repositories.UserRepositories;
import ToDoApplication.dto.UserRecord;
import ToDoApplication.model.User;
import ToDoApplication.service.UserService;

import java.util.ArrayList;
import java.util.Optional;
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

UserRecord userRecord=new UserRecord();

@Test
void findUserOk(){
    Optional<User> userOptional=userService.findByIduser(1L);
    assertThat(userOptional).isNotNull();
    assertThat(userOptional.get().getFirst_name()).isEqualTo("Peter");
}
@Test
    void findByNameContaining(){
List<User>userList=userService.findByNameContaining("P");
assertThat(userList).isNotEmpty();
assertThat(userList.get(0).getFirst_name());
}
@Test
    void createUser(){
    Optional<User>userOptional=userService.createUser();
    assertThat(0).isNotNull();
    assertThat(userOptional.get().getId());

}
}
