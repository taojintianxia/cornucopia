package com.github.taojintianxia.vault.springbootexample;

/**
 * @author Nianjun Sun
 * @date 2019/10/12 11:03
 */
import com.github.taojintianxia.vault.springbootexample.config.MyConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MyConfiguration.class)
public class Application implements CommandLineRunner {

    private final MyConfiguration configuration;

    public Application(MyConfiguration configuration) {
        this.configuration = configuration;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        Logger logger = LoggerFactory.getLogger(Application.class);

        logger.info("----------------------------------------");
        logger.info("Configuration properties");
        logger.info("        example.username is {}", configuration.getUsername());
        logger.info("        example.password is {}", configuration.getPassword());
        logger.info("----------------------------------------");
    }
}