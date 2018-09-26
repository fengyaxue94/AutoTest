import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wb-fyx220651
 * @date 2018/9/25
 */
@SpringBootApplication
@ComponentScan("com.course.server")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
