package ToDoApplication;


import ToDoApplication.Repositories.UserRepositories;
import ToDoApplication.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.data.domain.Pageable;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserRepositoryTests {
    @Autowired
    UserRepositories repositories;

    @Test
    void testLoadUsersBySearcheString(){
        Pageable pageable= PageRequest.of(0,2, Sort.by("firstname"));
        List<User>userList=repositories.findAllByFirstnameContaining("ze",pageable);
        assertThat(userList).hasSize(1);
    }
    @Test
    void testLoadUsers() {
        List<User> userList = repositories.findAll();
        assertThat(userList).isNotEmpty();
    }
    @Test
    void testLoadUsersByEmailAddress(){
        List<User>userList=repositories.findByEmailAddress("zzelazny@yahoo.com");
        assertThat(userList).isNotEmpty();
    }
    @Test
    void testLoadUsersByFirstNameOrSurename(){
        List<User>userList=repositories.findAllByFirstnameOrSurename("Peter","");
    }
    @Test
    void testLoadUsersByPhone(){
        List<User>userList=repositories.findByPhone(903654951L);
    }
}
