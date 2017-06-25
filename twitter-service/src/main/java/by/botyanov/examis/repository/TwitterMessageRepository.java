package by.botyanov.examis.repository;

import by.botyanov.examis.entity.TwitterMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.stream.Stream;

public interface TwitterMessageRepository extends ElasticsearchRepository<TwitterMessage, String> {

    Stream<TwitterMessage> findByTextContaining(String text);

}
