package com.andresochoahernandez.testonline.resolvers.types;

import com.andresochoahernandez.testonline.model.Domanda;
import com.andresochoahernandez.testonline.model.InTest;
import com.andresochoahernandez.testonline.model.Test;

import java.text.SimpleDateFormat;

public class InTestType {
    private int id;
    private String domanda;
    private String dataTest;
    private String oraTest;
    private String nomeTest;

    public InTestType(int id, String domanda, String dataTest,String oraTest, String nomeTest) {
    this.id = id;
    this.domanda = domanda;
    this.dataTest = dataTest;
    this.oraTest = oraTest;
    this.nomeTest = nomeTest;
    }

    public InTestType(InTest inTest)
    {
        this.id = inTest.getId();
        this.domanda = inTest.getDomanda().getNome();
        this.dataTest = new SimpleDateFormat("yyyy-MM-dd").format(inTest.getTest().getData());
        this.oraTest = new SimpleDateFormat("HH:mm").format(inTest.getTest().getData());
        this.nomeTest = inTest.getTest().getNome();
    }
}
