package ToDoApplication.Controller;

import ToDoApplication.dto.TaskRecord;
import ToDoApplication.dto.UserRecord;
import ToDoApplication.model.Task;
import ToDoApplication.model.TaskExport;
import ToDoApplication.service.TaskExportService;
import ToDoApplication.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/Tasks",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class TaskController {
    TaskService taskService;
    @Autowired
    TaskExportService taskExportService;
@RequestMapping(value = "/{idtask}")
    public TaskRecord getTaskById(@RequestParam Long idtask) {
        TaskRecord task = taskService.loadTask(idtask);
        return task;
    }
    @PutMapping(value = "/{idtask}")
    public TaskRecord putTask (@RequestParam Long idtask){
        TaskRecord task =taskService.putTask(idtask);
                return task;
    }

    @GetMapping(value = "/idUser")
    public TaskRecord getTaskByUser(@RequestParam Long id){
    TaskRecord task=taskService.loadTask(id);
    return task;
    }

    @Tag(name = "TaskEndpoints")
    @Tag(name = "Export")
    @GetMapping(value = "/exportAllTask")
    public TaskExport exportTasks() {
        return taskExportService.exportAllTask();
    }
}
