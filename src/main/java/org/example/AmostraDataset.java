package org.example;

public class AmostraDataset {
    private int id;
    private int sinalId;
    private String arquivo;
    private String gravadoPor;

    public AmostraDataset() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getSinalId() { return sinalId; }
    public void setSinalId(int sinalId) { this.sinalId = sinalId; }

    public String getArquivo() { return arquivo; }
    public void setArquivo(String arquivo) { this.arquivo = arquivo; }

    public String getGravadoPor() { return gravadoPor; }
    public void setGravadoPor(String gravadoPor) { this.gravadoPor = gravadoPor; }
}