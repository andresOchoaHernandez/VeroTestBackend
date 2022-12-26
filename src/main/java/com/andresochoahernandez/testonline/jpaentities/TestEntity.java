package com.andresochoahernandez.testonline.jpaentities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "test", schema = "public", catalog = "testonline")
@IdClass(TestEntityPK.class)
public class TestEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "data", nullable = false)
    private Timestamp data;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nome", nullable = false, length = -1)
    private String nome;
    @Basic
    @Column(name = "ordinecasuale", nullable = true)
    private Boolean ordinecasuale;
    @Basic
    @Column(name = "domandeconnumero", nullable = true)
    private Boolean domandeconnumero;
    @OneToMany(mappedBy = "test")
    private Collection<IntestEntity> intests;

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

    public Boolean getOrdinecasuale() {
        return ordinecasuale;
    }

    public void setOrdinecasuale(Boolean ordinecasuale) {
        this.ordinecasuale = ordinecasuale;
    }

    public Boolean getDomandeconnumero() {
        return domandeconnumero;
    }

    public void setDomandeconnumero(Boolean domandeconnumero) {
        this.domandeconnumero = domandeconnumero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return Objects.equals(data, that.data) && Objects.equals(nome, that.nome) && Objects.equals(ordinecasuale, that.ordinecasuale) && Objects.equals(domandeconnumero, that.domandeconnumero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, nome, ordinecasuale, domandeconnumero);
    }

    public Collection<IntestEntity> getIntests() {
        return intests;
    }

    public void setIntests(Collection<IntestEntity> intests) {
        this.intests = intests;
    }
}
