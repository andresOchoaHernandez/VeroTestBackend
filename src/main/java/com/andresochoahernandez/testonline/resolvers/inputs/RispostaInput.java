package com.andresochoahernandez.testonline.resolvers.inputs;

import com.andresochoahernandez.testonline.model.Domanda;
import com.andresochoahernandez.testonline.model.Risposta;

import java.math.BigDecimal;

public class RispostaInput {
    private int id;
    private String testo;
    private Float punteggio;
    private String domanda;

    public RispostaInput(int id, String testo, Float punteggio, String domanda) {
        this.id = id;
        this.testo = testo;
        this.punteggio = punteggio;
        this.domanda = domanda;
    }

    public Risposta toJpaEntity(Domanda domanda)
    {
        return new Risposta(
                this.testo,
                new BigDecimal(this.punteggio),
                domanda
        );
    }
}
