package com.andresochoahernandez.testonline.resolvers;

import com.andresochoahernandez.testonline.resolvers.inputs.DomandaInput;
import com.andresochoahernandez.testonline.resolvers.inputs.InTestInput;
import com.andresochoahernandez.testonline.resolvers.inputs.RispostaInput;
import com.andresochoahernandez.testonline.resolvers.inputs.TestInput;
import com.andresochoahernandez.testonline.service.DomandaService;
import com.andresochoahernandez.testonline.service.InTestService;
import com.andresochoahernandez.testonline.service.RispostaService;
import com.andresochoahernandez.testonline.service.TestService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {

    private final TestService testService;
    private final DomandaService domandaService;
    private final RispostaService rispostaService;
    private final InTestService intestService;

    public MutationResolver(TestService testService, DomandaService domandaService, RispostaService rispostaService, InTestService intestService) {
        this.testService = testService;
        this.domandaService = domandaService;
        this.rispostaService = rispostaService;
        this.intestService = intestService;
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

}