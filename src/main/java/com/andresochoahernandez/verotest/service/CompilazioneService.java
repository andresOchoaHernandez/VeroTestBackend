package com.andresochoahernandez.verotest.service;

import com.andresochoahernandez.verotest.model.agents.Compilazione;
import com.andresochoahernandez.verotest.model.domain.Domanda;
import com.andresochoahernandez.verotest.model.domain.Risposta;
import com.andresochoahernandez.verotest.repository.agents.CompilazioneRepository;
import com.andresochoahernandez.verotest.repository.domain.DomandaRepository;
import com.andresochoahernandez.verotest.repository.domain.RispostaRespository;
import com.andresochoahernandez.verotest.resolvers.inputs.CompilazioneInput;
import com.andresochoahernandez.verotest.resolvers.types.CompilazioneType;
import com.andresochoahernandez.verotest.resolvers.types.ResultType;
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
            List<Compilazione> similarComps = compilazioni.getSimilarCompilations(input.getIdUtente(),Timestamp.valueOf(input.getDataTest() + " " + input.getOraTest() + ":00"), input.getNomeTest(), input.getNomeDomanda(), input.getIdRisposta());
            for(Compilazione cmpltn : similarComps){
                compilazioni.delete(cmpltn);
            }
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
