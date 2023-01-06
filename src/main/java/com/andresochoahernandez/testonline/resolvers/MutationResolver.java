package com.andresochoahernandez.testonline.resolvers;

import com.andresochoahernandez.testonline.model.Domanda;
import com.andresochoahernandez.testonline.model.Test;
import com.andresochoahernandez.testonline.model.TestPK;
import com.andresochoahernandez.testonline.repository.DomandaRepository;
import com.andresochoahernandez.testonline.repository.InTestRepository;
import com.andresochoahernandez.testonline.repository.RispostaRespository;
import com.andresochoahernandez.testonline.repository.TestRepository;
import com.andresochoahernandez.testonline.resolvers.inputs.DomandaInput;
import com.andresochoahernandez.testonline.resolvers.inputs.InTestInput;
import com.andresochoahernandez.testonline.resolvers.inputs.RispostaInput;
import com.andresochoahernandez.testonline.resolvers.inputs.TestInput;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.Optional;

@Controller
public class MutationResolver {

    //TODO: handle not found elements in a better way

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

    @PreAuthorize("hasRole('DOCENTE')")
    @MutationMapping
    public boolean createTest(@Argument TestInput input){
        try{
            Timestamp.valueOf(input.getData() + " " + input.getOra() + ":00");
            test.save(input.toJpaEntity());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @PreAuthorize("hasRole('DOCENTE')")
    @MutationMapping
    public boolean createDomanda(@Argument DomandaInput input){
        try{
            domanda.save(input.toJpaEntity());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @PreAuthorize("hasRole('DOCENTE')")
    @MutationMapping
    public boolean createRisposta(@Argument RispostaInput input){
        try{
            Optional<Domanda> domandaOfRispostaInput = domanda.findById(input.getDomanda());
            if(domandaOfRispostaInput.isEmpty()) return false;
            risposta.save(input.toJpaEntity(domandaOfRispostaInput.get()));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @PreAuthorize("hasRole('DOCENTE')")
    @MutationMapping
    public boolean connectDomandaToTest(@Argument InTestInput input){
        try{
            Optional<Domanda> domandaEntry = domanda.findById(input.getDomanda());
            Optional<Test> testEntry = test.findById(new TestPK(Timestamp.valueOf(input.getDataTest()+" " +input.getOraTest() +  ":00"), input.getNomeTest()));
            if(testEntry.isEmpty() || domandaEntry.isEmpty()) return false;
            intest.save(input.toJpaEntity(domandaEntry.get(), testEntry.get()));
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
