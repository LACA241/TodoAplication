package ToDoApplication;

import ToDoApplication.Repositories.TaskRepositories;
import ToDoApplication.Repositories.UserRepositories;
import ToDoApplication.model.Task;
import ToDoApplication.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.data.domain.Pageable;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Configuration
public class UserRepositoryTests {
    @Autowired
    UserRepositories repositories;
    @Autowired
    TaskRepositories tasks;

    @Test
    void testLoadUsersBySearcheString(){
        Pageable pageable= PageRequest.of(0,2, Sort.by("name"));
        List<User>userList=repositories.findAllByAnyName("ze",pageable);
        assertThat(userList).hasSize(2);

    }
    @Test
    void testLoadUsers() {
        List<User> userList = repositories.findAll();
        assertThat(userList).isNotEmpty();
    }
    @Test
    void testLoadUsersByEmailAddress(){
        //co caka odo mna  pri emailadrese???
        List<User>userList=repositories.findByEmailAddress();
        assertThat(userList).isNotEmpty();
    }
    @Test
    void testLoadUsersByFirstNameOrSurename(){
        List<User>userList=repositories.findAllByFirstnameOrSurename();
    }
}
