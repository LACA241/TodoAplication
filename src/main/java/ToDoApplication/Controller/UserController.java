package ToDoApplication.Controller;

import ToDoApplication.dto.UserRecord;
import ToDoApplication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/Users",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController {

    UserService service;

    public UserRecord getUserById(@RequestParam Long id) {
        UserRecord user = service.loadUser(id);

        return user;
    }

    public UserRecord () {
        return service;
    }
}
