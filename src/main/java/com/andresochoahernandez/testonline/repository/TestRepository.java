package com.andresochoahernandez.testonline.repository;

import com.andresochoahernandez.testonline.model.Test;
import com.andresochoahernandez.testonline.model.TestPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test,TestPK> {
    @Query("SELECT t FROM Test t WHERE date(t.data) = date(:date)")
    List<Test> getTestByDate(@Param(value = "date") String date);

    @Query("SELECT t FROM Test t WHERE t.nome = :nome")
    List<Test> getTestByName(@Param(value = "nome") String nome);
}
