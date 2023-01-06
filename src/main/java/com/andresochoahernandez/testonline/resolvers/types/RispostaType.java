package com.andresochoahernandez.testonline.resolvers.types;

import com.andresochoahernandez.testonline.model.Risposta;

public class RispostaType {
    private final int id;
    private final String testo;
    private Float punteggio;
    private final String domanda;

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

    public void restrict()
    {
        this.punteggio = null;
    }
}
