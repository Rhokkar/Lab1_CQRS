package at.fhv.lab1reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("eventside")
public class EventSide {
    public static void start(String[] args) {
        SpringApplication.run(EventSide.class, args);
    }
}

// localhost:8082/swagger-ui/index.html