package co.com.sofka.dojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DojoApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DojoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DojoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
