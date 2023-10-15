package ToDoApplication.service;

import ToDoApplication.Repositories.UserRepositories;
import ToDoApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;


public class CreateUser {
@Autowired
    UserRepositories userRepositories;
    public User createUser(User user) throws IllegalArgumentException {
        if (user.getFirst_name() == null || user.getFirst_name().length() < 4) {
            throw new IllegalArgumentException("Meno kratke");
        }
        if (user.getSurename() == null || user.getSurename().length() < 4) {
            throw new IllegalArgumentException("Meno kratke");
        }
        if (user.getEmail_address() == null || !user.getEmail_address().contains("@")) {
            throw new IllegalArgumentException("Email nesmie byt prazny alebo je nespravny");
        }
        if (user.getPhone()==null){
            throw new IllegalArgumentException("Telefonne cislo nesmie byt prazny");
        }
        return userRepositories.save(user);
    }
}
