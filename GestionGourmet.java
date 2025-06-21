import java.util.Scanner;

public class GestionGourmet {

    public static void main(String[] args) {
        // 1. CREACIÓN DE LOS OBJETOS PRINCIPALES
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Cocina cocina = new Cocina();
        ArbolEntregas historial = new ArbolEntregas();

        // 2. CARGA INICIAL DE DATOS (Ejemplo)
        System.out.println("Cargando menú inicial...");
        // Cargar platos en el menú
        // --- Entradas ---
        menu.agregarPlato(new Plato("Ensalada César", 18.00, "Entradas"));
        menu.agregarPlato(new Plato("Provoleta con Oregano", 15.50, "Entradas"));
        menu.agregarPlato(new Plato("Empanada de Carne", 5.00, "Entradas"));

        // --- Platos Principales ---
        menu.agregarPlato(new Plato("Milanesa a la Napolitana", 28.50, "Principales"));
        menu.agregarPlato(new Plato("Lomo a la Pimienta", 35.00, "Principales"));
        menu.agregarPlato(new Plato("Ravioles con Salsa Rosa", 24.00, "Principales"));
        menu.agregarPlato(new Plato("Pizza Muzzarella", 22.00, "Principales"));

        // --- Postres ---
        menu.agregarPlato(new Plato("Flan con Dulce de Leche", 12.00, "Postres"));
        menu.agregarPlato(new Plato("Tiramisú", 14.50, "Postres"));
        menu.agregarPlato(new Plato("Copa de Helado (2 sabores)", 11.00, "Postres"));

        // --- Bebidas ---
        menu.agregarPlato(new Plato("Agua sin Gas", 6.00, "Bebidas"));
        menu.agregarPlato(new Plato("Gaseosa Línea Coca-Cola", 7.50, "Bebidas"));
        menu.agregarPlato(new Plato("Copa de Vino Malbec", 10.00, "Bebidas"));

        System.out.println("Menú cargado exitosamente.");

        // 3. BUCLE PRINCIPAL DE LA APLICACIÓN
        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== SISTEMA DE GESTIÓN GOURMET =====");
            System.out.println("1. Mostrar Menú");
            System.out.println("2. Crear Nuevo Pedido");
            System.out.println("3. Procesar Siguiente Pedido de la Cocina");
            System.out.println("4. Ver Historial de Pedidos Entregados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Lógica para mostrar el menú
                    menu.mostrarMenu();
                    break;
                case 2:
                    // Lógica para crear un pedido
                    // Aquí se pediría al usuario la prioridad y los platos
                    System.out.print("Ingrese la prioridad del pedido (1=Alta, 5=Baja): ");
                    int prioridad = scanner.nextInt();
                    Pedido nuevoPedido = new Pedido(prioridad);

                    // Simulación de agregar platos...
                    nuevoPedido.agregarPlato(menu.getPlatoPorNombre("Milanesa a la Napolitana"));

                    cocina.recibirPedido(nuevoPedido);
                    break;
                case 3:
                    // Lógica para procesar un pedido
                    Pedido pedidoProcesado = cocina.procesarSiguientePedido();
                    if (pedidoProcesado != null) {
                        historial.insertar(pedidoProcesado);
                    }
                    break;
                case 4:
                    // Lógica para mostrar el historial
                    historial.mostrarHistorialEnOrden();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
