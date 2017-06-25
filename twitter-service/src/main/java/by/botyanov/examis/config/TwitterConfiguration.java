package by.botyanov.examis.config;

import by.botyanov.examis.entity.TwitterMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.twitter.inbound.SearchReceivingMessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class TwitterConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public TwitterTemplate twitterTemplate() {
        return new TwitterTemplate(environment.getProperty("twitter.oauth.consumerKey"),
                environment.getProperty("twitter.oauth.consumerSecret"),
                environment.getProperty("twitter.oauth.accessToken"),
                environment.getProperty("twitter.oauth.accessTokenSecret"));
    }

    @Bean
    public MessageChannel twitterInbound() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel transformedTweets() {
        return new DirectChannel();
    }

    @Bean
    @InboundChannelAdapter(value = "twitterInbound", poller = @Poller(fixedRate = "60000", maxMessagesPerPoll = "10"))
    public SearchReceivingMessageSource inboundChannelAdapter() throws Exception {
        SearchReceivingMessageSource source = new SearchReceivingMessageSource(twitterTemplate(), "twitter");
        source.setQuery("#егэ");
        return source;
    }

    @Bean
    @Transformer(inputChannel = "twitterInbound", outputChannel = "transformedTweets")
    public org.springframework.integration.transformer.Transformer convertToCustomMessage() {
        return message -> new Message<TwitterMessage>() {
            @Override
            public TwitterMessage getPayload() {
                return new TwitterMessage((Tweet) message.getPayload());
            }

            @Override
            public MessageHeaders getHeaders() {
                return message.getHeaders();
            }
        };
    }

}
