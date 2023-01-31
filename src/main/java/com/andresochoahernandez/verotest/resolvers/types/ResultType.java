package com.andresochoahernandez.verotest.resolvers.types;

public class ResultType {
    private String rispostaData;
    private Float puntiRispostaData;
    private String rispostaEsatta;

    public ResultType(String rispostaData, Float puntiRispostaData, String rispostaEsatta) {
        this.rispostaData = rispostaData;
        this.puntiRispostaData = puntiRispostaData;
        this.rispostaEsatta = rispostaEsatta;
    }

    public String getRispostaData() {
        return rispostaData;
    }

    public void setRispostaData(String rispostaData) {
        this.rispostaData = rispostaData;
    }

    public Float getPuntiRispostaData() {
        return puntiRispostaData;
    }

    public void setPuntiRispostaData(Float puntiRispostaData) {
        this.puntiRispostaData = puntiRispostaData;
    }

    public String getRispostaEsatta() {
        return rispostaEsatta;
    }

    public void setRispostaEsatta(String rispostaEsatta) {
        this.rispostaEsatta = rispostaEsatta;
    }
}
