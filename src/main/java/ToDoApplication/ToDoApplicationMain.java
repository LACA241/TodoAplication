package ToDoApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class ToDoApplicationMain {
    public static void main(String[] args) {

        SpringApplication.run(ToDoApplicationMain.class, args);
    }
}
