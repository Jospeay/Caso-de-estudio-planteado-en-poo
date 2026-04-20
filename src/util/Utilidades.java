package util;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Clase estática con utilidades compartidas
 */
public final class Utilidades {

    private static final NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
    private static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Constructor privado
    private Utilidades() {}

    /**
     * Formatea un valor como moneda colombiana
     */
    public static String formatearMoneda(double valor) {
        return formatoMoneda.format(valor);
    }

    /**
     * Obtiene fecha y hora actual formateada
     */
    public static String getFechaActual() {
        return LocalDateTime.now().format(formatoFecha);
    }

    /**
     * Valida que un string no sea nulo ni vacío
     */
    public static boolean validarString(String valor) {
        return valor != null && !valor.trim().isEmpty();
    }

    /**
     * Valida que un número sea positivo
     */
    public static boolean validarPositivo(double valor) {
        return valor > 0;
    }
}
