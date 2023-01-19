package com.andresochoahernandez.testonline.service;

import com.andresochoahernandez.testonline.model.agents.Compilazione;
import com.andresochoahernandez.testonline.model.domain.Domanda;
import com.andresochoahernandez.testonline.model.domain.Risposta;
import com.andresochoahernandez.testonline.repository.agents.CompilazioneRepository;
import com.andresochoahernandez.testonline.repository.domain.DomandaRepository;
import com.andresochoahernandez.testonline.repository.domain.RispostaRespository;
import com.andresochoahernandez.testonline.resolvers.inputs.CompilazioneInput;
import com.andresochoahernandez.testonline.resolvers.types.CompilazioneType;
import com.andresochoahernandez.testonline.resolvers.types.ResultType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Service
public class CompilazioneService {
    private final CompilazioneRepository compilazioni;
    private final RispostaRespository risposte;
    private final DomandaRepository domande;
    public CompilazioneService(CompilazioneRepository compilazioni, RispostaRespository risposte, DomandaRepository domande) {
        this.compilazioni = compilazioni;
        this.risposte = risposte;
        this.domande = domande;
    }
    public List<CompilazioneType> getAllCompilazioniOfUserOfExam(int idUtente, String dataTest,String oraTest, String nomeTest){
        List<Compilazione> records = compilazioni.getAllCompilazioniOfUserOfExam(idUtente,Timestamp.valueOf(dataTest + " " + oraTest + ":00"),nomeTest);
        List<CompilazioneType> response = new LinkedList<>();
        for(Compilazione curr : records){ response.add(curr.toType());}
        return response;
    }

    public boolean insertCompilazione(CompilazioneInput input){
        try{
            compilazioni.save(input.toJpaEntity());
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<ResultType> completeTest(CompilazioneInput input){
        insertCompilazione(input);
        List<Compilazione> allCompilazioni = compilazioni.getAllCompilazioniOfUserOfExam(input.getIdUtente(),Timestamp.valueOf(input.getDataTest() + " " + input.getOraTest() + ":00"),input.getNomeTest());
        List<ResultType> response = new LinkedList<>();
        for(Compilazione curr : allCompilazioni)
        {
            Risposta rD = risposte.findById(curr.getIdRisposta()).get();
            Domanda domanda = domande.findById(input.getNomeDomanda()).get();

            String rispostaData = rD.getTesto();
            Float puntiRispostaData = rD.getPunteggio().floatValue() * domanda.getPunti().floatValue();

            List<Risposta> rOD = risposte.getRisposteOfDomanda(curr.getNomeDomanda());

            Risposta rE = null;
            for(Risposta r : rOD)
            {
                if(r.getPunteggio().compareTo(BigDecimal.valueOf(1.0)) == 0){
                    rE = r;
                }
            }
            String rispostaEsatta = rE.getTesto();

            response.add(new ResultType(rispostaData,puntiRispostaData,rispostaEsatta));
        }
        compilazioni.deleteAllByUserAndExam(input.getIdUtente(),Timestamp.valueOf(input.getDataTest() + " " + input.getOraTest() + ":00"),input.getNomeTest());
        return response;
    }
}
