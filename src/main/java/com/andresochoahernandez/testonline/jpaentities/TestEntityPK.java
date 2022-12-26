package com.andresochoahernandez.testonline.jpaentities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class TestEntityPK implements Serializable {
    @Column(name = "data", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Timestamp data;
    @Column(name = "nome", nullable = false, length = -1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        if (o == null || getClass() != o.getClass()) return false;
        TestEntityPK that = (TestEntityPK) o;
        return Objects.equals(data, that.data) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, nome);
    }
}
