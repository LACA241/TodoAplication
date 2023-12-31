package ToDoApplication.Controller;
import ToDoApplication.Repositories.UserRepositories;
import ToDoApplication.dto.UserRecord;
import ToDoApplication.model.User;
import ToDoApplication.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/Users",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepositories userRepositories;

    @Tag(name = "Testing")
    @GetMapping(value = "/test/{id}")
    public ResponseEntity<String> test(@PathVariable("id") Long id,
                                       @RequestParam(value = "filter", required = false) String filter, @RequestBody(required = false) String body) {
        if (filter == null) {
            return ResponseEntity.badRequest().body("Chybne data");
        }
        if (body == null) {
            return ResponseEntity.badRequest().body("Chyba request Body");
        }
        return ResponseEntity.ok("Ok");
    }

    @GetMapping(value = "/id")
    public UserRecord getUserById(@RequestParam Long id) {
        UserRecord user = userService.loadUser(id);
        return user;
    }

    @Tag(name = "UserEndpoints")
    @Operation(summary = "This endpoint returns details about user with specific ID")
    @Parameters(value = {
            @Parameter(name = "id", description = "ID of user to be read")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned details about specific user"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserRecord> getUser(@PathVariable("id") Long id) {

        log.debug("findUserById {}", id);

        if (id == null || id < 0) {
            return ResponseEntity.badRequest().build();
        }

        UserRecord userRecord = userService.loadUser(id);

        return ResponseEntity.ok(userRecord);
    }

    @Tag(name = "UserEndpoints")
    @PostMapping(value = "/")
    public ResponseEntity<User> createUser (@RequestBody UserRecord userRecord ){
        User userCreated = userService.createUser(userRecord);

        return ResponseEntity.ok(userCreated);
    }
    @Tag(name = "UserEndpoints")
    @GetMapping(value = "/search")
    public ResponseEntity<List<User>> searchUsers(
            @RequestParam(name = "nameQuery", required = false) String name) {

        List<User> userList = userService.findByNameContaining(name);

        return ResponseEntity.ok(userList);
    }

}