package com.example.sodproject.Service;

import com.example.sodproject.Model.Question;
import com.example.sodproject.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Service
public class StackOverflowDataService {
    private static final String STACK_OVERFLOW_API_BASE_URL = "https://api.stackexchange.com/2.3";

    @Autowired
    private QuestionRepository questionRepository;

    public void fetchAndStoreQuestions() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = STACK_OVERFLOW_API_BASE_URL + "/questions?order=desc&sort=activity&tagged=java&site=stackoverflow";
        StackOverflowResponse response = restTemplate.getForObject(apiUrl, StackOverflowResponse.class);
        if (response != null && response.getItems() != null) {
            for (StackOverflowQuestion question : response.getItems()) {
                Question newQuestion = new Question();
                newQuestion.setTitle(question.getTitle());
                newQuestion.setBody(question.getBody());
                questionRepository.save(newQuestion);
            }
        }
    }
}
