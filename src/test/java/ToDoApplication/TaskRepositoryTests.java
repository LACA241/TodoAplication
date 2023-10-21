package ToDoApplication;


import ToDoApplication.Repositories.TaskRepositories;
import ToDoApplication.dto.TaskRecord;
import ToDoApplication.model.Task;
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
public class TaskRepositoryTests {
    @Autowired
    TaskRepositories repositories;

    @Test
    void loadTaskById() {
        List<Task> taskList = repositories.findById(2);
        assertThat(taskList).isNotEmpty();
    }

    @Test
    void loadTaskByTitle() {
        List<Task> taskList = repositories.findByTitle("work");
        assertThat(taskList).isNotEmpty();
    }

    @Test
    void loadTaskByDescription() {
        List<Task> taskList = repositories.findByDescription("Car to workshop");
        assertThat(taskList).isNotEmpty();
    }

    @Test
    void loadTaskByStatus() {
        List<Task> taskList = repositories.findByStatus("Initial");
        assertThat(taskList).isNotEmpty();
    }

    @Test
    void loadAllTasks(){
        List<Task>taskList= repositories.findAll();
        assertThat(taskList).isNotEmpty();
    }
 /* @Test
    void loadTaskByDueDate(){
        List<Task> taskList = repositories.findByDueDate("2023-12-15");
        assertThat(taskList).isNotEmpty();
    }

    @Test
    void loadTaskByUpdatedDate (){
        List<Task> taskList=repositories.findByUpdatedDate("2023-12-15 ");
        assertThat(taskList).isEmpty();
    }*/
}
