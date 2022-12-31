package com.andresochoahernandez.testonline.controller;

import com.andresochoahernandez.testonline.model.*;
import com.andresochoahernandez.testonline.repository.DomandaRepository;
import com.andresochoahernandez.testonline.repository.InTestRepository;
import com.andresochoahernandez.testonline.repository.RispostaRespository;
import com.andresochoahernandez.testonline.repository.TestRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
    public List<TestSchema> allTest()
    {
        List<Test> allTests = test.findAll();
        List<TestSchema> response = new LinkedList<>();

        for(Test curr : allTests)
        {
            response.add(new TestSchema(curr));
        }

        return response;
    }

    @QueryMapping
    public TestSchema testByDateAndName(@Argument String data,@Argument String nome)
    {
        //TODO : Handle the correctness of the input, handle the fact that an exam
        //       can occur in the same day at different hours (example turn 1, turn 2 etc...)
        Optional<Test> result = test.findById(new TestPK(Timestamp.valueOf(data),nome));
        return result.isEmpty()?null:new TestSchema(result.get());
    }

    @QueryMapping
    public List<TestSchema> testByDate(@Argument String data)
    {
        List<Test> tests = test.getTestByDate(data);

        List<TestSchema> response = new LinkedList<>();

        for(Test curr : tests)
        {
            response.add(new TestSchema(curr));
        }

        return response;
    }

    @QueryMapping
    public List<TestSchema> testByName(@Argument String nome)
    {
        List<Test> tests = test.getTestByName(nome);

        List<TestSchema> response = new LinkedList<>();

        for(Test curr : tests)
        {
            response.add(new TestSchema(curr));
        }

        return response;
    }

    @QueryMapping
    public List<DomandaSchema> allDomanda()
    {
        List<Domanda> allDomande = domanda.findAll();
        List<DomandaSchema> response = new LinkedList<>();

        for(Domanda curr : allDomande)
        {
            response.add(new DomandaSchema(curr));
        }

        return response;
    }

    @QueryMapping
    public DomandaSchema domandaByNome(@Argument String nome)
    {
        Optional<Domanda> result = domanda.findById(nome);

        return result.isEmpty()?null : new DomandaSchema(result.get());
    }

    @QueryMapping
    public List<DomandaSchema> allDomandaByTest(@Argument String data, @Argument String hour, @Argument String nome)
    {
        //TODO:
        return null;
    }

    @QueryMapping
    public List<RispostaSchema> allRisposta()
    {
        List<Risposta> allRisposte = risposta.findAll();
        List<RispostaSchema> response = new LinkedList<>();

        for(Risposta curr : allRisposte)
        {
            response.add(new RispostaSchema(curr));
        }

        return response;
    }

    @QueryMapping
    public List<RispostaSchema> allRispostaOfDomanda(@Argument String domanda)
    {
        List<Risposta> risposte = risposta.getRisposteOfDomanda(domanda);

        List<RispostaSchema> response = new LinkedList<>();

        for(Risposta curr : risposte)
        {
            response.add(new RispostaSchema(curr));
        }

        return response;
    }

    @QueryMapping
    public List<InTestSchema> allInTest()
    {
        List<InTest> allInTests = intest.findAll();
        List<InTestSchema> response = new LinkedList<>();

        for(InTest curr : allInTests)
        {
            response.add(new InTestSchema(curr));
        }

        return response;
    }


    private class TestSchema
    {
        private String data;
        private String nome;
        private boolean ordineCasuale;
        private boolean domandeConNumero;

        public TestSchema(Test test)
        {
            this.data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(test.getData());
            this.nome = test.getNome();
            this.ordineCasuale = test.isOrdineCasuale();
            this.domandeConNumero = test.isDomandeConNumero();
        }
    }

    private class DomandaSchema
    {
        private String nome;
        private String testo;
        private Float punti;
        private boolean ordineCasuale;
        private boolean risposteConNumero;

        public DomandaSchema(Domanda domanda)
        {
            this.nome = domanda.getNome();
            this.testo = domanda.getTesto();
            this.punti = domanda.getPunti().floatValue();
            this.ordineCasuale = domanda.isOrdineCasuale();
            this.risposteConNumero = domanda.isRisposteConNumero();
        }
    }

    private class RispostaSchema
    {
        private int id;
        private String testo;
        private Float punteggio;
        private String domanda;

        public RispostaSchema(Risposta risposta)
        {
            this.id = risposta.getId();
            this.testo = risposta.getTesto();
            this.punteggio = risposta.getPunteggio().floatValue();
            this.domanda = risposta.getDomanda().getNome();
        }
    }

    private class InTestSchema
    {
        private int id;
        private String domanda;
        private String dataTest;
        private String nomeTest;
        public InTestSchema(InTest inTest)
        {
            this.id = inTest.getId();
            this.domanda = inTest.getDomanda().getNome();
            this.dataTest = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(inTest.getTest().getData());
            this.nomeTest = inTest.getTest().getNome();
        }
    }
}
