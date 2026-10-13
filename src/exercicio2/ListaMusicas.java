package exercicio2;


public class ListaMusicas {
    private NoMusica inicio;
    private NoMusica fim;
    private NoMusica atual;
    private int tamanho;

    public ListaMusicas() {
        inicio = null;
        fim = null;
        atual = null;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    // Insere no início.
    public void adicionarInicio(Musica musica) {
        NoMusica novo = new NoMusica(musica);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }

        if (atual == null) {
            atual = novo;
        }

        tamanho++;
    }

    // Insere no final.
    public void adicionarFim(Musica musica) {
        NoMusica novo = new NoMusica(musica);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }

        if (atual == null) {
            atual = novo;
        }

        tamanho++;
    }

    // Insere usando posição iniciada em zero.
    public boolean adicionarPosicao(Musica musica, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            return false;
        }

        if (posicao == 0) {
            adicionarInicio(musica);
            return true;
        }

        if (posicao == tamanho) {
            adicionarFim(musica);
            return true;
        }

        NoMusica novo = new NoMusica(musica);
        NoMusica anterior = obterNo(posicao - 1);
        NoMusica proximo = anterior.proximo;

        novo.anterior = anterior;
        novo.proximo = proximo;
        anterior.proximo = novo;
        proximo.anterior = novo;

        tamanho++;
        return true;
    }

    // Localiza um nó pela posição.
    private NoMusica obterNo(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        NoMusica no;

        if (posicao < tamanho / 2) {
            no = inicio;

            for (int i = 0; i < posicao; i++) {
                no = no.proximo;
            }
        } else {
            no = fim;

            for (int i = tamanho - 1; i > posicao; i--) {
                no = no.anterior;
            }
        }

        return no;
    }

    // Avança para a próxima música.
    public boolean proxima() {
        if (atual == null || atual.proximo == null) {
            return false;
        }

        atual = atual.proximo;
        return true;
    }

    // Volta para a música anterior.
    public boolean anterior() {
        if (atual == null || atual.anterior == null) {
            return false;
        }

        atual = atual.anterior;
        return true;
    }

    public void tocarAtual() {
        if (atual == null) {
            System.out.println("A playlist está vazia.");
            return;
        }

        System.out.println("\n--- TOCANDO MÚSICA ---");
        System.out.println(atual.musica);
        System.out.println("Simulação: reproduzindo a música...");
    }

    public void listar() {
        if (estaVazia()) {
            System.out.println("A playlist está vazia.");
            return;
        }

        NoMusica no = inicio;
        int posicao = 0;

        System.out.println("\n--- PLAYLIST ---");

        while (no != null) {
            String marcador = (no == atual) ? " <-- ATUAL" : "";

            System.out.println("Posição " + posicao + ": "
                    + no.musica + marcador);

            no = no.proximo;
            posicao++;
        }
    }

    // Remove pela posição, começando em zero.
    public Musica removerPosicao(int posicao) {
        NoMusica removido = obterNo(posicao);

        if (removido == null) {
            return null;
        }

        NoMusica anterior = removido.anterior;
        NoMusica proximo = removido.proximo;

        if (anterior == null) {
            inicio = proximo;
        } else {
            anterior.proximo = proximo;
        }

        if (proximo == null) {
            fim = anterior;
        } else {
            proximo.anterior = anterior;
        }

        if (atual == removido) {
            atual = (proximo != null) ? proximo : anterior;
        }

        tamanho--;

        if (tamanho == 0) {
            inicio = null;
            fim = null;
            atual = null;
        }

        // Desconecta o nó removido da lista.
        removido.anterior = null;
        removido.proximo = null;

        return removido.musica;
    }

    // Remove a primeira música com o título informado.
    public Musica removerTitulo(String titulo) {
        NoMusica no = inicio;
        int posicao = 0;

        while (no != null) {
            if (no.musica.getTitulo().equalsIgnoreCase(titulo)) {
                return removerPosicao(posicao);
            }

            no = no.proximo;
            posicao++;
        }

        return null;
    }

    // Busca por título, artista ou álbum.
    public void buscar(String termo) {
        NoMusica no = inicio;
        boolean encontrou = false;

        while (no != null) {
            Musica musica = no.musica;

            if (musica.getTitulo().toLowerCase()
                    .contains(termo.toLowerCase())
                    || musica.getArtista().toLowerCase()
                    .contains(termo.toLowerCase())
                    || musica.getAlbum().toLowerCase()
                    .contains(termo.toLowerCase())) {

                System.out.println(musica);
                encontrou = true;
            }

            no = no.proximo;
        }

        if (!encontrou) {
            System.out.println("Nenhuma música encontrada.");
        }
    }

    // Ordena por título ou artista, em ordem alfabética.
    // Os nós continuam ligados; trocamos os dados das músicas.
    public void ordenar(String criterio) {
        if (tamanho < 2) {
            System.out.println("Não há músicas suficientes para ordenar.");
            return;
        }

        boolean porTitulo = criterio.equalsIgnoreCase("titulo");

        if (!porTitulo && !criterio.equalsIgnoreCase("artista")) {
            System.out.println("Critério inválido.");
            return;
        }

        for (NoMusica i = inicio; i != null; i = i.proximo) {
            for (NoMusica j = i.proximo; j != null; j = j.proximo) {

                String valorI = porTitulo
                        ? i.musica.getTitulo()
                        : i.musica.getArtista();

                String valorJ = porTitulo
                        ? j.musica.getTitulo()
                        : j.musica.getArtista();

                if (valorI.compareToIgnoreCase(valorJ) > 0) {
                    Musica temporaria = i.musica;
                    i.musica = j.musica;
                    j.musica = temporaria;
                }
            }
        }

        System.out.println("Playlist ordenada por "
                + (porTitulo ? "título." : "artista."));
    }
}
