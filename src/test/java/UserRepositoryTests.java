
import ToDoAplication.Repositories.UserRepositories;
import ToDoAplication.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserRepositoryTests {
    @Autowired
    UserRepositories repositories;

    @Test
    void testLoadUsers() {
        List<User> userList = repositories.findAll();
        assertThat(userList).isNotEmpty();
    }


}
