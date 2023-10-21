package ToDoApplication.Controller;
import ToDoApplication.dto.UserRecord;
import ToDoApplication.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/Users",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController {
    UserService service;
    @Tag(name="Testing")
@GetMapping(value="/test/{id}")
    public ResponseEntity<String>test(@PathVariable("id")Long id,
        @RequestParam(value = "filter",required = false) String filter,@RequestBody(required = false)String body){
        if (filter==null){
            return ResponseEntity.badRequest().body("Chybne data");
        }
        if (body==null){
            return ResponseEntity.badRequest().body("Chyba request Body");
        }
        return ResponseEntity.ok("Ok");
    }
    public UserRecord getUserById(@RequestParam Long id) {
        UserRecord user = service.loadUser(id);
        return user;
    }
}
