package modelo;

public class Producto {
    private String nombre;
    private double precio;
    private boolean disponible;

    public Producto(String nombre, double precio, boolean disponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public boolean isDisponible() { return disponible; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return nombre + " - $" + precio + (disponible ? " [Disponible]" : " [No disponible]");
    }
}
