package com.andresochoahernandez.testonline.resolvers.inputs;

import com.andresochoahernandez.testonline.model.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TestInput
{
    private String data;
    private String nome;
    private boolean ordineCasuale;
    private boolean domandeConNumero;

    public TestInput(String data, String nome, boolean ordineCasuale, boolean domandeConNumero) {
        this.data = data;
        this.nome = nome;
        this.ordineCasuale = ordineCasuale;
        this.domandeConNumero = domandeConNumero;
    }

    public Test toJpaEntity()
    {
        return new Test(
                Timestamp.valueOf(this.data),
                this.nome,
                this.ordineCasuale,
                this.domandeConNumero
        );
    }
}
