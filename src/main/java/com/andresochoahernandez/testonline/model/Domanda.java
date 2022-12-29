package com.andresochoahernandez.testonline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "domanda" , schema = "public" , catalog = "testonline")
public class Domanda {
    @Column(name = "nome", nullable = false , columnDefinition = "varchar")
    @Id
    private String nome;
    @Column(name = "testo", nullable = false , columnDefinition = "varchar")
    private String testo;
    @Column(name = "punti" , columnDefinition = "decimal(5,2)")
    private BigDecimal punti;
    @Column(name = "ordinecasuale" , columnDefinition = "boolean default false")
    private boolean ordineCasuale = false;
    @Column(name = "risposteconnumero" , columnDefinition = "boolean default false")
    private boolean risposteConNumero = false;

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

    public BigDecimal getPunti() {
        return punti;
    }

    public void setPunti(BigDecimal punti) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Domanda that)) return false;
        return isOrdineCasuale() == that.isOrdineCasuale() && isRisposteConNumero() == that.isRisposteConNumero() && getNome().equals(that.getNome()) && getTesto().equals(that.getTesto()) && getPunti().equals(that.getPunti());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getTesto(), getPunti(), isOrdineCasuale(), isRisposteConNumero());
    }
}
