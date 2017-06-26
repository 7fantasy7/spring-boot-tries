package by.botyanov.examis.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class QuestionConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionConsumer.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.questions}")
    public void consume(String message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }
}