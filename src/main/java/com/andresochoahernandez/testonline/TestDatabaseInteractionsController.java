package com.andresochoahernandez.testonline;

import com.andresochoahernandez.testonline.model.Domanda;
import com.andresochoahernandez.testonline.model.InTest;
import com.andresochoahernandez.testonline.repository.DomandaRepository;
import com.andresochoahernandez.testonline.repository.InTestRepository;
import com.andresochoahernandez.testonline.repository.RispostaRespository;
import com.andresochoahernandez.testonline.repository.TestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class TestDatabaseInteractionsController {

    private final TestRepository test;
    private final RispostaRespository risposta;
    private final InTestRepository intest;
    private final DomandaRepository domanda;

    public TestDatabaseInteractionsController(TestRepository test, RispostaRespository risposta, InTestRepository intest, DomandaRepository domanda)
    {
        this.test = test;
        this.risposta = risposta;
        this.intest = intest;
        this.domanda = domanda;
    }

    @GetMapping("/")
    public String hello(){ return "Hello world!";}

    @GetMapping("/read")
    public String ExampleOfReadingFromDatabase()
    {
        String res = "";

        List<InTest> record = intest.findAll();

        for(InTest curr : record)
        {
            res += "[ " + curr.getTest().getNome() + "," + curr.getTest().getData() +"," + curr.getDomanda().getNome() +" ]"  + "<br>";
        }

        return res;
    }

    @GetMapping("/write")
    public String ExampleOfWritingAndDeletingToAndFromDatabase()
    {
        Domanda domandaProva = new Domanda("prova nome", "prova testo" , new BigDecimal("1.0"),false,true);

        domanda.save(domandaProva);

        String res = "";

        List<Domanda> record = domanda.findAll();

        for(Domanda curr : record)
        {
            res += "[ " + curr.getNome() + "," + curr.getTesto() + "<br>";
        }

        domanda.delete(domandaProva);

        return res;
    }
}
