package org.example;

public class Resposta {
    private int id;
    private int intencaoId;
    private String textoResposta;
    private String arquivoAvatar;
    private String criadoEm;

    public Resposta() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIntencaoId() { return  intencaoId; }
    public void setIntencaoId(int intencaoId) { this.intencaoId = intencaoId; }

    public String getTextoResposta() { return  textoResposta; }
    public void setTextoResposta(String textoResposta) { this.textoResposta = textoResposta; }

    public String getArquivoAvatar() { return arquivoAvatar; }
    public void setArquivoAvatar (String arquivoAvatar) { this.arquivoAvatar = arquivoAvatar; }

    public String getCriadoEm() { return  criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }
}
