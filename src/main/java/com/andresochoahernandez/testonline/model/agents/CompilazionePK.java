package com.andresochoahernandez.testonline.model.agents;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class CompilazionePK implements Serializable {
    @Id
    @Column(name = "idutente")
    private int idUtente;
    @Id
    @Column(name = "dataeoratest")
    private Timestamp dataEOraTest;
    @Id
    @Column(name = "nometest")
    private String nomeTest;
    @Id
    @Column(name = "nomedomanda")
    private String nomeDomanda;
    @Id
    @Column(name = "idrisposta")
    private int idRisposta;

    public CompilazionePK(){}

    public CompilazionePK(int idUtente, Timestamp dataEOraTest, String nomeTest, String nomeDomanda, int idRisposta) {
        this.idUtente = idUtente;
        this.dataEOraTest = dataEOraTest;
        this.nomeTest = nomeTest;
        this.nomeDomanda = nomeDomanda;
        this.idRisposta = idRisposta;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public Timestamp getDataEOraTest() {
        return dataEOraTest;
    }

    public void setDataEOraTest(Timestamp dataEOraTest) {
        this.dataEOraTest = dataEOraTest;
    }

    public String getNomeTest() {
        return nomeTest;
    }

    public void setNomeTest(String nomeTest) {
        this.nomeTest = nomeTest;
    }

    public String getNomeDomanda() {
        return nomeDomanda;
    }

    public void setNomeDomanda(String nomeDomanda) {
        this.nomeDomanda = nomeDomanda;
    }

    public int getIdRisposta() {
        return idRisposta;
    }

    public void setIdRisposta(int idRisposta) {
        this.idRisposta = idRisposta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompilazionePK that)) return false;
        return getIdUtente() == that.getIdUtente() && getIdRisposta() == that.getIdRisposta() && getDataEOraTest().equals(that.getDataEOraTest()) && getNomeTest().equals(that.getNomeTest()) && getNomeDomanda().equals(that.getNomeDomanda());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUtente(), getDataEOraTest(), getNomeTest(), getNomeDomanda(), getIdRisposta());
    }
}
