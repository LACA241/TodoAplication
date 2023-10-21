package ToDoApplication.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskRecord {
    public String title, description, status,duedate;
    Long idtask,iduser;
    public static List<TaskRecord> taskRecordList= new ArrayList<>();
}

