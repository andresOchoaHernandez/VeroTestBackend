package com.andresochoahernandez.testonline.jpaentities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "domanda", schema = "public", catalog = "testonline")
public class DomandaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nome", nullable = false, length = -1)
    private String nome;
    @Basic
    @Column(name = "testo", nullable = false, length = -1)
    private String testo;
    @Basic
    @Column(name = "punti", nullable = true, precision = 2)
    private BigDecimal punti;
    @Basic
    @Column(name = "ordinecasuale", nullable = true)
    private Boolean ordinecasuale;
    @Basic
    @Column(name = "risposteconnumero", nullable = true)
    private Boolean risposteconnumero;
    @OneToMany(mappedBy = "domandaByDomanda")
    private Collection<IntestEntity> intestsByNome;
    @OneToMany(mappedBy = "domandaByDomanda")
    private Collection<RispostaEntity> rispostasByNome;

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

    public Boolean getOrdinecasuale() {
        return ordinecasuale;
    }

    public void setOrdinecasuale(Boolean ordinecasuale) {
        this.ordinecasuale = ordinecasuale;
    }

    public Boolean getRisposteconnumero() {
        return risposteconnumero;
    }

    public void setRisposteconnumero(Boolean risposteconnumero) {
        this.risposteconnumero = risposteconnumero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomandaEntity that = (DomandaEntity) o;
        return Objects.equals(nome, that.nome) && Objects.equals(testo, that.testo) && Objects.equals(punti, that.punti) && Objects.equals(ordinecasuale, that.ordinecasuale) && Objects.equals(risposteconnumero, that.risposteconnumero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, testo, punti, ordinecasuale, risposteconnumero);
    }

    public Collection<IntestEntity> getIntestsByNome() {
        return intestsByNome;
    }

    public void setIntestsByNome(Collection<IntestEntity> intestsByNome) {
        this.intestsByNome = intestsByNome;
    }

    public Collection<RispostaEntity> getRispostasByNome() {
        return rispostasByNome;
    }

    public void setRispostasByNome(Collection<RispostaEntity> rispostasByNome) {
        this.rispostasByNome = rispostasByNome;
    }
}
