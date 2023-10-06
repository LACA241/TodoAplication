package ToDoAplication.Repositories;

import ToDoAplication.model.Task;
import ToDoAplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RestResource(path = "tasks")
public interface TaskRepositories extends JpaRepository<User, Long> {
}
