package com.andresochoahernandez.testonline.resolvers;

import com.andresochoahernandez.testonline.resolvers.types.DomandaType;
import com.andresochoahernandez.testonline.resolvers.types.RispostaType;
import com.andresochoahernandez.testonline.resolvers.types.TestType;
import com.andresochoahernandez.testonline.service.DomandaService;
import com.andresochoahernandez.testonline.service.RispostaService;
import com.andresochoahernandez.testonline.service.TestService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryResolver {

    private final TestService testService;
    private final DomandaService domandaService;
    private final RispostaService rispostaService;

    public QueryResolver(TestService testService,DomandaService domandaService,RispostaService rispostaService)
    {
        this.testService = testService;
        this.domandaService = domandaService;
        this.rispostaService = rispostaService;
    }

    @PreAuthorize("hasRole('DOCENTE')")
    @QueryMapping
    public List<TestType> allTest()
    {
        return testService.GQLTypeGetAllTests();
    }

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
    @QueryMapping
    public TestType testByDateHourAndName(@Argument String data, @Argument String hour, @Argument String nome)
    {
        return testService.GQLTypeGetTestByDateHourAndName(data,hour,nome);
    }

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
    @QueryMapping
    public List<TestType> testByDateAndName(@Argument String data, @Argument String nome)
    {
        return testService.GQLTypeGetTestsByDateAndName(data,nome);
    }

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
    @QueryMapping
    public List<TestType> testByDate(@Argument String data)
    {
        return testService.GQLTypeGetTestsByDate(data);
    }

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
    @QueryMapping
    public List<TestType> testByName(@Argument String nome)
    {
        return testService.GQLTypeGetTestsByName(nome);
    }

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
    @QueryMapping
    public DomandaType domandaByNome(@Argument String nome)
    {
        return domandaService.GQLTypeGetDomandaByNome(nome);
    }

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
    @QueryMapping
    public List<DomandaType> allDomandaByTest(@Argument String data, @Argument String hour, @Argument String nome)
    {
        return domandaService.GQLTypeGetAllDomandaByTest(data,hour,nome);
    }

    @PreAuthorize("hasAnyRole('DOCENTE','STUDENTE')")
    @QueryMapping
    public List<RispostaType> allRispostaOfDomanda(@Argument String domanda,Authentication auth)
    {
        boolean canSeeAnswerPoints = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_DOCENTE"));
        return rispostaService.GQLTypeGetAllRispostaOfDomanda(domanda,canSeeAnswerPoints);
    }
}