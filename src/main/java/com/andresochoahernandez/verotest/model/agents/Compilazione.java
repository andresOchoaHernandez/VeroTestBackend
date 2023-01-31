package com.andresochoahernandez.verotest.model.agents;

import com.andresochoahernandez.verotest.resolvers.types.CompilazioneType;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
@Table(name = "compilazione", schema = "public", catalog = "users")
@IdClass(CompilazionePK.class)
public class Compilazione {
    @Id
    @Column(name = "idutente",nullable = false)
    private int idUtente;
    @Id
    @Column(name = "dataeoratest",nullable = false)
    private Timestamp dataEOraTest;
    @Id
    @Column(name = "nometest", columnDefinition = "varchar",nullable = false)
    private String nomeTest;
    @Id
    @Column(name = "nomedomanda", columnDefinition = "varchar",nullable = false)
    private String nomeDomanda;
    @Id
    @Column(name = "idrisposta",nullable = false)
    private int idRisposta;

    public Compilazione(){}

    public Compilazione(int idUtente, Timestamp dataEOraTest, String nomeTest, String nomeDomanda, int idRisposta) {
        this.idUtente = idUtente;
        this.dataEOraTest = dataEOraTest;
        this.nomeTest = nomeTest;
        this.nomeDomanda = nomeDomanda;
        this.idRisposta = idRisposta;
    }

    public CompilazioneType toType(){
        return new CompilazioneType(
                this.idUtente,
                new SimpleDateFormat("yyyy-MM-dd").format(dataEOraTest),
                new SimpleDateFormat("HH:mm").format(dataEOraTest),
                this.nomeTest,
                this.nomeDomanda,
                this.idRisposta
        );
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
        if (!(o instanceof Compilazione that)) return false;
        return getIdUtente() == that.getIdUtente() && getIdRisposta() == that.getIdRisposta() && getDataEOraTest().equals(that.getDataEOraTest()) && getNomeTest().equals(that.getNomeTest()) && getNomeDomanda().equals(that.getNomeDomanda());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUtente(), getDataEOraTest(), getNomeTest(), getNomeDomanda(), getIdRisposta());
    }
}
