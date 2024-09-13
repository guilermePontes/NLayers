package com.lanchenlayer;

import com.lanchenlayer.applications.EstadoApplication;
import com.lanchenlayer.entities.Estado;
import com.lanchenlayer.facade.EstadoFacade;
import com.lanchenlayer.repositories.EstadoRepository;
import com.lanchenlayer.services.EstadoService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello wolrld!
 */
public class Console {
    private static EstadoRepository estadoRepository;
    private static EstadoService estadoService;
    private static EstadoApplication estadoApplication;
    private static EstadoFacade estadoFacade;
    private static Scanner scanner;

    public static void resolverDependencias() {
        estadoRepository = new EstadoRepository();
        estadoService = new EstadoService();
        estadoApplication = new EstadoApplication(estadoRepository, estadoService);
        estadoFacade = new EstadoFacade(estadoApplication);
        scanner = new Scanner(System.in);
    }

    public static void inicializarProdutos() {
        estadoFacade.adicionar(new Estado(61, "Brasilia", "C:\\Users\\aluno\\imagens\\Brasilia.jpg"));
        estadoFacade.adicionar(new Estado(71, "Salvador", "C:\\Users\\aluno\\imagens\\Salvador.jpg"));
        estadoFacade.adicionar(new Estado(11, "São Paulo", "C:\\Users\\aluno\\imagens\\SaoPaulo.jpg"));
        estadoFacade.adicionar(new Estado(21, "Rio de Janeiro", "C:\\Users\\aluno\\imagens\\RioDeJaneiro.jpg"));
        estadoFacade.adicionar(new Estado(32, "Juiz de Fora", "C:\\Users\\aluno\\imagens\\JuizDeFora.jpg"));
        estadoFacade.adicionar(new Estado(19, "Campinas", "C:\\Users\\aluno\\imagens\\Campinas.jpg"));
        estadoFacade.adicionar(new Estado(27, "Vitoria", "C:\\Users\\aluno\\imagens\\Vitoria.jpg"));
        estadoFacade.adicionar(new Estado(31, "Belo Horizonte", "C:\\Users\\aluno\\imagens\\BeloHorizonte.jpg"));
        

    }

    public static void listarProdutos() {
        System.out.println("DDD    |    Estado");

        ArrayList<Estado> produtos = estadoFacade.buscarTodos();

        produtos.forEach(c -> {
            System.out.println(c.getDDD() + "   |     " + c.getEstado());
        });
    }

    public static void cadastrarProduto() {
        System.out.println("Informe o DDD do estado: ");
        int id = scanner.nextInt();

        System.out.println("Informe o nome do estado: ");
        String estado = scanner.next();

        System.out.println("Informe o caminho da imagem da bandeira: ");
        String imagem = scanner.next();

        Estado produto = new Estado(id, estado, imagem);
        estadoFacade.adicionar(produto);
    }

    public static void exibirMenu() {
        System.out.println("\n1 - Novo estado");
        System.out.println("2 - Atualizar estado");
        System.out.println("3 - Listar estados");
        System.out.println("4 - Buscar estado pelo DDD");
        System.out.println("5 - Remover estado");
        System.out.println("6 - Sair");
    }

    public static int solicitarInputUsuario() {
        System.out.println("Informe a opção do menu desejado: ");
        return scanner.nextInt();
    }

    public static void buscarPorDDD() {
        System.out.println("Informe o DDD desejada: ");
        int id = scanner.nextInt();


        System.out.println("Estado: " + estadoFacade.buscarPorDDD(id).getEstado());
    }

    private static void atualizarProduto() {
        System.out.println("Informe o DDD do produto que deseja atualizar: ");
        int DDD = scanner.nextInt();

        System.out.println("Informe a novo nome do estado: ");
        String descricao = scanner.next();

        System.out.println("Informe o novo caminho da imagem do produto: ");
        String imagem = scanner.next();

        Estado produto = new Estado(DDD, descricao,  imagem);
        estadoFacade.atualizarProduto(DDD, produto);
    }

    public static void removerProduto() {
        System.out.println("Informe o DDD do estado que deseja remover: ");
        int id = scanner.nextInt();

        estadoFacade.remover(id);
    }

    public static void rodar() {
        int opcaoMenu = 0;

        do {
            exibirMenu();
            opcaoMenu = solicitarInputUsuario();
            switch (opcaoMenu) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    buscarPorDDD();
                    break;
                case 5:
                    removerProduto();
                    break;
            }

        } while (opcaoMenu != 6);
    }

    public static void main(String[] args) {
        resolverDependencias();
        inicializarProdutos();
        rodar();
    }
}
