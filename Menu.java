import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Gestiona el menú del restaurante, organizando los platos por categorías.
 * Utiliza un Map a modo de Diccionario para un acceso rápido.
 */
public class Menu {
    private Map<String, List<Plato>> categorias;

    public Menu() {
        this.categorias = new HashMap<>();
    }

    /**
     * Agrega un plato al menú en su categoría correspondiente.
     * Si la categoría no existe, se crea.
     */
    public void agregarPlato(Plato plato) {
        String categoria = plato.getCategoria();
        // Si la categoría no está en el mapa, la añade con una nueva lista.
        this.categorias.putIfAbsent(categoria, new ArrayList<>());
        // Añade el plato a la lista de su categoría.
        this.categorias.get(categoria).add(plato);
    }

    /**
     * Muestra el menú completo al usuario, organizado por categorías.
     */
    public void mostrarMenu() {
        System.out.println("----- MENÚ GOURMET -----");
        for (Map.Entry<String, List<Plato>> entry : categorias.entrySet()) {
            System.out.println("\n--- " + entry.getKey().toUpperCase() + " ---");
            for (Plato plato : entry.getValue()) {
                System.out.println("  - " + plato);
            }
        }
        System.out.println("------------------------");
    }

    // Método auxiliar para obtener un plato (simulación)
    public Plato getPlatoPorNombre(String nombre) {
        for (List<Plato> listaPlatos : categorias.values()) {
            for (Plato plato : listaPlatos) {
                if (plato.getNombre().equalsIgnoreCase(nombre)) {
                    return plato;
                }
            }
        }
        return null;
    }
}