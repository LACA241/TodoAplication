package ToDoApplication.Repositories;

import ToDoApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "tasks")
public interface TaskRepositories extends JpaRepository<User, Long> {
}
