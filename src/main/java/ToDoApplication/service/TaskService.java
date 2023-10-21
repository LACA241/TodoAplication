package ToDoApplication.service;

import ToDoApplication.Repositories.TaskRepositories;
import ToDoApplication.dto.TaskRecord;
import ToDoApplication.dto.UserRecord;
import ToDoApplication.model.Task;
import ToDoApplication.model.User;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
@Slf4j
public class TaskService {
    @Autowired
    TaskRepositories taskRepositories;
    public TaskRecord loadTask(Long id) {
        Optional<Task> taskOptional = taskRepositories.findById(id);
        if (taskOptional.isEmpty()) {
            throw new IllegalArgumentException("Task nebol najdeny");
        }
        TaskRecord record = new TaskRecord();
        return record;
    }
    public TaskRecord putTask(Long idtask){
        Optional<Task>taskOptional=taskRepositories.findById(idtask);
        if (taskOptional.isEmpty()){
            throw new IllegalArgumentException("Task bol  ulozeny");
        }
        TaskRecord record=new TaskRecord();
        return record;
    }



}
