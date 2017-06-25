package by.botyanov.examis;

import by.botyanov.examis.config.TwitterConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.social.TwitterAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication(exclude = TwitterAutoConfiguration.class)
@Import(value = TwitterConfiguration.class)
//@ImportResource("/twitter-integration.xml")
@IntegrationComponentScan
@EnableIntegration
public class TwitterApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(TwitterApplication.class, args);
        Thread.currentThread().join();
    }

}
