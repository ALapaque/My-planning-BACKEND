package eu.busi.myplanning;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * The type My planning application.
 */
@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(info = @Info(title = "MyPlanning API", version = "0.0.1"))
public class MyPlanningApplication {

    /**
     * Init.
     */
    @PostConstruct
    public void init(){
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MyPlanningApplication.class, args);
    }
}
