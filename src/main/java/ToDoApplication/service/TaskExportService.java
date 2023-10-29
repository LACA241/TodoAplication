package ToDoApplication.service;

import ToDoApplication.Repositories.TaskRepositories;
import ToDoApplication.dto.TaskRecord;
import ToDoApplication.model.Task;
import ToDoApplication.model.TaskExport;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;
@Configuration
public class TaskExportService {
    @Autowired
    TaskRepositories taskRepositories;


    public TaskExport exportAllTask() {

        TaskExport export = new TaskExport();
        List<Task> taskList = taskRepositories.findAll();
        for (Task task : taskList) {
            TaskRecord record = TaskRecord.builder()
                    .idtask(task.getId()).title(task.getTitle()).description(task.getDescription()).status(task.getStatus())
                    .duedate(String.valueOf(task.getDuedate())).iduser(task.getId())
                    .build();

            TaskRecord.taskRecordList.add(record);
        }
        return export;
    }
}

