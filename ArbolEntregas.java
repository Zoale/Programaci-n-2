import java.util.Date;

/**
 * Árbol Binario de Búsqueda para almacenar y buscar pedidos entregados.
 * La clave de ordenación y búsqueda es la fecha del pedido.
 */
public class ArbolEntregas {
    private NodoPedido raiz;

    public ArbolEntregas() {
        this.raiz = null;
    }

    // --- Inserción ---
    public void insertar(Pedido pedido) {
        this.raiz = insertarRecursivo(this.raiz, pedido);
    }

    private NodoPedido insertarRecursivo(NodoPedido actual, Pedido pedido) {
        if (actual == null) {
            return new NodoPedido(pedido);
        }

        // Comparamos por fecha para decidir la ruta de inserción
        if (pedido.getFecha().before(actual.pedido.getFecha())) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, pedido);
        } else if (pedido.getFecha().after(actual.pedido.getFecha())) {
            actual.derecho = insertarRecursivo(actual.derecho, pedido);
        }

        return actual;
    }

    // --- Búsqueda ---
    public Pedido buscar(Date fecha) { // Búsqueda de pedidos por fecha
        NodoPedido resultado = buscarRecursivo(this.raiz, fecha);
        return (resultado != null) ? resultado.pedido : null;
    }

    private NodoPedido buscarRecursivo(NodoPedido actual, Date fecha) {
        if (actual == null || actual.pedido.getFecha().equals(fecha)) {
            return actual;
        }

        if (fecha.before(actual.pedido.getFecha())) {
            return buscarRecursivo(actual.izquierdo, fecha);
        } else {
            return buscarRecursivo(actual.derecho, fecha);
        }
    }

    // --- Recorrido (para mostrar) ---
    public void mostrarHistorialEnOrden() {
        System.out.println("\n--- HISTORIAL DE PEDIDOS ENTREGADOS (ordenados por fecha) ---");
        recorridoEnOrden(this.raiz);
        System.out.println("---------------------------------------------------------");
    }

    private void recorridoEnOrden(NodoPedido nodo) {
        if (nodo != null) {
            recorridoEnOrden(nodo.izquierdo);
            System.out.println("  - " + nodo.pedido);
            recorridoEnOrden(nodo.derecho);
        }
    }
}