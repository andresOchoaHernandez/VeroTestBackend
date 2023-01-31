package com.andresochoahernandez.verotest.repository.domain;

import com.andresochoahernandez.verotest.model.domain.Test;
import com.andresochoahernandez.verotest.model.domain.TestPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test,TestPK> {

    @Query("SELECT t FROM Test t WHERE date(t.data) = date(:date) AND t.nome = :name")
    List<Test> getTestByDateAndName(@Param(value = "date")String date ,@Param(value = "name") String name);

    @Query("SELECT t FROM Test t WHERE date(t.data) = date(:date)")
    List<Test> getTestByDate(@Param(value = "date") String date);

    @Query("SELECT t FROM Test t WHERE t.nome = :nome")
    List<Test> getTestByName(@Param(value = "nome") String nome);
}
