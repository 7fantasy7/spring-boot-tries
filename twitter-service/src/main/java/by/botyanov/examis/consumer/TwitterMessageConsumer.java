package by.botyanov.examis.consumer;

import by.botyanov.examis.entity.TwitterMessage;
import by.botyanov.examis.repository.TwitterMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class TwitterMessageConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterMessageConsumer.class);

    private final TwitterMessageRepository twitterMessageRepository;

    @Autowired
    public TwitterMessageConsumer(TwitterMessageRepository twitterMessageRepository) {
        this.twitterMessageRepository = twitterMessageRepository;
    }

    @ServiceActivator(inputChannel = "transformedTweets")
    public void consume(Message<TwitterMessage> message) {
        TwitterMessage tweet = message.getPayload();
        twitterMessageRepository.save(tweet);
        LOG.info("Fetched Tweet Text from @" + tweet.getFromUser() + " # " + tweet.getText());
    }

}
