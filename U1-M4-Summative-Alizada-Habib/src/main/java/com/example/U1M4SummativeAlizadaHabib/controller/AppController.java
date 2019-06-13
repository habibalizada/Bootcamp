package com.example.U1M4SummativeAlizadaHabib.controller;

import com.example.U1M4SummativeAlizadaHabib.model.Answer;
import com.example.U1M4SummativeAlizadaHabib.model.Definition;
import com.example.U1M4SummativeAlizadaHabib.model.Quote;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class AppController {

    private List<Quote> quoteList = initiateQuotes();
    private List<Definition> definitionList = initiateDefinitions();
    private List<Answer> answerList = initiateAnswers();
    Random random = new Random();


    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getAQuote(){
        return quoteList.get(random.nextInt(quoteList.size()));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getADefinition(){
        return definitionList.get(random.nextInt(definitionList.size()));
    }


    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Answer getAnAnswer(@RequestBody Answer userQ) {
        Answer answer = new Answer();
        String randomAnswer = answerList.get(random.nextInt(answerList.size())).getAnswer();
        answer.setAnswer(randomAnswer);
        answer.setQuestion(userQ.getQuestion());
        return answer;
    }



    public List<Quote> initiateQuotes() {
        List<Quote> quotes = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();

            quotes = mapper.readValue(new File("quotes.json"), new TypeReference<List<Quote>>() {});

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
        return quotes;
    }

    public List<Definition> initiateDefinitions() {
        List<Definition> definitions = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();

            definitions = mapper.readValue(new File("definitions.json"), new TypeReference<List<Definition>>() {});

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
        return definitions;
    }

    public List<Answer> initiateAnswers() {
        List<Answer> answers = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();

            answers = mapper.readValue(new File("answers.json"), new TypeReference<List<Answer>>() {});

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
        return answers;
    }
}
