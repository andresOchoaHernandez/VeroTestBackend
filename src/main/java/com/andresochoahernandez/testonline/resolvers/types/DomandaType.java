package com.andresochoahernandez.testonline.resolvers.types;

import com.andresochoahernandez.testonline.model.domain.Domanda;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Float getPunti() {
        return punti;
    }

    public void setPunti(Float punti) {
        this.punti = punti;
    }

    public boolean isOrdineCasuale() {
        return ordineCasuale;
    }

    public void setOrdineCasuale(boolean ordineCasuale) {
        this.ordineCasuale = ordineCasuale;
    }

    public boolean isRisposteConNumero() {
        return risposteConNumero;
    }

    public void setRisposteConNumero(boolean risposteConNumero) {
        this.risposteConNumero = risposteConNumero;
    }
}
