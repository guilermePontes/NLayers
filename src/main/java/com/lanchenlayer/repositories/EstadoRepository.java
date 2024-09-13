package com.lanchenlayer.repositories;

import com.lanchenlayer.entities.Estado;

import java.util.ArrayList;

public class EstadoRepository {
    private ArrayList<Estado> produtos = new ArrayList<Estado>();

    public void adicionar(Estado produto) {
        produtos.add(produto);
    }

    public void remover(int DDD) {
        produtos.removeIf(produto -> produto.getDDD() == DDD);
    }

    private Estado filtrarProduto(int DDD) {
        return produtos.stream().filter(p -> p.getDDD() == DDD).findFirst().get();
    }

    public Estado buscarPorDDD(int DDD) {
        Estado produtoInDb = filtrarProduto(DDD);

        return produtoInDb;
    }

    public ArrayList<Estado> buscarTodos() {
        return produtos;
    }

    public void atualizarProduto(int DDD, Estado produto) {
        Estado produtoInDb = filtrarProduto(DDD);

        produtoInDb.setEstado(produto.getEstado());
        produtoInDb.setImagem(produto.getImagem());
    }
}
