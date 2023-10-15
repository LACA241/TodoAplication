package ToDoApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRecord {
    public String firstName, surname, email;
    List<UserRecord>recordList= new ArrayList<>();
}
public class CreateUser {
    public String firstname,surname,emailaddress;
    public int id,phone;
    Optional<UserRecord> recordList=new ArrayList<Object>(User);

}