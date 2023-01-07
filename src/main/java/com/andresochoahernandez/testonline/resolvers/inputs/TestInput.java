package com.andresochoahernandez.testonline.resolvers.inputs;

import com.andresochoahernandez.testonline.model.domain.Test;

import java.sql.Timestamp;

public class TestInput
{
    private final String data;
    private final String ora;
    private final String nome;
    private final boolean ordineCasuale;
    private final boolean domandeConNumero;

    public TestInput(String data,String ora,String nome, boolean ordineCasuale, boolean domandeConNumero) {
        this.data = data;
        this.ora = ora;
        this.nome = nome;
        this.ordineCasuale = ordineCasuale;
        this.domandeConNumero = domandeConNumero;
    }

    public Test toJpaEntity()
    {
        return new Test(
                Timestamp.valueOf(this.data + " " + this.ora + ":00"),
                this.nome,
                this.ordineCasuale,
                this.domandeConNumero
        );
    }

    public String getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public boolean isOrdineCasuale() {
        return ordineCasuale;
    }

    public boolean isDomandeConNumero() {
        return domandeConNumero;
    }

    public String getOra() {
        return ora;
    }
}
