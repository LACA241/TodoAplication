package ToDoApplication.dto;

import ToDoApplication.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRecord {
    public String firstName, surname, email;
    List<UserRecord>recordList= new ArrayList<>()
}
