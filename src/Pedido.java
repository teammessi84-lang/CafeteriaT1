/**
 * Representa un pedido realizado por un cliente de la cafetería.
 * Responsabilidad única: mantener sus propios datos consistentes
 * (precio y cantidad > 0) y saber calcular su importe.
 */
public class Pedido {

    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private int cantidad;
    private EstadoPedido estado;

    // Constructor por defecto
    public Pedido() {
        this.codigo = "";
        this.descripcion = "";
        this.precioUnitario = 0.0;
        this.cantidad = 0;
        this.estado = EstadoPedido.PENDIENTE;
    }

    // Constructor parametrizado
    public Pedido(String codigo, String descripcion, double precioUnitario, int cantidad) {
        setCodigo(codigo);
        this.descripcion = descripcion;
        setPrecioUnitario(precioUnitario);
        setCantidad(cantidad);
        this.estado = EstadoPedido.PENDIENTE; // todo pedido nuevo nace PENDIENTE
    }

    // ---------- Métodos de negocio ----------

    /** Calcula el importe del pedido: precio unitario x cantidad. */
    public double calcularImporte() {
        return precioUnitario * cantidad;
    }

    /** Cambia el estado del pedido (PENDIENTE, ATENDIDO o CANCELADO). */
    public void cambiarEstado(EstadoPedido nuevoEstado) {
        if (nuevoEstado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
        this.estado = nuevoEstado;
    }

    // ---------- Getters y Setters ----------

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del pedido no puede estar vacío.");
        }
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario <= 0) {
            throw new IllegalArgumentException("El precio unitario debe ser mayor que cero.");
        }
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        this.cantidad = cantidad;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return String.format(
            "Pedido[codigo=%s, descripcion=%s, precioUnitario=%.2f, cantidad=%d, estado=%s, importe=%.2f]",
            codigo, descripcion, precioUnitario, cantidad, estado, calcularImporte()
        );
    }
}
