package at.fhv.lab1reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("readside")
public class ReadSide {
    public static void start(String[] args) {
        SpringApplication.run(ReadSide.class, args);
    }
}

// localhost:8083/swagger-ui/index.html