package ToDoApplication;


import ToDoApplication.Repositories.TaskRepositories;
import ToDoApplication.dto.TaskRecord;
import ToDoApplication.model.Task;
import java.util.Optional;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.DATE;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TaskRepositoryTests {
    @Autowired
    TaskRepositories repositories;

    @Test
    void loadTaskById() {
        Optional<Task> taskList = repositories.findById(2L);
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
 @Test
    void loadTaskByDueDate(){
        List<Task> taskList = repositories.findByDuedate(Date.valueOf("2023-12-15"));
        assertThat(taskList).isNotEmpty();
    }

    @Test
    void loadTaskByUpdatedDate (){
        List<Task> taskList=repositories.findByUpdateddate(Date.valueOf("2023-12-15"));
        assertThat(taskList).isEmpty();
    }
}
