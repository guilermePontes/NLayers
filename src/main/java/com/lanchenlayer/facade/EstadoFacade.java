package com.lanchenlayer.facade;

import com.lanchenlayer.applications.EstadoApplication;
import com.lanchenlayer.entities.Estado;

import java.util.ArrayList;

public class EstadoFacade {
    private EstadoApplication estadoApplication;

    public EstadoFacade(EstadoApplication estadoApplication) {
        this.estadoApplication = estadoApplication;
    }

    public void adicionar(Estado produto) {
        this.estadoApplication.adicionar(produto);
    }

    public void remover(int DDD) {
        this.estadoApplication.remover(DDD);
    }

    public Estado buscarPorDDD(int DDD) {
        return this.estadoApplication.buscarPorDDD(DDD);
    }

    public ArrayList<Estado> buscarTodos() {
        return this.estadoApplication.buscarTodos();
    }

    public void atualizarProduto(int DDD, Estado produto) {
        this.estadoApplication.atualizarProduto(DDD, produto);
    }
}
