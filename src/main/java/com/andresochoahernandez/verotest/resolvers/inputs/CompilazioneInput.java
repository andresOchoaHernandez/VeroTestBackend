package com.andresochoahernandez.verotest.resolvers.inputs;

import com.andresochoahernandez.verotest.model.agents.Compilazione;

import java.sql.Timestamp;

public class CompilazioneInput {
    private int idUtente;
    private String dataTest;
    private String oraTest;
    private String nomeTest;
    private String nomeDomanda;
    private int idRisposta;

    public CompilazioneInput(){}

    public CompilazioneInput(int idUtente, String dataTest, String oraTest, String nomeTest, String nomeDomanda, int idRisposta) {
        this.idUtente = idUtente;
        this.dataTest = dataTest;
        this.oraTest = oraTest;
        this.nomeTest = nomeTest;
        this.nomeDomanda = nomeDomanda;
        this.idRisposta = idRisposta;
    }

    public Compilazione toJpaEntity()
    {
        return new Compilazione(
               this.idUtente,
               Timestamp.valueOf(this.dataTest + " " + this.oraTest + ":00"),
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

    public String getDataTest() {
        return dataTest;
    }

    public void setDataTest(String dataTest) {
        this.dataTest = dataTest;
    }

    public String getOraTest() {
        return oraTest;
    }

    public void setOraTest(String oraTest) {
        this.oraTest = oraTest;
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
}
