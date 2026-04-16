package pago;


public class PagoTarjeta implements MetodoPago {
    private String numeroTarjeta;
    private String titular;

    public PagoTarjeta(String numeroTarjeta, String titular) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println(" Procesando pago con tarjeta...");
        // Muestra solo los últimos 4 dígitos por seguridad
        System.out.println("   Tarjeta: ****" + numeroTarjeta.substring(Math.max(0, numeroTarjeta.length() - 4)));
        System.out.println("   Titular: " + titular);

        if (numeroTarjeta.length() >= 4) {
            System.out.println(" Pago con tarjeta aprobado");
            return true;
        } else {
            System.out.println("Tarjeta inválida");
            return false;
        }
    }

    @Override
    public String getNombreMetodo() {
        return "Tarjeta de crédito/débito";
    }
}