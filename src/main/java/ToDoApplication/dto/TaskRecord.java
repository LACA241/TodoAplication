package ToDoApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRecord {
    public String title, description, status,due_date;
    int id_task,id_user;
    List<TaskRecord> recordList= new ArrayList<>();
}
