package exercicio1;


public class NoPedido {
    Pedido pedido;
    NoPedido proximo;

    public NoPedido(Pedido pedido) {
        this.pedido = pedido;
        this.proximo = null;
    }
}