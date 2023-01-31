package com.andresochoahernandez.verotest.service;

import com.andresochoahernandez.verotest.model.domain.Domanda;
import com.andresochoahernandez.verotest.model.domain.Risposta;
import com.andresochoahernandez.verotest.repository.domain.DomandaRepository;
import com.andresochoahernandez.verotest.repository.domain.RispostaRespository;
import com.andresochoahernandez.verotest.resolvers.inputs.RispostaInput;
import com.andresochoahernandez.verotest.resolvers.types.RispostaType;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RispostaService {
    private final RispostaRespository risposta;
    private final DomandaRepository domanda;

    public RispostaService(RispostaRespository risposta,DomandaRepository domanda)
    {
        this.risposta = risposta;
        this.domanda = domanda;
    }

    public List<RispostaType> GQLTypeGetAllRispostaOfDomanda(String domanda, boolean canSeeAnswerPoints)
    {
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

    public boolean createRisposta(RispostaInput input){
        try{
            Optional<Domanda> domandaOfRispostaInput = domanda.findById(input.getDomanda());
            if(domandaOfRispostaInput.isEmpty()) return false;
            risposta.save(input.toJpaEntity(domandaOfRispostaInput.get()));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
