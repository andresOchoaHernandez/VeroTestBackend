package com.andresochoahernandez.testonline.repository;

import com.andresochoahernandez.testonline.model.domain.Risposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RispostaRespository extends JpaRepository<Risposta,Integer> {

    @Query("SELECT r FROM Risposta r WHERE r.domanda.nome = :domanda")
    List<Risposta> getRisposteOfDomanda(@Param(value = "domanda")String domanda);
}
