package exercicio2;


import java.util.Scanner;

public class PlaylistMenu {

    public static void executar(Scanner scanner) {
        ListaMusicas playlist = new ListaMusicas();
        int opcao;

        do {
            System.out.println("\n===== GERENCIADOR DE PLAYLIST =====");
            System.out.println("1 - Próxima música");
            System.out.println("2 - Música anterior");
            System.out.println("3 - Ordenar playlist");
            System.out.println("4 - Tocar música atual");
            System.out.println("5 - Adicionar música");
            System.out.println("6 - Remover música");
            System.out.println("7 - Listar músicas");
            System.out.println("8 - Buscar música");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha: ");

            opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1 -> {
                    if (playlist.proxima()) {
                        playlist.tocarAtual();
                    } else {
                        System.out.println(
                                "Não existe próxima música.");
                    }
                }

                case 2 -> {
                    if (playlist.anterior()) {
                        playlist.tocarAtual();
                    } else {
                        System.out.println(
                                "Não existe música anterior.");
                    }
                }

                case 3 -> ordenar(playlist, scanner);

                case 4 -> playlist.tocarAtual();

                case 5 -> adicionar(playlist, scanner);

                case 6 -> remover(playlist, scanner);

                case 7 -> playlist.listar();

                case 8 -> {
                    System.out.print(
                            "Digite título, artista ou álbum: ");
                    String termo = scanner.nextLine().trim();

                    if (termo.isEmpty()) {
                        System.out.println("Termo vazio.");
                    } else {
                        playlist.buscar(termo);
                    }
                }

                case 0 -> System.out.println(
                        "Voltando ao menu principal.");

                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private static void adicionar(
            ListaMusicas playlist, Scanner scanner) {

        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();

        System.out.print("Artista: ");
        String artista = scanner.nextLine().trim();

        System.out.print("Álbum: ");
        String album = scanner.nextLine().trim();

        if (titulo.isEmpty() || artista.isEmpty()
                || album.isEmpty()) {
            System.out.println(
                    "Título, artista e álbum são obrigatórios.");
            return;
        }

        System.out.print("Duração em segundos: ");
        int duracao = lerInteiro(scanner);

        if (duracao <= 0) {
            System.out.println(
                    "A duração deve ser maior que zero.");
            return;
        }

        Musica musica = new Musica(
                titulo, artista, album, duracao);

        System.out.println("\nOnde deseja inserir?");
        System.out.println("1 - Início");
        System.out.println("2 - Fim");
        System.out.println("3 - Posição específica");
        System.out.print("Escolha: ");

        int local = lerInteiro(scanner);

        switch (local) {
            case 1 -> {
                playlist.adicionarInicio(musica);
                System.out.println("Música adicionada no início.");
            }

            case 2 -> {
                playlist.adicionarFim(musica);
                System.out.println("Música adicionada no fim.");
            }

            case 3 -> {
                System.out.print("Posição (começa em 0): ");
                int posicao = lerInteiro(scanner);

                if (playlist.adicionarPosicao(musica, posicao)) {
                    System.out.println(
                            "Música adicionada na posição " + posicao);
                } else {
                    System.out.println("Posição inválida.");
                }
            }

            default -> System.out.println("Local inválido.");
        }
    }

    private static void remover(
            ListaMusicas playlist, Scanner scanner) {

        System.out.println("\n1 - Remover pela posição");
        System.out.println("2 - Remover pelo título");
        System.out.print("Escolha: ");

        int modo = lerInteiro(scanner);
        Musica removida = null;

        switch (modo) {
            case 1 -> {
                System.out.print("Posição (começa em 0): ");
                int posicao = lerInteiro(scanner);
                removida = playlist.removerPosicao(posicao);
            }

            case 2 -> {
                System.out.print("Título da música: ");
                String titulo = scanner.nextLine().trim();

                removida = playlist.removerTitulo(titulo);
            }

            default -> {
                System.out.println("Opção inválida.");
                return;
            }
        }

        if (removida == null) {
            System.out.println(
                    "Música não encontrada ou posição inválida.");
        } else {
            System.out.println("Música removida: " + removida);
        }
    }

    private static void ordenar(
            ListaMusicas playlist, Scanner scanner) {

        System.out.println("\nOrdenar por:");
        System.out.println("1 - Título");
        System.out.println("2 - Artista");
        System.out.print("Escolha: ");

        int criterio = lerInteiro(scanner);

        switch (criterio) {
            case 1 -> playlist.ordenar("titulo");
            case 2 -> playlist.ordenar("artista");
            default -> System.out.println("Critério inválido.");
        }
    }

    private static int lerInteiro(Scanner scanner) {
        while (true) {
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.print(
                        "Digite um número inteiro válido: ");
            }
        }
    }
}
