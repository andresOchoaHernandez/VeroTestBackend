package com.andresochoahernandez.testonline.resolvers.types;

import com.andresochoahernandez.testonline.model.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TestType
{
    private final String data;
    private final String ora;
    private final String nome;
    private final boolean ordineCasuale;
    private final boolean domandeConNumero;

    public TestType(String data, String ora, String nome, boolean ordineCasuale, boolean domandeConNumero) {
        this.data = data;
        this.ora = ora;
        this.nome = nome;
        this.ordineCasuale = ordineCasuale;
        this.domandeConNumero = domandeConNumero;
    }

    public TestType(Test test)
    {
        this.data = new SimpleDateFormat("yyyy-MM-dd").format(test.getData());
        this.ora  = new SimpleDateFormat("HH:mm").format(test.getData());
        this.nome = test.getNome();
        this.ordineCasuale = test.isOrdineCasuale();
        this.domandeConNumero = test.isDomandeConNumero();
    }
}
