import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@Slf4j
@EnableScheduling
public class ToDoApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ToDoApplicationMain.class, args);
    }
}
