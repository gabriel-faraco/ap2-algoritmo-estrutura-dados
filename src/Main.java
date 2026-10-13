import exercicio1.FilaPedidos;
import exercicio1.Pedido;
import exercicio1.PilhaCancelados;
import exercicio2.PlaylistMenu;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final FilaPedidos fila = new FilaPedidos();
    private static final PilhaCancelados pilha = new PilhaCancelados();

    private static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== TRABALHO DE ESTRUTURAS DE DADOS =====");
            System.out.println("1 - Sistema da cafeteria");
            System.out.println("2 - Gerenciador de playlist");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> menuCafeteria();
                case 2 -> menuPlaylist();
                case 0 -> System.out.println("Programa encerrado.");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void menuCafeteria() {
        int opcao;

        do {
            System.out.println("\n===== CAFETERIA =====");
            System.out.println("1 - Adicionar novo pedido");
            System.out.println("2 - Atender pedido");
            System.out.println("3 - Cancelar pedido");
            System.out.println("4 - Restaurar pedido cancelado");
            System.out.println("5 - Imprimir pedidos pendentes");
            System.out.println("6 - Imprimir pedidos cancelados");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> adicionarPedido();
                case 2 -> atenderPedido();
                case 3 -> cancelarPedido();
                case 4 -> restaurarPedido();
                case 5 -> fila.printQueue();
                case 6 -> pilha.printStack();
                case 0 -> System.out.println("Voltando ao menu principal.");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void adicionarPedido() {
        System.out.print("Descrição do pedido: ");
        String descricao = scanner.nextLine().trim();

        if (descricao.isEmpty()) {
            System.out.println("A descrição não pode ficar vazia.");
            return;
        }

        Pedido pedido = new Pedido(proximoId++, descricao);
        fila.enqueue(pedido);

        System.out.println("Pedido adicionado: " + pedido);
    }

    private static void atenderPedido() {
        Pedido pedido = fila.dequeue();

        if (pedido == null) {
            System.out.println("Não há pedidos para atender.");
        } else {
            System.out.println("Pedido atendido: " + pedido);
        }
    }

    private static void cancelarPedido() {
        Pedido pedido = fila.dequeue();

        if (pedido == null) {
            System.out.println("Não há pedidos para cancelar.");
        } else {
            pilha.push(pedido);
            System.out.println("Pedido cancelado: " + pedido);
        }
    }

    private static void restaurarPedido() {
        Pedido pedido = pilha.pop();

        if (pedido == null) {
            System.out.println("Não há pedidos para restaurar.");
        } else {
            fila.enqueue(pedido);
            System.out.println("Pedido restaurado: " + pedido);
        }
    }

    private static int lerInteiro() {
        while (true) {
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Digite um número inteiro válido: ");
            }
        }
    }

    private static void menuPlaylist() {
        PlaylistMenu.executar(scanner);
    }
}
