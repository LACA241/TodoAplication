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
public class UserRecord {
    public String firstName, surname, email;
    public Long Phone;

    List<UserRecord>recordList= new ArrayList<>();
}

