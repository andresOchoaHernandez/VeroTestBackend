package com.andresochoahernandez.testonline.repository.agents;

import com.andresochoahernandez.testonline.model.agents.Compilazione;
import com.andresochoahernandez.testonline.model.agents.CompilazionePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface CompilazioneRepository extends JpaRepository<Compilazione, CompilazionePK> {
    @Query("SELECT c FROM Compilazione c WHERE c.idUtente = :idUtente AND c.dataEOraTest = :dataEOraTest AND c.nomeTest = :nomeTest")
    List<Compilazione> getAllCompilazioniOfUserOfExam(@Param(value = "idUtente") int idUtente,@Param(value = "dataEOraTest") Timestamp dataEOraTest,@Param(value = "nomeTest") String nomeTest);

    @Transactional
    @Modifying
    @Query("DELETE FROM Compilazione c WHERE c.idUtente = :idUtente AND c.dataEOraTest = :dataEOraTest AND c.nomeTest = :nomeTest")
    void deleteAllByUserAndExam(@Param(value = "idUtente") int idUtente,@Param(value = "dataEOraTest") Timestamp dataEOraTest,@Param(value = "nomeTest") String nomeTest);
}