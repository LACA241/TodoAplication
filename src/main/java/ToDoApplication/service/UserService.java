package ToDoApplication.service;

import ToDoApplication.Repositories.UserRepositories;
import ToDoApplication.dto.UserRecord;
import ToDoApplication.model.User;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        return UserRecord.builder()
                .firstName(userOptional.get().getFirst_name())
                .surname(userOptional.get().getSurename())
                .build();
    }

    public User createUser(UserRecord userRecord) throws IllegalArgumentException {

        User user = new User();
        user.setFirst_name(userRecord.getFirstName());
        user.setSurename(userRecord.getSurname());

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

        List<User> existingUsers = userRepositories.findByEmailAddress(userRecord.getEmail());
        if (existingUsers.size() > 0)
            throw new IllegalArgumentException("Email existuje");

      /*  User user = new User();
        user.setFirst_name(userRecord.getFirstName());
        user.setSurename(userRecord.getSurname());
*/
        return userRepositories.save(user);
    }

    public List<User> findByNameContaining(String firstname) {
        return userRepositories.findAllByFirstnameContaining(firstname,
                PageRequest.of(0,100));
    }
    public Optional<User>findByIduser(Long id){
        return  userRepositories.findById(id);
    }
}

