package com.example.sodproject.Component;

import com.example.sodproject.Service.StackOverflowDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class StackOverflowDataTask {
    private static final long FETCH_INTERVAL_MS = 86400000;

    @Autowired
    private StackOverflowDataService stackOverflowDataService;

    @Scheduled(fixedDelay = FETCH_INTERVAL_MS)
    public void fetchQuestionsTask() throws IOException {
        stackOverflowDataService.fetchAndStoreQuestions();

    }
}
