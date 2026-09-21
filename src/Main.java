/**
 * Clase de demostración del sistema de gestión de pedidos
 * de la cafetería universitaria.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== 1. Registro de clientes ===");
        Cliente cliente1 = new Cliente("C001", "Ana Torres", "ana.torres@uni.edu");
        Cliente cliente2 = new Cliente("C002", "Luis Ramírez", "luis.ramirez@uni.edu");
        cliente1.mostrarDatos();
        cliente2.mostrarDatos();

        System.out.println("\n=== 2. Agregar pedidos a un cliente ===");
        Pedido p1 = new Pedido("P001", "Capuchino grande", 8.50, 2);
        Pedido p2 = new Pedido("P002", "Sándwich de pollo", 12.00, 1);
        Pedido p3 = new Pedido("P003", "Té helado", 6.00, 3);

        cliente1.agregarPedido(p1);
        cliente1.agregarPedido(p2);
        cliente1.agregarPedido(p3);

        Pedido p4 = new Pedido("P004", "Espresso", 5.00, 1);
        cliente2.agregarPedido(p4);

        System.out.println("Pedidos agregados correctamente.");

        System.out.println("\n=== 3. Mostrar datos del cliente y sus pedidos ===");
        cliente1.mostrarDatos();

        System.out.println("\n=== 4. Calcular importe de un pedido específico ===");
        System.out.printf("Importe de %s: %.2f%n", p1.getCodigo(), p1.calcularImporte());

        System.out.println("\n=== 5. Calcular importe total de un cliente ===");
        System.out.printf("Importe total de %s: %.2f%n", cliente1.getCodigo(), cliente1.calcularImporteTotal());

        System.out.println("\n=== 6. Buscar un pedido por código ===");
        Pedido encontrado = cliente1.buscarPedidoPorCodigo("P002");
        System.out.println(encontrado != null ? "Encontrado: " + encontrado : "No encontrado");

        Pedido noExiste = cliente1.buscarPedidoPorCodigo("P999");
        System.out.println("Búsqueda de código inexistente (P999): " + (noExiste == null ? "No encontrado" : noExiste));

        System.out.println("\n=== 7. Cambiar el estado de un pedido ===");
        System.out.println("Estado antes: " + p1.getEstado());
        p1.cambiarEstado(EstadoPedido.ATENDIDO);
        System.out.println("Estado después: " + p1.getEstado());

        System.out.println("\n=== 8. Validaciones ===");

        // Código de cliente vacío
        try {
            new Cliente("", "Sin código", "correo@uni.edu");
        } catch (IllegalArgumentException e) {
            System.out.println("Validación OK -> " + e.getMessage());
        }

        // Precio inválido
        try {
            new Pedido("P005", "Jugo natural", -3.0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Validación OK -> " + e.getMessage());
        }

        // Cantidad inválida
        try {
            new Pedido("P006", "Croissant", 4.5, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Validación OK -> " + e.getMessage());
        }

        // Código de pedido duplicado dentro del mismo cliente
        try {
            Pedido duplicado = new Pedido("P001", "Capuchino grande (repetido)", 8.50, 1);
            cliente1.agregarPedido(duplicado);
        } catch (IllegalArgumentException e) {
            System.out.println("Validación OK -> " + e.getMessage());
        }

        System.out.println("\n=== Fin de la demostración ===");
    }
}
