package by.botyanov.examis.web;

import by.botyanov.examis.entity.Question;
import by.botyanov.examis.entity.View;
import by.botyanov.examis.repository.QuestionRepository;
import by.botyanov.examis.util.JsonPage;
import by.botyanov.examis.util.RandomIdsSelector;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/")
    @ResponseBody
    @Transactional(readOnly = true)
    @JsonView(View.Summary.class)
    public Page<Question> getAllPaged(@RequestParam int page, @RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        return new JsonPage<>(questionRepository.findAll(pageRequest), pageRequest);
    }

    @GetMapping("/{questionId}")
    @ResponseBody
    @Transactional(readOnly = true)
    @JsonView(View.Summary.class)
    public Optional<Question> getQuestion(@PathVariable Long questionId) {
        return questionRepository.findById(questionId);
    }

    @GetMapping("/putSome")
    @ResponseBody
    @Transactional
    @JsonView(View.Summary.class)
    public Question addSome() {
        return questionRepository.save(new Question().setText("some3").setDescription("some4"));
    }

    @GetMapping("/randomQuestions")
    @ResponseBody
    @Transactional(readOnly = true)
    @JsonView(View.Summary.class)
    public Iterable<Question> randomQuestions() {
        return questionRepository.findAllById(RandomIdsSelector.randomIds(questionRepository.count(), 4));
    }

}
