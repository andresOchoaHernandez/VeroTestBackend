package com.andresochoahernandez.testonline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class TestPK implements Serializable {
    @Column(name = "data", nullable = false)
    @Id
    private Timestamp data;
    @Column(name = "nome", nullable = false , columnDefinition = "varchar")
    @Id
    private String nome;

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestPK testPK)) return false;
        return getData().equals(testPK.getData()) && getNome().equals(testPK.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getNome());
    }
}
