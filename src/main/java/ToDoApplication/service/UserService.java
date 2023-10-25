package ToDoApplication.service;

import ToDoApplication.Repositories.TaskRepositories;
import ToDoApplication.Repositories.UserRepositories;
import ToDoApplication.dto.UserRecord;
import ToDoApplication.model.User;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.rest.webmvc.PersistentEntityResource.build;

@Component
@Transactional
@Slf4j


public class UserService {
    @Autowired
    UserRepositories userRepositories;
    public UserRecord loadUser(Long id) {
        Optional<User> userOptional = userRepositories.findById(id);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User nebol najdeny");
        }
        UserRecord record = new UserRecord();

        return record;
    }

    public User createUser(User user) throws IllegalArgumentException {

        UserRecord userRecord = new UserRecord();

        List<User> users = userRepositories.findAll();

        for(User user : users) {
            UserRecord record = UserRecord.builder()
                    .firstName(user.getFirst_name()+ " " + user.getSurename()+" " +user
                            .getEmail_address()+" "+user.getPhone())
                     .build();

           userRepositories.save(user);
        }
        return createUser(user);
    }
    public List<User> findByNameContaining(String firstname) {
        return userRepositories.findAllByFirstnameContaining(firstname);
    }
    public Optional<User>findByIduser(Long id){
        return  userRepositories.findById(id);
    }
}

