package com.andresochoahernandez.testonline.resolvers;

import com.andresochoahernandez.testonline.model.domain.Domanda;
import com.andresochoahernandez.testonline.model.domain.Risposta;
import com.andresochoahernandez.testonline.model.domain.Test;
import com.andresochoahernandez.testonline.model.domain.TestPK;
import com.andresochoahernandez.testonline.repository.DomandaRepository;
import com.andresochoahernandez.testonline.repository.InTestRepository;
import com.andresochoahernandez.testonline.repository.RispostaRespository;
import com.andresochoahernandez.testonline.repository.TestRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.andresochoahernandez.testonline.resolvers.types.*;

@Controller
public class QueryResolver {

    //TODO: handle not found elements in a better way

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

    @PreAuthorize("hasRole('DOCENTE')")
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

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
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

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
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

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
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

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
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

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
    @QueryMapping
    public DomandaType domandaByNome(@Argument String nome)
    {
        Optional<Domanda> result = domanda.findById(nome);
        return result.isEmpty()?null : new DomandaType(result.get());
    }

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
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

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
    @QueryMapping
    public List<RispostaType> allRispostaOfDomanda(@Argument String domanda,Authentication auth)
    {
        boolean canSeeAnswerPoints = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_DOCENTE"));

        List<Risposta> risposte = risposta.getRisposteOfDomanda(domanda);
        List<RispostaType> response = new LinkedList<>();

        for(Risposta curr : risposte)
        {
            RispostaType currType = new RispostaType(curr);
            if(!canSeeAnswerPoints) currType.restrict();
            response.add(currType);
        }

        return response;
    }
}
