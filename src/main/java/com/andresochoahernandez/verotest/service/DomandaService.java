package com.andresochoahernandez.verotest.service;

import com.andresochoahernandez.verotest.model.domain.Domanda;
import com.andresochoahernandez.verotest.repository.domain.DomandaRepository;
import com.andresochoahernandez.verotest.resolvers.inputs.DomandaInput;
import com.andresochoahernandez.verotest.resolvers.types.DomandaType;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DomandaService {

    private final DomandaRepository domanda;

    public DomandaService(DomandaRepository domanda)
    {
        this.domanda = domanda;
    }

    public DomandaType GQLTypeGetDomandaByNome(String nome)
    {
        Optional<Domanda> result = domanda.findById(nome);
        return result.isEmpty()?null : new DomandaType(result.get());
    }

    public List<DomandaType> GQLTypeGetAllDomandaByTest(String data, String hour, String nome)
    {
        List<Domanda> domandeOfTest = domanda.getDomandeOfTest(data + " " + hour + ":00",nome);
        List<DomandaType> response = new LinkedList<>();
        for(Domanda curr : domandeOfTest)
        {
            response.add(new DomandaType(curr));
        }
        return response;
    }

    public boolean createDomanda(DomandaInput input){
        try{
            domanda.save(input.toJpaEntity());
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
