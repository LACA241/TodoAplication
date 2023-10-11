package ToDoApplication.service;

import ToDoApplication.Repositories.UserRepositories;
import ToDoApplication.dto.UserRecord;
import ToDoApplication.model.User;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
@Slf4j
public class UserService {
@Autowired
    UserRepositories userRepositories;
public User createUser(User user)throws IllegalArgumentException{
    if (user.getFirst_name() == null||user.getFirst_name().length()<4) {
        throw new IllegalArgumentException("Meno kratke");
    }
    if (user.getSurename() == null||user.getSurename().length()<4){
        throw new IllegalArgumentException("Meno kratke");
    }
if (user.getEmail_address()==null){
    throw new IllegalArgumentException("Email nesmie byt prazny");
}
    return userRepositories.save(user);
}

    public UserRecord loadUser(Long id) {

    }
}
