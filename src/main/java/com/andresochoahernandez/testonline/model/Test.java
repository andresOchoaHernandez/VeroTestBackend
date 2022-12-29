package com.andresochoahernandez.testonline.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "test" , schema = "public" , catalog = "testonline")
@IdClass(TestPK.class)
public class Test {

    @Column(name = "data" , nullable = false , columnDefinition = "timestamp")
    @Id
    private Timestamp data;
    @Column(name = "nome" , nullable = false , columnDefinition = "varchar")
    @Id
    private String nome;
    @Column(name = "ordinecasuale" , columnDefinition = "boolean default false")
    private boolean ordineCasuale = false;
    @Column(name = "domandeconnumero" , columnDefinition = "boolean default false")
    private boolean domandeConNumero = false;

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

    public boolean isOrdineCasuale() {
        return ordineCasuale;
    }

    public void setOrdineCasuale(boolean ordineCasuale) {
        this.ordineCasuale = ordineCasuale;
    }

    public boolean isDomandeConNumero() {
        return domandeConNumero;
    }

    public void setDomandeConNumero(boolean domandeConNumero) {
        this.domandeConNumero = domandeConNumero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test that)) return false;
        return isOrdineCasuale() == that.isOrdineCasuale() && isDomandeConNumero() == that.isDomandeConNumero() && getData().equals(that.getData()) && getNome().equals(that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getNome(), isOrdineCasuale(), isDomandeConNumero());
    }
}
