package com.andresochoahernandez.testonline.resolvers.types;

import com.andresochoahernandez.testonline.model.Domanda;

import java.math.BigDecimal;

public class DomandaType {
    private String nome;
    private String testo;
    private Float punti;
    private boolean ordineCasuale;
    private boolean risposteConNumero;

    public DomandaType(String nome, String testo, Float punti, boolean ordineCasuale, boolean risposteConNumero) {
        this.nome = nome;
        this.testo = testo;
        this.punti = punti;
        this.ordineCasuale = ordineCasuale;
        this.risposteConNumero = risposteConNumero;
    }

    public DomandaType(Domanda domanda)
    {
        this.nome = domanda.getNome();
        this.testo = domanda.getTesto();
        this.punti = domanda.getPunti().floatValue();
        this.ordineCasuale = domanda.isOrdineCasuale();
        this.risposteConNumero = domanda.isRisposteConNumero();
    }
}
