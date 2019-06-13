package com.example.U1M4SummativeAlizadaHabib.model;

import javax.validation.constraints.NotEmpty;

public class Answer {

    @NotEmpty(message = "Your must supply with question")
    private String question;
    @NotEmpty(message = "Your must supply with an answer")
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
