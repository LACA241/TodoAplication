package ToDoApplication.Controller;

import ToDoApplication.dto.TaskRecord;
import ToDoApplication.dto.UserRecord;
import ToDoApplication.model.Task;
import ToDoApplication.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/Tasks",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class TaskController {
    TaskService taskService;

    public TaskRecord getTaskById(@RequestParam Long idtask) {
        TaskRecord task = taskService.loadTask(idtask);
        return task;
    }
    public TaskRecord putTask (@RequestParam Long idtask){
        TaskRecord task =taskService.putTask(idtask);
                return task;
    }
}
