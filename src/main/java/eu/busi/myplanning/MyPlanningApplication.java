package eu.busi.myplanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyPlanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPlanningApplication.class, args);
    }

}
