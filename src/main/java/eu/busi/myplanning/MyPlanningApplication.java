package eu.busi.myplanning;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(info = @Info(title = "MyPlanning API", version = "0.0.1"))
public class MyPlanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPlanningApplication.class, args);
    }

}
