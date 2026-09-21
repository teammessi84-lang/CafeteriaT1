import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un cliente de la cafetería y administra
 * la colección de pedidos que ha realizado.
 * Responsabilidad única: mantener sus datos válidos y
 * coordinar operaciones sobre su lista de pedidos.
 */
public class Cliente {

    private String codigo;
    private String nombreCompleto;
    private String correoElectronico;
    private List<Pedido> pedidos;

    // Constructor por defecto
    public Cliente() {
        this.codigo = "";
        this.nombreCompleto = "";
        this.correoElectronico = "";
        this.pedidos = new ArrayList<>();
    }

    // Constructor parametrizado
    public Cliente(String codigo, String nombreCompleto, String correoElectronico) {
        setCodigo(codigo);
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.pedidos = new ArrayList<>();
    }

    // ---------- Métodos de negocio ----------

    /**
     * Agrega un pedido al cliente, validando que el código
     * de pedido no esté duplicado dentro de este cliente.
     */
    public void agregarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        if (buscarPedidoPorCodigo(pedido.getCodigo()) != null) {
            throw new IllegalArgumentException(
                "Ya existe un pedido con el código '" + pedido.getCodigo() + "' para este cliente.");
        }
        pedidos.add(pedido);
    }

    /** Busca un pedido por su código. Retorna null si no existe. */
    public Pedido buscarPedidoPorCodigo(String codigo) {
        for (Pedido p : pedidos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    /** Suma el importe de todos los pedidos del cliente. */
    public double calcularImporteTotal() {
        double total = 0.0;
        for (Pedido p : pedidos) {
            total += p.calcularImporte();
        }
        return total;
    }

    /** Muestra en consola los datos del cliente y el detalle de sus pedidos. */
    public void mostrarDatos() {
        System.out.println("Cliente: " + codigo + " - " + nombreCompleto + " (" + correoElectronico + ")");
        if (pedidos.isEmpty()) {
            System.out.println("  Sin pedidos registrados.");
        } else {
            for (Pedido p : pedidos) {
                System.out.println("  " + p);
            }
        }
        System.out.printf("  Importe total: %.2f%n", calcularImporteTotal());
    }

    // ---------- Getters y Setters ----------

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del cliente no puede estar vacío.");
        }
        this.codigo = codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /** Retorna una copia de la lista para no exponer la referencia interna. */
    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }
}
