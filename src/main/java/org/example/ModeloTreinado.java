package org.example;

public class ModeloTreinado {
    private int id;
    private String nome;
    private String versao;
    private String arquivoMod;
    private boolean ativo;
    private String criadoEM;

    public ModeloTreinado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getArquivoMod() {
        return arquivoMod;
    }

    public void setArquivoMod(String arquivoMod) {
        this.arquivoMod = arquivoMod;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCriadoEM() {
        return criadoEM;
    }

    public void setCriadoEM(String criadoEM) {
        this.criadoEM = criadoEM;
    }
}