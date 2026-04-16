package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un pedido dentro del sistema.
 * Se encarga de asociar a un Cliente con los Productos que desea adquirir,
 * aplicando validaciones básicas de estado (disponibilidad) antes de procesarlos.
 */
public class Pedido {
    private Cliente cliente;
    // Se utiliza la interfaz List con la implementación ArrayList
    // para manejar una estructura de datos dinámica.
    private List<Producto> productos;

    /**
     * Constructor principal de la clase Pedido.
     * Recibe únicamente al cliente. La lista de productos se inicializa vacía,
     * simulando el inicio de una nueva orden de compra.
     * * @param cliente El cliente responsable de este pedido.
     */
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    // --- Métodos de la lógica del negocio ---

    /**
     * Intenta agregar un producto a la lista del pedido.
     * Incluye una regla de validación para garantizar que no se cobren artículos agotados.
     * * @param producto El producto que se desea insertar en la lista.
     */
    public void agregarProducto(Producto producto) {
        // Se evalúa la disponibilidad del producto a través de su método getter booleano
        if (producto.isDisponible()) {
            productos.add(producto);
        } else {
            // Si retorna false, se rechaza la inserción y se notifica el problema
            System.out.println("Aviso: El producto '" + producto.getNombre() + "' no se pudo agregar porque no se encuentra disponible.");
        }
    }

    /**
     * Remueve un producto específico de la lista actual.
     * * @param producto El producto a eliminar.
     */
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    /**
     * Calcula el monto final del pedido sumando el costo de todos los productos agregados.
     * * @return El valor total calculado de la compra.
     */
    public double calcularTotal() {
        double total = 0.0; // Variable acumuladora

        // Se recorre la colección de productos para extraer y sumar sus precios
        for (Producto p : productos) {
            total += p.getPrecio();
        }

        return total;
    }

    // --- Getters y Setters ---

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<Producto> getProductos() { return productos; }

    public void setProductos(List<Producto> productos) { this.productos = productos; }

    // --- Métodos sobrescritos ---

    /**
     * Genera un reporte en texto con la información completa del pedido.
     * Se implementa StringBuilder para optimizar el manejo de memoria al concatenar cadenas.
     * * @return Una cadena formateada con los datos del cliente, el listado de productos y el total.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Detalle del Pedido ===\n");
        sb.append(cliente.toString()).append("\n");
        sb.append("Lista de Productos:\n");

        if (productos.isEmpty()) {
            sb.append("  (El pedido aún no tiene productos)\n");
        } else {
            for (Producto p : productos) {
                sb.append("  > ").append(p.toString()).append("\n");
            }
        }
        sb.append("--------------------------\n");
        sb.append("Total a pagar: $").append(calcularTotal()).append("\n");

        return sb.toString();
    }
}