package com.andresochoahernandez.testonline;

import com.andresochoahernandez.testonline.model.agents.User;
import com.andresochoahernandez.testonline.model.domain.Domanda;
import com.andresochoahernandez.testonline.model.domain.InTest;
import com.andresochoahernandez.testonline.model.domain.Risposta;
import com.andresochoahernandez.testonline.model.domain.Test;
import com.andresochoahernandez.testonline.repository.agents.UserRepository;
import com.andresochoahernandez.testonline.repository.domain.DomandaRepository;
import com.andresochoahernandez.testonline.repository.domain.InTestRepository;
import com.andresochoahernandez.testonline.repository.domain.RispostaRespository;
import com.andresochoahernandez.testonline.repository.domain.TestRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Component
public class DataLoader implements ApplicationRunner {
    private final boolean FIRST_RUN = false;

    private final UserRepository users;

    private final DomandaRepository domande;
    private final InTestRepository intest;
    private final RispostaRespository risposte;
    private final TestRepository test;

    public DataLoader(UserRepository users, DomandaRepository domande, InTestRepository intest, RispostaRespository risposte, TestRepository test) {
        this.users = users;
        this.domande = domande;
        this.intest = intest;
        this.risposte = risposte;
        this.test = test;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (!FIRST_RUN) return;

        /* LOADING TWO USERS WITH RESPECTIVE ROLES */
        users.save(new User("Marco", "1234", "ROLE_STUDENTE"));
        users.save(new User("Enrico", "1234", "ROLE_STUDENTE,ROLE_DOCENTE"));

        /* LOADING DATA TO THE DOMAIN DATABASE */

        /* TEST */
        Test programmazioneParallela = new Test(Timestamp.valueOf("2022-07-21 10:30:00.0"), "programmazione parallela", false, false);
        Test basiDiDatiLab = new Test(Timestamp.valueOf("2020-07-07 9:00:00.0"), "Basi di Dati - II appello laboratorio", true, true);

        test.save(programmazioneParallela);
        test.save(basiDiDatiLab);

        /* DOMANDA */
        Domanda leggeDiAmdahl = new Domanda("legge di Amdahl", "La legge di Amdahl misura", BigDecimal.valueOf(1.0), false, false);
        Domanda speedup = new Domanda("speedup", "Lo speedup è definito dalla seguente formula", BigDecimal.valueOf(1.0), false, false);
        Domanda tassonomiaDiFlynn = new Domanda("tassonomia di Flynn", "Seleziona le architetture appartenenti alla tassonomia di Flynn", BigDecimal.valueOf(4.0), true, false);
        Domanda UMA = new Domanda("UMA", "Cosa si intende per UMA quando si parla di shared memory", BigDecimal.valueOf(1.0), false, false);
        Domanda CUDA = new Domanda("CUDA", "I kernel CUDA vengono invocati dalla seguente istruzione", BigDecimal.valueOf(1.0), true, false);

        Domanda domanda1 = new Domanda("Domanda 1", "Si consideri il (Piano 1) ed il (Piano 2).\nSi selezioni l'affermazione corretta circa l'analisi dei piani.", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda2 = new Domanda("Domanda 2", "Dato il vincolo (A.nome, A.id) -> (B.marca, B.id) indicare qual è la corretta dichiarazione", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda3 = new Domanda("Domanda 3", "Si considerino i seguenti attributi e assegnamenti in una base di dati PostgreSQL:\\ninizio = '06:00:00' e data = '2020-05-01'\\nQuali sono i valori (con il loro dominio) che si ottengono dalle seguenti operazioni:\\n1. inizio + data\\n2. data - inizio", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda4 = new Domanda("Domanda 4", "Data la tabella\\nPROVE_DI_ESAME (\\nmatricola INTEGER,\\ninserogato INTEGER,\\nvoto DECIMAL(4, 2),\\ndata DATE)\\nsi scelga la query più efficiente che, per ogni studente con almeno 3 prove nel 2019, visualizza la media dei voti ottenuti.", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda5 = new Domanda("Domanda 5", "Si scelga qual è la migliore dichiarazione per un attributo che deve rappresentare l'orario di apertura di un ufficio di una compagnia internazionale.", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda6 = new Domanda("Domanda 6", "Data l'istruzione CRETE INDEX i1 ON spese(nome, cognome), dove entrambi nome e cognome hanno dominio VARCHAR(80), selezionare qual è l'alternativa corretta.", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda7 = new Domanda("Domanda 7", "Si consideri la seguente dichiarazione PostgreSQL:\\n(CREATE Query 1)\\nSi vuole garantire che i due valori numerici siano non negativi e che il loro prodotto sia inferiore a 1E7.\\nIndicare qual è l'alternativa corretta. ", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda8 = new Domanda("Domanda 8", "In PostgreSQL, data la dichiarazione\\nimporto NUMERIC(5, 2)\\ncosa succede se si assegna il valore 101.101 a importo?", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda9 = new Domanda("Domanda 9", "Scegliere la query più efficiente che determina i docenti che hanno insegnato per un numero totale di crediti di lezione maggiore o uguale di quello dei colleghi limitando l'analisi all'anno accademico 2010/2011. ", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda10 = new Domanda("Domanda 10", "In PostgreSQL, date le dichiarazioni\\nstato BOOLEAN, stato1 CHAR(1)\\ne gli assegnamenti da fare, per esempio, in un istruzione UPDATE\\nstato = '0'\\nstato1 = 'f'\\nScegliere l'unica risposta che descrive correttamente le proprietà dei due attributi.", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda11 = new Domanda("Domanda 11", "Indicare la dichiarazione corretta che permetta di rappresentare una chiave non primaria (nome, cognome) ", BigDecimal.valueOf(2.0), true, false);
        Domanda domanda12 = new Domanda("Domanda 12", "Si assume che ci siano le tabelle A e B così costituite in una base di dati di tipo PostgreSQL:\\n(Tabella A)\\n\\n(Tabella B)\\nSi consideri quindi la seguente query\\nselect a\\nfrom A\\nwhere a > any (\\n\\tselect * from B\\n);\\nIndicare la risposta corretta.", BigDecimal.valueOf(2.0), true, false);

        domande.save(leggeDiAmdahl);
        domande.save(speedup);
        domande.save(tassonomiaDiFlynn);
        domande.save(UMA);
        domande.save(CUDA);
        domande.save(domanda1);
        domande.save(domanda2);
        domande.save(domanda3);
        domande.save(domanda4);
        domande.save(domanda5);
        domande.save(domanda6);
        domande.save(domanda7);
        domande.save(domanda8);
        domande.save(domanda9);
        domande.save(domanda10);
        domande.save(domanda11);
        domande.save(domanda12);


        /* RISPOSTA */
        risposte.save(new Risposta("lo speedup globale data una percentuale di codice che può essere parallelizzato ed uno speedup teorico massimo", BigDecimal.valueOf(1.0), leggeDiAmdahl));
        risposte.save(new Risposta("lo speedup teorico data una percentuale di codice che può essere parallelizzato ed uno speedup globale", BigDecimal.valueOf(0.0), leggeDiAmdahl));
        risposte.save(new Risposta("SPEEDUP = TIME_sequential_exec / TIME_parallel_exec", BigDecimal.valueOf(1.0), speedup));
        risposte.save(new Risposta("SPEEDUP = TIME_parallel_exec / TIME_sequential_exec", BigDecimal.valueOf(0.0), speedup));
        risposte.save(new Risposta("SISD", BigDecimal.valueOf(0.25), tassonomiaDiFlynn));
        risposte.save(new Risposta("MISD", BigDecimal.valueOf(0.25), tassonomiaDiFlynn));
        risposte.save(new Risposta("SIMD", BigDecimal.valueOf(0.25), tassonomiaDiFlynn));
        risposte.save(new Risposta("MIMD", BigDecimal.valueOf(0.25), tassonomiaDiFlynn));
        risposte.save(new Risposta("IS", BigDecimal.valueOf(0.0), tassonomiaDiFlynn));
        risposte.save(new Risposta("CU", BigDecimal.valueOf(0.0), tassonomiaDiFlynn));
        risposte.save(new Risposta("MM", BigDecimal.valueOf(0.0), tassonomiaDiFlynn));
        risposte.save(new Risposta("PU", BigDecimal.valueOf(0.0), tassonomiaDiFlynn));
        risposte.save(new Risposta("Tutti i processori sono identici ed impiegano lo stesso identico tempo per accedere alla memoria", BigDecimal.valueOf(1.0), UMA));
        risposte.save(new Risposta("Tutti i processori sono diversi ed hanno tempi di accesso diversi alla memoria", BigDecimal.valueOf(0.0), UMA));
        risposte.save(new Risposta("MatriMultiplicationKernel<<dimGrid,dimBlock>>", BigDecimal.valueOf(0.0), CUDA));
        risposte.save(new Risposta("MatriMultiplicationKernel<<dimGrid,dimBlock>>(A,B,C,N)", BigDecimal.valueOf(1.0), CUDA));
        risposte.save(new Risposta("MatriMultiplicationKernel(A,B,C,N)", BigDecimal.valueOf(0.0), CUDA));
        risposte.save(new Risposta("MatriMultiplicationKernel<<A,B,C,N>>", BigDecimal.valueOf(0.0), CUDA));


        risposte.save(new Risposta("Nel Piano 2 è stato usato anche l'indice creato con il comando\\nCREATE INDEX pippo ON insegn(id);\\nIl guadagno è di 82 accessi al disco circa ma si potrebbe migliorare con un indice su Discriminante.id ", BigDecimal.valueOf(0.0), domanda1));
        risposte.save(new Risposta("Nel Piano 2 è stato usato anche l'indice creato con il comando\\nCREATE INDEX ON insegn(id);\\nIl guadagno è di 82 secondi circa ma si potrebbe migliorare con un indice su Discriminante.id ", BigDecimal.valueOf(0.0), domanda1));
        risposte.save(new Risposta("Nel Piano 2 è stato usato anche l'indice creato con il comando\\nCREATE INDEX pippo ON insegn(id) USING hash(id);\\nIl guadagno è di 82 accessi al disco circa", BigDecimal.valueOf(1.0), domanda1));
        risposte.save(new Risposta("Nel Piano 2 è stato usato anche l'indice creato con il comando\\nCREATE INDEX pippo ON insegn(id);\\nCREATE INDEX ON ie_aa_it ON inserogato(annoaccademico);Il guadagno è di 82 accessi al disco circa", BigDecimal.valueOf(0.5), domanda1));
        risposte.save(new Risposta("Nella tabella B:\\nmarca VARCHAR UNIQUE,\\nid SERIAL PRIMARY KEY\\nNella tabella A:\\nnome VARCHAR REFERENCES B(marca)\\nid INTEGER REFERENCES B(id)", BigDecimal.valueOf(0.0), domanda2));
        risposte.save(new Risposta("Nella tabella B:\\nmarca VARCHAR NOT NULL,\\nid SERIAL NOT NULL\\nNella tabella A:\\nnome VARCHAR\\nid INTEGER\\n FOREIGN KEY (nome, id) REFERENCES B(marca, id)", BigDecimal.valueOf(0.5), domanda2));
        risposte.save(new Risposta("Nella tabella B:\\nmarca CHAR(10) NOT NULL,\\nid SERIAL NOT NULL\\nUNIQUE (marca, id)\\nNella tabella A:\\nnome VARCHAR\\nid INTEGER\\n FOREIGN KEY (nome, id) REFERENCES B(marca, id)", BigDecimal.valueOf(1.0), domanda2));
        risposte.save(new Risposta("Nella tabella B:\\nmarca VARCHAR NOT NULL,\\nid INTEGER NOT NULL\\nFOREIGN KEY (marca, id) REFERENCES A(nome, id\\nNella tabella A:\\nnome VARCHAR\\nid SERIAL\\n PRIMARY KEY (nome, id)", BigDecimal.valueOf(0.0), domanda2));
        risposte.save(new Risposta("Sono entrambi due valori TIME e rappresentano un istante: in primo le 6 del 2020-05-01, il secondo le 18 del 2020-04-03 ", BigDecimal.valueOf(0.0), domanda3));
        risposte.save(new Risposta("Sono entrambi due valori INTERVAL e rappresentano il numero di secondi dal 01/01/1970 dell'istante determinato dalle operazioni ", BigDecimal.valueOf(0.5), domanda3));
        risposte.save(new Risposta("Non sono nulla perché non è possibile eseguire le due operazioni", BigDecimal.valueOf(0.0), domanda3));
        risposte.save(new Risposta("Non sono nulla Sono entrambi due valori TIMESTAMP WITHOUT TIME ZONE e rappresentano un istante: in primo le 6 del 2020-05-01, il secondo le 18 del 2020-04-03  non è possibile eseguire le due operazioni", BigDecimal.valueOf(1.0), domanda3));
        risposte.save(new Risposta("SELECT matricola, AVG(voto)\\nFROM PROVE_DI_ESAME\\nWHERE count(*) >= 3 AND EXTRACT(YEAR FROM data) = 2019\\nGROUP BY matricola;", BigDecimal.valueOf(0.0), domanda4));
        risposte.save(new Risposta("SELECT matricola, AVG(voto)\\nFROM PROVE_DI_ESAME\\nGROUP BY matricola\\n HAVING count(*) >= 3 AND EXTRACT(YEAR FROM data) = 2019;", BigDecimal.valueOf(0.0), domanda4));
        risposte.save(new Risposta("SELECT matricola, AVG(voto)\\nFROM PROVE_DI_ESAME\\nWHERE EXTRACT(YEAR FROM data) = 2019\\nGROUP BY matricola\\nHAVING count(distinct inserogato)>=3;", BigDecimal.valueOf(0.5), domanda4));
        risposte.save(new Risposta("SELECT matricola, AVG(voto)\\nFROM PROVE_DI_ESAME\\nWHERE EXTRACT(YEAR FROM data) = 2019\\nGROUP BY matricola\\nHAVING count(*)>=3;", BigDecimal.valueOf(1.0), domanda4));
        risposte.save(new Risposta("apertura TIME WITH TIME ZONE,", BigDecimal.valueOf(1.0), domanda5));
        risposte.save(new Risposta("apertura TIME,", BigDecimal.valueOf(0.0), domanda5));
        risposte.save(new Risposta("apertura TIMESTAMP,", BigDecimal.valueOf(0.0), domanda5));
        risposte.save(new Risposta("apertura TIMESTAMP WITH TIME ZONE,", BigDecimal.valueOf(0.5), domanda5));
        risposte.save(new Risposta("i1 è un indice che può essere usato per risolvere selezioni del tipo nome > espressione1 OR cognome > espressione2 in qualsiasi tipo di base di dati.", BigDecimal.valueOf(0.0), domanda6));
        risposte.save(new Risposta("i1 è un indice che può essere usato per risolvere selezioni del tipo nome = espressione1 AND cognome = espressione2 in qualsiasi tipo di base di dati.", BigDecimal.valueOf(1.0), domanda6));
        risposte.save(new Risposta("i1 è un indice che può essere usato per risolvere selezioni del tipo nome = espressione1 AND cognome = espressione2 in basi di dati con locale uguale a C.", BigDecimal.valueOf(0.5), domanda6));
        risposte.save(new Risposta("i1 è un indice che può essere usato per risolvere selezioni del tipo nome = espressione1, cognome = espressione2 in qualsiasi combinazione in qualsiasi tipo di base di dati.", BigDecimal.valueOf(0.5), domanda6));
        risposte.save(new Risposta("ALTER TABLE A ADD CONSTRAINT nonneg_check CHECK (prezzoUnitario >= 0 AND quantita >= 0);", BigDecimal.valueOf(1.0), domanda7));
        risposte.save(new Risposta("ALTER TABLE A ADD CONSTRAINT nonneg_check CHECK (prezzoUnitario * quantita >= 0);", BigDecimal.valueOf(0.5), domanda7));
        risposte.save(new Risposta("ALTER TABLE A ADD CONSTRAINT CHECK (prezzoUnitario >= 0 AND quantita >= 0);", BigDecimal.valueOf(0.0), domanda7));
        risposte.save(new Risposta("Nessuna delle precedenti è corretta.", BigDecimal.valueOf(0.0), domanda7));
        risposte.save(new Risposta("Si verifica un errore perché il numero totale di cifre è 6 mentre importo può avere max 5 cifre in totale.", BigDecimal.valueOf(0.0), domanda8));
        risposte.save(new Risposta("importo assume il valore 101.11", BigDecimal.valueOf(1.0), domanda8));
        risposte.save(new Risposta("Il sistema chiede come arrotondare all'utente, perché il valore deve essere esatto e non lo può inferire in autonomia.", BigDecimal.valueOf(0.0), domanda8));
        risposte.save(new Risposta("importo assume il valore 101.10", BigDecimal.valueOf(0.5), domanda8));
        risposte.save(new Risposta("(Query 1)", BigDecimal.valueOf(0.0), domanda9));
        risposte.save(new Risposta("(Query 2)", BigDecimal.valueOf(0.0), domanda9));
        risposte.save(new Risposta("(Query 3)", BigDecimal.valueOf(0.5), domanda9));
        risposte.save(new Risposta("(Query 4)", BigDecimal.valueOf(1.0), domanda9));
        risposte.save(new Risposta("Entrambi gli assegnamenti rappresentano il valore 'falso' ma il secondo è più versatile perché può assumere il valore NULL", BigDecimal.valueOf(0.0), domanda10));
        risposte.save(new Risposta("Entrambi gli assegnamenti richiedono lo stesso spazio in memoria.", BigDecimal.valueOf(0.5), domanda10));
        risposte.save(new Risposta("L'assegnamento a stato è errato perchè deve essere scritto FALSE", BigDecimal.valueOf(0.0), domanda10));
        risposte.save(new Risposta("Uno rappresenta il valore falso, l'altro il carattere 'f'", BigDecimal.valueOf(1.0), domanda10));
        risposte.save(new Risposta("nome VARCHAR,\\ncognome VARCHAR,\\nUNIQUE (nome, cognome)", BigDecimal.valueOf(0.5), domanda11));
        risposte.save(new Risposta("nome VARCHAR,\\ncognome VARCHAR,\\nPRIMARY KEY (nome, cognome)", BigDecimal.valueOf(0.0), domanda11));
        risposte.save(new Risposta("nome VARCHAR,\\ncognome VARCHAR,\\nUNIQUE (nome, cognome),\\nNOT NULL (nome, cognome)", BigDecimal.valueOf(0.0), domanda11));
        risposte.save(new Risposta("nome VARCHAR,\\ncognome VARCHAR,\\nUNIQUE (nome, cognome),\\nNOT NULL (nome, cognome)", BigDecimal.valueOf(0.0), domanda11));
        risposte.save(new Risposta("nome VARCHAR NOT NULL,\\ncognome VARCHAR NOT NULL,\\nUNIQUE (nome, cognome)", BigDecimal.valueOf(1.0), domanda11));
        risposte.save(new Risposta("Si genera un errore perché la sotto query deve essere scritta come SELECT b FROM B", BigDecimal.valueOf(0.0), domanda12));
        risposte.save(new Risposta("La query ritorna una tabella di una riga con valore null", BigDecimal.valueOf(0.5), domanda12));
        risposte.save(new Risposta("La query ritorna una tabella di 2 righe, ciascuna con valore null", BigDecimal.valueOf(0.0), domanda12));
        risposte.save(new Risposta("La query ritorna una tabella vuota (nessuna riga)", BigDecimal.valueOf(1.0), domanda12));

        /* INTEST */
        intest.save(new InTest(leggeDiAmdahl, programmazioneParallela));
        intest.save(new InTest(speedup, programmazioneParallela));
        intest.save(new InTest(tassonomiaDiFlynn, programmazioneParallela));
        intest.save(new InTest(UMA, programmazioneParallela));
        intest.save(new InTest(CUDA, programmazioneParallela));
        intest.save(new InTest(domanda1, basiDiDatiLab));
        intest.save(new InTest(domanda2, basiDiDatiLab));
        intest.save(new InTest(domanda3, basiDiDatiLab));
        intest.save(new InTest(domanda4, basiDiDatiLab));
        intest.save(new InTest(domanda5, basiDiDatiLab));
        intest.save(new InTest(domanda6, basiDiDatiLab));
        intest.save(new InTest(domanda7, basiDiDatiLab));
        intest.save(new InTest(domanda8, basiDiDatiLab));
        intest.save(new InTest(domanda9, basiDiDatiLab));
        intest.save(new InTest(domanda10, basiDiDatiLab));
        intest.save(new InTest(domanda11, basiDiDatiLab));
        intest.save(new InTest(domanda12, basiDiDatiLab));
    }
}
