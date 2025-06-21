/**
 * Nodo para el Árbol Binario de Búsqueda 'ArbolEntregas'.
 * Cada nodo almacena un pedido completo.
 */
class NodoPedido {
    Pedido pedido;
    NodoPedido izquierdo;
    NodoPedido derecho;

    public NodoPedido(Pedido pedido) {
        this.pedido = pedido;
        this.izquierdo = null;
        this.derecho = null;
    }
}
