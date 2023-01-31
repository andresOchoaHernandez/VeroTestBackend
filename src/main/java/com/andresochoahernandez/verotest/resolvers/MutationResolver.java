package com.andresochoahernandez.verotest.resolvers;

import com.andresochoahernandez.verotest.resolvers.inputs.*;
import com.andresochoahernandez.verotest.resolvers.types.ResultType;
import com.andresochoahernandez.verotest.service.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MutationResolver {

    private final TestService testService;
    private final DomandaService domandaService;
    private final RispostaService rispostaService;
    private final InTestService intestService;
    private final CompilazioneService compilazioneService;

    public MutationResolver(TestService testService, DomandaService domandaService, RispostaService rispostaService, InTestService intestService, CompilazioneService compilazioneService) {
        this.testService = testService;
        this.domandaService = domandaService;
        this.rispostaService = rispostaService;
        this.intestService = intestService;
        this.compilazioneService = compilazioneService;
    }

    @PreAuthorize("hasAuthority('SCOPE_DOCENTE')")
    @MutationMapping
    public boolean createTest(@Argument TestInput input){
        return testService.createTest(input);
    }

    @PreAuthorize("hasAuthority('SCOPE_DOCENTE')")
    @MutationMapping
    public boolean createDomanda(@Argument DomandaInput input){
        return domandaService.createDomanda(input);
    }

    @PreAuthorize("hasAuthority('SCOPE_DOCENTE')")
    @MutationMapping
    public boolean createRisposta(@Argument RispostaInput input){
        return rispostaService.createRisposta(input);
    }

    @PreAuthorize("hasAuthority('SCOPE_DOCENTE')")
    @MutationMapping
    public boolean connectDomandaToTest(@Argument InTestInput input){
        return intestService.connectDomandaToTest(input);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @MutationMapping
    public boolean insertCompilazione(@Argument CompilazioneInput input){
        return compilazioneService.insertCompilazione(input);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_DOCENTE','SCOPE_STUDENTE')")
    @MutationMapping
    public List<ResultType> completeTest(@Argument CompilazioneInput input){
       return compilazioneService.completeTest(input);
    }
}