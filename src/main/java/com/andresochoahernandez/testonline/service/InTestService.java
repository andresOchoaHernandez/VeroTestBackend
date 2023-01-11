package com.andresochoahernandez.testonline.service;

import com.andresochoahernandez.testonline.model.domain.Domanda;
import com.andresochoahernandez.testonline.model.domain.Test;
import com.andresochoahernandez.testonline.model.domain.TestPK;
import com.andresochoahernandez.testonline.repository.domain.DomandaRepository;
import com.andresochoahernandez.testonline.repository.domain.InTestRepository;
import com.andresochoahernandez.testonline.repository.domain.TestRepository;
import com.andresochoahernandez.testonline.resolvers.inputs.InTestInput;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class InTestService {

    private final InTestRepository intest;
    private final TestRepository test;
    private final DomandaRepository domanda;

    public InTestService(InTestRepository intest,TestRepository test,DomandaRepository domanda)
    {
        this.intest = intest;
        this.test = test;
        this.domanda = domanda;
    }

    public boolean connectDomandaToTest(InTestInput input){
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
