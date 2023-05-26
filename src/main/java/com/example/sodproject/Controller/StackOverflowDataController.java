package com.example.sodproject.Controller;

import com.example.sodproject.Service.StackOverflowDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stackoverflow")
public class StackOverflowDataController {
    @Autowired
    private StackOverflowDataService stackOverflowService;

    @GetMapping("/update")
    public String updateData() throws IOException, ParseException, InterruptedException {
        stackOverflowService.fetchAndStoreQuestions();
        return "Data updated successfully!";
    }
    @GetMapping("/noAnswerPercentage")
    public double getQuestions() throws JsonProcessingException {
        return stackOverflowService.noAnswerPercentage();
    }

    @GetMapping("/averageAnswerCount")
    public double getQuestionsGreaterThan() throws JsonProcessingException {
        return stackOverflowService.averageAnswerCount();
    }

    @GetMapping("/maxAnswerCount")
    public long getMaxAnswerCount() throws JsonProcessingException {
        return stackOverflowService.maxAnswerCount();
    }

    @GetMapping("/answerCountDistribution")
    public String getAnswerCountDistribution() throws JsonProcessingException {
        return stackOverflowService.answerCountDistribution().toString();
    }

    @GetMapping("/questionHaveAcceptedAnswerPercentage")
    public double getQuestionHaveAcceptedAnswerPercentage() throws JsonProcessingException {
        return stackOverflowService.questionHaveAcceptedAnswerPercentage();
    }

    @GetMapping("/acceptedAnswerTimeDistribution")
    public String getAcceptedAnswerTimeDistribution() throws JsonProcessingException {
        return stackOverflowService.acceptedAnswerTimeDistribution().toString();
    }

    @GetMapping("/nonAcceptedAnswerUpvotePercentage")
    public double getNonAcceptedAnswerUpvotePercentage() throws JsonProcessingException {
        return stackOverflowService.nonAcceptedAnswerUpvotePercentage();
    }

    @GetMapping("/frequentlyAppearTogetherWithJavaTag")
    public String getFrequentlyAppearTogetherWithJavaTag() throws JsonProcessingException {
        return stackOverflowService.frequentlyAppearTogetherWithJavaTag().toString();
    }

    @GetMapping("/mostUpvoteTags")
    public String getMostUpvoteTags() throws JsonProcessingException {
        return stackOverflowService.mostUpvoteTags().toString();
    }

    @GetMapping("/mostViewTags")
    public String getMostViewTags() throws JsonProcessingException {
        return stackOverflowService.mostViewTags().toString();
    }

    @GetMapping("/userAnswerDistribution")
    public String getUserAnswerDistribution() throws JsonProcessingException {
        return stackOverflowService.userAnswerDistribution().toString();
    }

    @GetMapping("/userCommentDistribution")
    public String getUserCommentDistribution() throws JsonProcessingException {
        return stackOverflowService.userCommentDistribution().toString();
    }

    @GetMapping("/userParticipateDistribution")
    public String getUserParticipateDistribution() throws JsonProcessingException {
        return stackOverflowService.userParticipateDistribution().toString();
    }

    @GetMapping("/mostActiveUsers")
    public String getMostActiveUsers() throws JsonProcessingException {
        return stackOverflowService.mostActiveUsers().toString();
    }

}
