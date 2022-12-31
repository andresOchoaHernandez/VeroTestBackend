package com.andresochoahernandez.testonline.repository;

import com.andresochoahernandez.testonline.model.Domanda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DomandaRepository extends JpaRepository<Domanda,String> {
}
