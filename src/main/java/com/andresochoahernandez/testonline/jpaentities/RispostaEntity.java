package com.andresochoahernandez.testonline.jpaentities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "risposta", schema = "public", catalog = "testonline")
public class RispostaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "testo", nullable = false, length = -1)
    private String testo;
    @Basic
    @Column(name = "punteggio", nullable = true, precision = 4)
    private BigDecimal punteggio;
    @Basic
    @Column(name = "domanda", nullable = true, length = -1)
    private String domanda;
    @ManyToOne
    @JoinColumn(name = "domanda", referencedColumnName = "nome")
    private DomandaEntity domandaByDomanda;

    public int getId() {
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

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RispostaEntity that = (RispostaEntity) o;
        return id == that.id && Objects.equals(testo, that.testo) && Objects.equals(punteggio, that.punteggio) && Objects.equals(domanda, that.domanda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testo, punteggio, domanda);
    }

    public DomandaEntity getDomandaByDomanda() {
        return domandaByDomanda;
    }

    public void setDomandaByDomanda(DomandaEntity domandaByDomanda) {
        this.domandaByDomanda = domandaByDomanda;
    }
}
