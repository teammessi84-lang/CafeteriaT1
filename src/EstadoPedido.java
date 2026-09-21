/**
 * Representa los posibles estados de un pedido.
 * Al ser un enum, Java garantiza que un Pedido solo pueda tener
 * uno de estos tres valores (restricción del negocio).
 */
public enum EstadoPedido {
    PENDIENTE,
    ATENDIDO,
    CANCELADO
}
