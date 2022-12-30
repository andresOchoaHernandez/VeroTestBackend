package com.andresochoahernandez.testonline.controller;

import com.andresochoahernandez.testonline.model.Test;
import com.andresochoahernandez.testonline.repository.DomandaRepository;
import com.andresochoahernandez.testonline.repository.InTestRepository;
import com.andresochoahernandez.testonline.repository.RispostaRespository;
import com.andresochoahernandez.testonline.repository.TestRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class TestOnlineController {

    private final TestRepository test;
    private final RispostaRespository risposta;
    private final InTestRepository intest;
    private final DomandaRepository domanda;

    public TestOnlineController(TestRepository test, RispostaRespository risposta, InTestRepository intest, DomandaRepository domanda)
    {
        this.test = test;
        this.risposta = risposta;
        this.intest = intest;
        this.domanda = domanda;
    }

    @QueryMapping
    public List<Test> allTest()
    {
        return test.findAll();
    }
}
