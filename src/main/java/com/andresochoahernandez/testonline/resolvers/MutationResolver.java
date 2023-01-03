package com.andresochoahernandez.testonline.resolvers;

import com.andresochoahernandez.testonline.repository.DomandaRepository;
import com.andresochoahernandez.testonline.repository.InTestRepository;
import com.andresochoahernandez.testonline.repository.RispostaRespository;
import com.andresochoahernandez.testonline.repository.TestRepository;
import com.andresochoahernandez.testonline.resolvers.inputs.DomandaInput;
import com.andresochoahernandez.testonline.resolvers.inputs.InTestInput;
import com.andresochoahernandez.testonline.resolvers.inputs.RispostaInput;
import com.andresochoahernandez.testonline.resolvers.inputs.TestInput;
import com.andresochoahernandez.testonline.resolvers.types.DomandaType;
import com.andresochoahernandez.testonline.resolvers.types.InTestType;
import com.andresochoahernandez.testonline.resolvers.types.RispostaType;
import com.andresochoahernandez.testonline.resolvers.types.TestType;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {

    private final TestRepository test;
    private final RispostaRespository risposta;
    private final InTestRepository intest;
    private final DomandaRepository domanda;

    public MutationResolver(TestRepository test, RispostaRespository risposta, InTestRepository intest, DomandaRepository domanda)
    {
        this.test = test;
        this.risposta = risposta;
        this.intest = intest;
        this.domanda = domanda;
    }

    @MutationMapping
    public TestType createTest(@Argument TestInput input){
        //TODO
        return null;
    }

    @MutationMapping
    public DomandaType createDomanda(@Argument DomandaInput input){
        //TODO
        return null;
    }

    @MutationMapping
    public RispostaType createRisposta(@Argument RispostaInput input){
        //TODO
        return null;
    }

    @MutationMapping
    public InTestType connectDomandaToTest(@Argument InTestInput input){
        //TODO
        return null;
    }

}
