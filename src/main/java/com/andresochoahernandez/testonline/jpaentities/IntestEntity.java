package com.andresochoahernandez.testonline.jpaentities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "intest", schema = "public", catalog = "testonline")
public class IntestEntity {
    @Basic
    @Column(name = "domanda", nullable = true, length = -1)
    private String domanda;
    @Basic
    @Column(name = "datatest", nullable = false)
    private Timestamp datatest;
    @Basic
    @Column(name = "nometest", nullable = false, length = -1)
    private String nometest;
    @ManyToOne
    @JoinColumn(name = "domanda", referencedColumnName = "nome")
    private DomandaEntity domandaByDomanda;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "datatest", referencedColumnName = "data", nullable = false), @JoinColumn(name = "nometest", referencedColumnName = "nome", nullable = false)})
    private TestEntity test;

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public Timestamp getDatatest() {
        return datatest;
    }

    public void setDatatest(Timestamp datatest) {
        this.datatest = datatest;
    }

    public String getNometest() {
        return nometest;
    }

    public void setNometest(String nometest) {
        this.nometest = nometest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntestEntity that = (IntestEntity) o;
        return Objects.equals(domanda, that.domanda) && Objects.equals(datatest, that.datatest) && Objects.equals(nometest, that.nometest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domanda, datatest, nometest);
    }

    public DomandaEntity getDomandaByDomanda() {
        return domandaByDomanda;
    }

    public void setDomandaByDomanda(DomandaEntity domandaByDomanda) {
        this.domandaByDomanda = domandaByDomanda;
    }

    public TestEntity getTest() {
        return test;
    }

    public void setTest(TestEntity test) {
        this.test = test;
    }
}
