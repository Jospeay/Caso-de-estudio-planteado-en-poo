package pago;

public class PagoEfectivo implements MetodoPago {
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("💵 Procesando pago en efectivo: $" + monto);
        System.out.println("✅ Pago en efectivo aceptado");
        return true;
    }

    @Override
    public String getNombreMetodo() {
        return "Efectivo";
    }
}
