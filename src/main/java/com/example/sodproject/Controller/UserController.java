package com.example.sodproject.Controller;

import com.example.sodproject.Service.StackOverflowDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stackoverflow/user")
public class UserController {
    @Autowired
    private StackOverflowDataService stackOverflowService;

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
