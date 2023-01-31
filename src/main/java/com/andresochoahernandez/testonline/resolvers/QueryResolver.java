package com.andresochoahernandez.testonline.resolvers;

import com.andresochoahernandez.testonline.resolvers.types.*;
import com.andresochoahernandez.testonline.service.CompilazioneService;
import com.andresochoahernandez.testonline.service.DomandaService;
import com.andresochoahernandez.testonline.service.RispostaService;
import com.andresochoahernandez.testonline.service.TestService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class QueryResolver {

    private final TestService testService;
    private final DomandaService domandaService;
    private final RispostaService rispostaService;
    private final CompilazioneService compilazioneService;

    public QueryResolver(TestService testService, DomandaService domandaService, RispostaService rispostaService, CompilazioneService compilazioneService)
    {
        this.testService = testService;
        this.domandaService = domandaService;
        this.rispostaService = rispostaService;
        this.compilazioneService = compilazioneService;
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @QueryMapping
    public List<TestType> allTest() {return testService.GQLTypeGetAllTests();}

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @QueryMapping
    public TestType testByDateHourAndName(@Argument String data, @Argument String hour, @Argument String nome)
    {
        return testService.GQLTypeGetTestByDateHourAndName(data,hour,nome);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @QueryMapping
    public List<TestType> testByDateAndName(@Argument String data, @Argument String nome)
    {
        return testService.GQLTypeGetTestsByDateAndName(data,nome);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @QueryMapping
    public List<TestType> testByDate(@Argument String data)
    {
        return testService.GQLTypeGetTestsByDate(data);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @QueryMapping
    public List<TestType> testByName(@Argument String nome)
    {
        return testService.GQLTypeGetTestsByName(nome);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @QueryMapping
    public DomandaType domandaByNome(@Argument String nome)
    {
        return domandaService.GQLTypeGetDomandaByNome(nome);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @QueryMapping
    public List<DomandaType> allDomandaByTest(@Argument String data, @Argument String hour, @Argument String nome)
    {
        return domandaService.GQLTypeGetAllDomandaByTest(data,hour,nome);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @QueryMapping
    public List<RispostaType> allRispostaOfDomanda(@Argument String domanda,Authentication auth)
    {
        boolean canSeeAnswerPoints = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("SCOPE_DOCENTE"));
        return rispostaService.GQLTypeGetAllRispostaOfDomanda(domanda,canSeeAnswerPoints);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @QueryMapping
    public List<CompilazioneType> allCompilazioniByUserOfExam(@Argument Integer idUtente,@Argument String dataTest,@Argument String oraTest,@Argument String nomeTest)
    {
        return compilazioneService.getAllCompilazioniOfUserOfExam(idUtente,dataTest,oraTest,nomeTest);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @QueryMapping
    public List<TestWithCompilationFlagType> examListWithPreviousCompilationFlag(@Argument Integer idUtente){
        List<TestType> allTests = testService.GQLTypeGetAllTests();
        List<TestWithCompilationFlagType> result = new LinkedList<>();
        for (TestType currTest : allTests){
            List<CompilazioneType> allCompilationsOfUserOfEmxam = compilazioneService.getAllCompilazioniOfUserOfExam(idUtente, currTest.getData(), currTest.getOra(), currTest.getNome());
            result.add(new TestWithCompilationFlagType(currTest.getData(), currTest.getOra(), currTest.getNome(), !allCompilationsOfUserOfEmxam.isEmpty()));
        }
        return result;
    }
}