package util;

import modelo.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase estática para generar reportes de ventas
 */
public final class ReporteVentas {

    private static List<Pedido> pedidosHistorial = new ArrayList<>();
    private static double totalVentasAcumulado = 0;

    // Constructor privado para evitar instanciación
    private ReporteVentas() {}

    /**
     * Registra un pedido completado en el historial
     */
    public static void registrarVenta(Pedido pedido) {
        if (pedido.isPagado()) {
            pedidosHistorial.add(pedido);
            totalVentasAcumulado += pedido.calcularTotal();
        }
    }

    /**
     * Obtiene el total de ventas acumulado
     */
    public static double getTotalVentas() {
        return totalVentasAcumulado;
    }

    /**
     * Obtiene la cantidad de pedidos realizados
     */
    public static int getCantidadPedidos() {
        return pedidosHistorial.size();
    }

    /**
     * Genera reporte completo
     */
    public static void generarReporte() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║       📊 REPORTE DE VENTAS        ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ Total ventas: " + String.format("%-22s", Utilidades.formatearMoneda(totalVentasAcumulado)) + "║");
        System.out.println("║ Pedidos realizados: " + String.format("%-14d", pedidosHistorial.size()) + "║");
        System.out.println("╚════════════════════════════════════╝");
    }

    public static void limpiarHistorial() {
        pedidosHistorial.clear();
        totalVentasAcumulado = 0;
    }
}
