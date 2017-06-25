package by.botyanov.examis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.social.twitter.api.Tweet;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(indexName = "customer", type = "customer", shards = 1, replicas = 0, refreshInterval = "-1")
public class TwitterMessage {

    @Id
    private String id;
    private String text;
    private int retweetCount;
    private int favoriteCount;
    private long fromUserId;
    private String fromUser;
    private Date date;

    public TwitterMessage(Tweet tweet) {
        this.setId(tweet.getIdStr())
                .setFromUser(tweet.getFromUser())
                .setFromUserId(tweet.getFromUserId())
                .setText(tweet.getText())
                .setFavoriteCount(tweet.getFavoriteCount())
                .setRetweetCount(tweet.getRetweetCount())
                .setDate(tweet.getCreatedAt());
    }

}
