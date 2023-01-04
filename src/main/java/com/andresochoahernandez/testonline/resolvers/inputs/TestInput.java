package com.andresochoahernandez.testonline.resolvers.inputs;

import com.andresochoahernandez.testonline.model.Test;
import com.andresochoahernandez.testonline.resolvers.types.TestType;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TestInput
{
    private String data;
    private String ora;
    private String nome;
    private boolean ordineCasuale;
    private boolean domandeConNumero;

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
