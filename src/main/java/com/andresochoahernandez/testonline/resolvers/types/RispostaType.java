package com.andresochoahernandez.testonline.resolvers.types;

import com.andresochoahernandez.testonline.model.Domanda;
import com.andresochoahernandez.testonline.model.Risposta;

import java.math.BigDecimal;

public class RispostaType {
    private int id;
    private String testo;
    private Float punteggio;
    private String domanda;

    public RispostaType(int id, String testo, Float punteggio, String domanda) {
        this.id = id;
        this.testo = testo;
        this.punteggio = punteggio;
        this.domanda = domanda;
    }

    public RispostaType(Risposta risposta)
    {
        this.id = risposta.getId();
        this.testo = risposta.getTesto();
        this.punteggio = risposta.getPunteggio().floatValue();
        this.domanda = risposta.getDomanda().getNome();
    }
}
