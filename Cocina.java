import java.util.PriorityQueue;

/**
 * Simula la cocina del restaurante, gestionando los pedidos activos
 * mediante una cola con prioridad.
 */
public class Cocina {
    private PriorityQueue<Pedido> pedidosActivos;

    public Cocina() {
        this.pedidosActivos = new PriorityQueue<>();
    }

    /**
     * Recibe un nuevo pedido y lo agrega a la cola de procesamiento.
     */
    public void recibirPedido(Pedido pedido) {
        pedidosActivos.offer(pedido);
        System.out.println(">> Cocina: Pedido #" + pedido.getId() + " recibido y en espera.");
    }

    /**
     * Procesa el siguiente pedido según la prioridad.
     * Lo extrae de la cola y lo retorna para ser archivado.
     */
    public Pedido procesarSiguientePedido() {
        Pedido pedidoAProcesar = pedidosActivos.poll(); // Extrae el de mayor prioridad
        if (pedidoAProcesar != null) {
            pedidoAProcesar.setEstado("Entregado");
            System.out.println(">> Cocina: Procesando y entregando Pedido #" + pedidoAProcesar.getId());
            return pedidoAProcesar;
        } else {
            System.out.println(">> Cocina: No hay pedidos pendientes.");
            return null;
        }
    }

    public boolean hayPedidosPendientes() {
        return !pedidosActivos.isEmpty();
    }
}