package com.andresochoahernandez.testonline.resolvers.inputs;

import com.andresochoahernandez.testonline.model.Domanda;

import java.math.BigDecimal;

public class DomandaInput {
    private String nome;
    private String testo;
    private Float punti;
    private boolean ordineCasuale;
    private boolean risposteConNumero;

    public DomandaInput(String nome, String testo, Float punti, boolean ordineCasuale, boolean risposteConNumero) {
        this.nome = nome;
        this.testo = testo;
        this.punti = punti;
        this.ordineCasuale = ordineCasuale;
        this.risposteConNumero = risposteConNumero;
    }

    public Domanda toJpaEntity()
    {
        return new Domanda(
                this.nome,
                this.testo,
                new BigDecimal(this.punti),
                this.ordineCasuale,
                this.risposteConNumero
        );
    }
}
