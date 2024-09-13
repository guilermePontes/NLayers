package com.lanchenlayer.entities;

public class Estado {

    private int DDD;
    private String estado;
    private String imagem;

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Estado(int DDD, String estado, String imagem) {
        this.DDD = DDD;
        this.estado = estado;
        this.imagem = imagem;

    }
}
