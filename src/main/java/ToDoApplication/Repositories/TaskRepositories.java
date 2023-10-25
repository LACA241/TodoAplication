package ToDoApplication.Repositories;

import ToDoApplication.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@RestResource(path = "tasks")
@Repository
public interface TaskRepositories extends JpaRepository<Task, Long> {
    @Query
    List<Task>findByTitle(String title);
    @Query
    List<Task>findByDescription(String description);
    @Query
    List<Task>findByStatus(String status);

    List<Task>findByDuedate(Date duedate);


    @Query
    List<Task>findByUpdateddate(Date updateddate);

}
