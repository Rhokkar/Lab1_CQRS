package at.fhv.lab1reference;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Main {
    public static void main(String[] args) {
        EventSide.start(args);
        ReadSide.start(args);
        WriteSide.start(args);
    }
}
