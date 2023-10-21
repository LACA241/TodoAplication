package ToDoApplication.service;

import ToDoApplication.Repositories.UserRepositories;
import ToDoApplication.dto.UserRecord;
import ToDoApplication.model.User;
import ToDoApplication.model.UserExport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserExportService {
@Autowired
    UserRepositories userRepositories;
 public UserExport createUser(){

UserExport export = new UserExport();
     List<User>userList=userRepositories.findAll();
for (User user:userList) {
    UserRecord record = UserRecord.builder()
            .firstName(user.getFirst_name())
            .Phone(user.getPhone())
            .surname(user.getSurename())
            .email(user.getEmail_address())
            .build();

    export.recordList.add(record);
}
return export;

 }
}
