package com.andresochoahernandez.testonline.repository.domain;

import com.andresochoahernandez.testonline.model.domain.Domanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DomandaRepository extends JpaRepository<Domanda,String> {

    @Query("SELECT d FROM InTest it JOIN Domanda d ON it.domanda.nome = d.nome WHERE it.test.data = to_timestamp(:testTimeStamp,'YYYY-MM-DD HH24:MI:SS') AND it.test.nome = :nome")
    List<Domanda> getDomandeOfTest(@Param(value = "testTimeStamp") String testTimeStamp, @Param(value = "nome") String nome);
}
