package com.andresochoahernandez.verotest.model.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "intest" , schema = "public" , catalog = "verotest")
public class InTest {
    @Column(name = "id", columnDefinition = "serial")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "domanda", referencedColumnName = "nome")
    private Domanda domanda;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "datatest", referencedColumnName = "data", nullable = false), @JoinColumn(name = "nometest", referencedColumnName = "nome", nullable = false)})
    private Test test;

    public InTest(){}

    public InTest(Domanda domanda, Test test) {
        this.domanda = domanda;
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Domanda getDomanda() {
        return domanda;
    }

    public void setDomanda(Domanda domanda) {
        this.domanda = domanda;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InTest that)) return false;
        return getId() == that.getId() && getDomanda().equals(that.getDomanda()) && getTest().equals(that.getTest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDomanda(), getTest());
    }
}
