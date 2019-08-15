package com.company.U1M4SummativeSolution.controller;

import com.company.U1M4SummativeSolution.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
public class MagicController {

    private String[] answers = {
            "It is certain.",
            "It is decidedly so.",
            "Reply hazy, try again.",
            "Ask again later.",
            "Don't count on it.",
            "Outlook not so good."
    };

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Answer getAnswer(@RequestBody @Valid Answer question) {

        Random rand = new Random();


        question.setId(rand.nextInt(1000));
        question.setAnswer( answers[rand.nextInt(6)]);


        return question;
    }
}
