package com.andresochoahernandez.testonline.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "risposta" , schema = "public" , catalog = "testonline")
public class Risposta {

    @Column(name = "id", columnDefinition = "serial")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "testo", nullable = false , columnDefinition = "varchar")
    private String testo;
    @Column(name = "punteggio",columnDefinition = "decimal(5,4) check(punteggio <= 1.0)")
    private BigDecimal punteggio;

    @ManyToOne
    @JoinColumn(name = "domanda", referencedColumnName = "nome")
    private Domanda domanda;

    public Risposta(){}

    public Risposta(String testo, BigDecimal punteggio, Domanda domanda) {
        this.testo = testo;
        this.punteggio = punteggio;
        this.domanda = domanda;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public BigDecimal getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(BigDecimal punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Risposta that)) return false;
        return getId() == that.getId() && getTesto().equals(that.getTesto()) && getPunteggio().equals(that.getPunteggio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTesto(), getPunteggio());
    }
}
