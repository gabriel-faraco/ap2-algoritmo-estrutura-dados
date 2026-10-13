package exercicio1;


public class PilhaCancelados {
    private NoPedido topo;

    public boolean estaVazia() {
        return topo == null;
    }

    // Adiciona um pedido cancelado ao topo.
    public void push(Pedido pedido) {
        NoPedido novo = new NoPedido(pedido);

        novo.proximo = topo;
        topo = novo;
    }

    // Remove e retorna o cancelamento mais recente.
    public Pedido pop() {
        if (estaVazia()) {
            return null;
        }

        Pedido pedidoRemovido = topo.pedido;
        topo = topo.proximo;

        return pedidoRemovido;
    }

    public void printStack() {
        if (estaVazia()) {
            System.out.println("Não há pedidos cancelados.");
            return;
        }

        NoPedido atual = topo;

        System.out.println("\n--- PEDIDOS CANCELADOS ---");
        System.out.println("(Do mais recente para o mais antigo)");

        while (atual != null) {
            System.out.println(atual.pedido);
            atual = atual.proximo;
        }
    }
}
