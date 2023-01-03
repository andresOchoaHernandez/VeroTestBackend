package com.andresochoahernandez.testonline.resolvers.types;

import com.andresochoahernandez.testonline.model.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TestType
{
    private String data;
    private String nome;
    private boolean ordineCasuale;
    private boolean domandeConNumero;

    public TestType(String data, String nome, boolean ordineCasuale, boolean domandeConNumero) {
        this.data = data;
        this.nome = nome;
        this.ordineCasuale = ordineCasuale;
        this.domandeConNumero = domandeConNumero;
    }

    public TestType(Test test)
    {
        this.data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(test.getData());
        this.nome = test.getNome();
        this.ordineCasuale = test.isOrdineCasuale();
        this.domandeConNumero = test.isDomandeConNumero();
    }
}
