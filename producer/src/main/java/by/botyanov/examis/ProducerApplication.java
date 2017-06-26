package by.botyanov.examis;

import by.botyanov.examis.sender.QuestionProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        QuestionProducer bean = appContext.getBean(QuestionProducer.class);
        for (int i = 0; i < 10; i++) {
            bean.send("test", "hello world" + i);
        }
        Thread.currentThread().join();
    }

}
