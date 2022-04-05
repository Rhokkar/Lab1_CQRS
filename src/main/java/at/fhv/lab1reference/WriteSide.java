package at.fhv.lab1reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("writeside")
public class WriteSide {
    public static void start(String[] args) {
        SpringApplication.run(WriteSide.class, args);
    }
}

// localhost:8081/swagger-ui/index.html