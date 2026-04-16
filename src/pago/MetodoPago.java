package pago;


public interface MetodoPago {
    /**
     * Procesa el pago del monto especificado
     * @param monto Cantidad a pagar
     * @return true si el pago fue exitoso
     */
    boolean procesarPago(double monto);

    String getNombreMetodo();
}