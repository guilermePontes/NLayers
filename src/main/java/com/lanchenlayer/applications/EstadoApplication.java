package com.lanchenlayer.applications;

import com.lanchenlayer.entities.Estado;
import com.lanchenlayer.repositories.EstadoRepository;
import com.lanchenlayer.services.EstadoService;

import java.util.ArrayList;

public class EstadoApplication {
    private EstadoRepository estadoRepository;
    private EstadoService estadoService;

    public EstadoApplication(EstadoRepository estadoRepository, EstadoService estadoService) {
        this.estadoRepository = estadoRepository;
        this.estadoService = estadoService;
    }

    public void adicionar(Estado produto) {
        this.estadoRepository.adicionar(produto);
        this.estadoService.salvarImagem(produto);
    }

    public void adicionarSoImagem(Estado produto) {
        this.estadoService.salvarImagem(produto);
    }

    public void remover(int DDD) {
        this.estadoRepository.remover(DDD);
        this.estadoService.removerImagem(DDD);
    }

    public Estado buscarPorDDD(int DDD) {
        return this.estadoRepository.buscarPorDDD(DDD);
    }

    public ArrayList<Estado> buscarTodos() {
        return this.estadoRepository.buscarTodos();
    }

    public void atualizarProduto(int DDD, Estado produto) {
        this.estadoRepository.atualizarProduto(DDD, produto);
        this.estadoService.atualizarImagem(produto);
    }
}
