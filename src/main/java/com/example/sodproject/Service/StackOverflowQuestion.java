package com.example.sodproject.Service;
public class StackOverflowQuestion {
    private String title;
    private String body;

    // Constructor, Getters and setters

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public StackOverflowQuestion(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public StackOverflowQuestion() {
    }

    @Override
    public String toString() {
        return "StackOverflowQuestion{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }


}
