package exercicio2;


public class NoMusica {
    Musica musica;
    NoMusica anterior;
    NoMusica proximo;

    public NoMusica(Musica musica) {
        this.musica = musica;
        this.anterior = null;
        this.proximo = null;
    }
}
