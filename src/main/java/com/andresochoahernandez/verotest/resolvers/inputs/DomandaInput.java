package com.andresochoahernandez.verotest.resolvers.inputs;

import com.andresochoahernandez.verotest.model.domain.Domanda;

import java.math.BigDecimal;

public class DomandaInput {
    private final String nome;
    private final String testo;
    private final Float punti;
    private final boolean ordineCasuale;
    private final boolean risposteConNumero;

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

    public String getNome() {
        return nome;
    }

    public String getTesto() {
        return testo;
    }

    public Float getPunti() {
        return punti;
    }

    public boolean isOrdineCasuale() {
        return ordineCasuale;
    }

    public boolean isRisposteConNumero() {
        return risposteConNumero;
    }
}
