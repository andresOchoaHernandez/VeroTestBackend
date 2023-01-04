package com.andresochoahernandez.testonline.resolvers.inputs;

import com.andresochoahernandez.testonline.model.Domanda;
import com.andresochoahernandez.testonline.model.Risposta;
import com.andresochoahernandez.testonline.resolvers.types.DomandaType;
import com.andresochoahernandez.testonline.resolvers.types.RispostaType;

import java.math.BigDecimal;

public class RispostaInput {
    private String testo;
    private Float punteggio;
    private String domanda;

    public RispostaInput(String testo, Float punteggio, String domanda) {
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

    public String getTesto() {
        return testo;
    }

    public Float getPunteggio() {
        return punteggio;
    }

    public String getDomanda() {
        return domanda;
    }
}
