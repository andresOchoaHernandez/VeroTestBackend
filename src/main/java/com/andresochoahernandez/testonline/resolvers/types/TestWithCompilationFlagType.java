package com.andresochoahernandez.testonline.resolvers.types;

public class TestWithCompilationFlagType {
    private final String data;
    private final String ora;
    private final String nome;
    private final boolean existPrevCompilation;

    public TestWithCompilationFlagType(String data, String ora, String nome, boolean existPrevCompilation) {
        this.data = data;
        this.ora = ora;
        this.nome = nome;
        this.existPrevCompilation = existPrevCompilation;
    }

    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }

    public String getNome() {
        return nome;
    }

    public boolean isExistPrevCompilation() {
        return existPrevCompilation;
    }
}
