package com.andresochoahernandez.testonline.resolvers.inputs;

import com.andresochoahernandez.testonline.model.Domanda;
import com.andresochoahernandez.testonline.model.InTest;
import com.andresochoahernandez.testonline.model.Test;

import java.text.SimpleDateFormat;

public class InTestInput {
    private int id;
    private String domanda;
    private String dataTest;
    private String nomeTest;

    public InTestInput(int id, String domanda, String dataTest, String nomeTest) {
        this.id = id;
        this.domanda = domanda;
        this.dataTest = dataTest;
        this.nomeTest = nomeTest;
    }

    public InTest toJpaEntity(Domanda domanda, Test test)
    {
        return new InTest(
                domanda,
                test
        );
    }
}
