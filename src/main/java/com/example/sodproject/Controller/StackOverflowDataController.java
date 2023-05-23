package com.example.sodproject.Controller;

import com.example.sodproject.Service.StackOverflowDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
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
    public String updateData() throws IOException {
        stackOverflowService.fetchAndStoreQuestions();
        return "Data updated successfully!";
    }
}
