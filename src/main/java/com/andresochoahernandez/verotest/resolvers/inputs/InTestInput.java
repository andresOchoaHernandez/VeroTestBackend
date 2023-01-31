package com.andresochoahernandez.verotest.resolvers.inputs;

import com.andresochoahernandez.verotest.model.domain.Domanda;
import com.andresochoahernandez.verotest.model.domain.InTest;
import com.andresochoahernandez.verotest.model.domain.Test;

public class InTestInput {
    private final String domanda;
    private final String dataTest;
    private final String oraTest;
    private final String nomeTest;

    public InTestInput(String domanda, String dataTest, String oraTest,String nomeTest) {
        this.domanda = domanda;
        this.dataTest = dataTest;
        this.oraTest = oraTest;
        this.nomeTest = nomeTest;
    }

    public InTest toJpaEntity(Domanda domanda, Test test)
    {
        return new InTest(
                domanda,
                test
        );
    }

    public String getDomanda() {
        return domanda;
    }

    public String getDataTest() {
        return dataTest;
    }

    public String getOraTest() {
        return oraTest;
    }

    public String getNomeTest() {
        return nomeTest;
    }
}
