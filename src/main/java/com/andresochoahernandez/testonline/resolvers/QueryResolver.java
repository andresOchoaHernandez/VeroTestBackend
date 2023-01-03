package com.andresochoahernandez.testonline.resolvers;

import com.andresochoahernandez.testonline.model.*;
import com.andresochoahernandez.testonline.repository.DomandaRepository;
import com.andresochoahernandez.testonline.repository.InTestRepository;
import com.andresochoahernandez.testonline.repository.RispostaRespository;
import com.andresochoahernandez.testonline.repository.TestRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.andresochoahernandez.testonline.resolvers.types.*;

@Controller
public class QueryResolver {

    private final TestRepository test;
    private final RispostaRespository risposta;
    private final InTestRepository intest;
    private final DomandaRepository domanda;

    public QueryResolver(TestRepository test, RispostaRespository risposta, InTestRepository intest, DomandaRepository domanda)
    {
        this.test = test;
        this.risposta = risposta;
        this.intest = intest;
        this.domanda = domanda;
    }

    /* =================== TEST QUERIES IMPLEMENTATION =================== */

    @QueryMapping
    public List<TestType> allTest()
    {
        List<Test> allTests = test.findAll();
        List<TestType> response = new LinkedList<>();

        for(Test curr : allTests)
        {
            response.add(new TestType(curr));
        }

        return response;
    }

    @QueryMapping
    public TestType testByDateHourAndName(@Argument String data, @Argument String hour, @Argument String nome)
    {
        try
        {
            Timestamp timestamp = Timestamp.valueOf(data + " " + hour + ":00");
            Optional<Test> result = test.findById(new TestPK(timestamp,nome));
            return result.isEmpty()?null:new TestType(result.get());
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @QueryMapping
    public List<TestType> testByDateAndName(@Argument String data, @Argument String nome)
    {
        List<Test> tests = test.getTestByDateAndName(data,nome);

        List<TestType> response = new LinkedList<>();

        for(Test curr : tests)
        {
            response.add(new TestType(curr));
        }

        return response;
    }

    @QueryMapping
    public List<TestType> testByDate(@Argument String data)
    {
        List<Test> tests = test.getTestByDate(data);

        List<TestType> response = new LinkedList<>();

        for(Test curr : tests)
        {
            response.add(new TestType(curr));
        }

        return response;
    }

    @QueryMapping
    public List<TestType> testByName(@Argument String nome)
    {
        List<Test> tests = test.getTestByName(nome);

        List<TestType> response = new LinkedList<>();

        for(Test curr : tests)
        {
            response.add(new TestType(curr));
        }

        return response;
    }

    /* =================== DOMANDE QUERIES IMPLEMENTATION =================== */

    @QueryMapping
    public List<DomandaType> allDomanda()
    {
        List<Domanda> allDomande = domanda.findAll();
        List<DomandaType> response = new LinkedList<>();

        for(Domanda curr : allDomande)
        {
            response.add(new DomandaType(curr));
        }

        return response;
    }

    @QueryMapping
    public DomandaType domandaByNome(@Argument String nome)
    {
        Optional<Domanda> result = domanda.findById(nome);

        return result.isEmpty()?null : new DomandaType(result.get());
    }

    @QueryMapping
    public List<DomandaType> allDomandaByTest(@Argument String data, @Argument String hour, @Argument String nome)
    {
        List<Domanda> domandeOfTest = domanda.getDomandeOfTest(data + " " + hour + ":00",nome);
        List<DomandaType> response = new LinkedList<>();

        for(Domanda curr : domandeOfTest)
        {
            response.add(new DomandaType(curr));
        }

        return response;
    }

    /* =================== RISPOSTE QUERIES IMPLEMENTATION =================== */

    @QueryMapping
    public List<RispostaType> allRisposta()
    {
        List<Risposta> allRisposte = risposta.findAll();
        List<RispostaType> response = new LinkedList<>();

        for(Risposta curr : allRisposte)
        {
            response.add(new RispostaType(curr));
        }

        return response;
    }

    @QueryMapping
    public List<RispostaType> allRispostaOfDomanda(@Argument String domanda)
    {
        List<Risposta> risposte = risposta.getRisposteOfDomanda(domanda);

        List<RispostaType> response = new LinkedList<>();

        for(Risposta curr : risposte)
        {
            response.add(new RispostaType(curr));
        }

        return response;
    }

    /* =================== INTEST QUERIES IMPLEMENTATION =================== */
    @QueryMapping
    public List<InTestType> allInTest()
    {
        List<InTest> allInTests = intest.findAll();
        List<InTestType> response = new LinkedList<>();

        for(InTest curr : allInTests)
        {
            response.add(new InTestType(curr));
        }

        return response;
    }
}
