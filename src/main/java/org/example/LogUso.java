package org.example;

public class LogUso {
    private int id;
    private int sinalId;
    private int usuarioId;
    private String respostaDac;
    private String criadoEm;

    public LogUso() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getSinalId() { return sinalId; }
    public void setSinalId(int sinalId) { this.sinalId = sinalId; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getRespostaDac() { return respostaDac; }
    public void setRespostaDac(String respostaDac) { this.respostaDac = respostaDac; }

    public String getCriadoEm() { return criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }
}