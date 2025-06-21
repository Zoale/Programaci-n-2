import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Representa un pedido realizado por un cliente.
 * Implementa Comparable para ser usado en una Cola con Prioridad.
 * La comparación se realiza por el campo 'prioridad'.
 */
public class Pedido implements Comparable<Pedido> {

    // Un contador estático para generar IDs únicos para cada pedido.
    private static final AtomicInteger contadorId = new AtomicInteger(0);

    private final int id;
    private final Date fecha;
    private final int prioridad; // ej: 1 (más alta) a 5 (más baja)
    private String estado; // ej: "En cola", "Procesado", "Entregado"
    private LinkedList<Plato> platos; // Lista enlazada de platos seleccionados

    public Pedido(int prioridad) {
        this.id = contadorId.incrementAndGet();
        this.fecha = new Date(); // Captura la fecha y hora actual
        this.prioridad = prioridad;
        this.estado = "En cola";
        this.platos = new LinkedList<>();
    }

    public void agregarPlato(Plato plato) {
        this.platos.add(plato);
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LinkedList<Plato> getPlatos() {
        return platos;
    }

    /**
     * Método de comparación para la cola con prioridad.
     * Compara este pedido con otro, basado en el valor de prioridad.
     * Un valor de prioridad más bajo se considera más urgente.
     */
    @Override
    public int compareTo(Pedido otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " [Prioridad=" + prioridad + ", Fecha=" + fecha + ", Estado=" + estado + ", Platos=" + platos + "]";
    }
}