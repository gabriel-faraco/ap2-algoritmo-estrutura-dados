package exercicio1;


public class FilaPedidos {
    private NoPedido inicio;
    private NoPedido fim;

    public boolean estaVazia() {
        return inicio == null;
    }

    // Adiciona um pedido no final da fila.
    public void enqueue(Pedido pedido) {
        NoPedido novo = new NoPedido(pedido);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    // Remove e retorna o pedido mais antigo.
    public Pedido dequeue() {
        if (estaVazia()) {
            return null;
        }

        Pedido pedidoRemovido = inicio.pedido;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        return pedidoRemovido;
    }

    public void printQueue() {
        if (estaVazia()) {
            System.out.println("Não há pedidos pendentes.");
            return;
        }

        NoPedido atual = inicio;

        System.out.println("\n--- PEDIDOS PENDENTES ---");

        while (atual != null) {
            System.out.println(atual.pedido);
            atual = atual.proximo;
        }
    }
}
