/**
 * Auxiliares
 */
public class Auxiliares extends Empleado{
    private boolean discapacidadAuxiliares;

    private static int contadorAuxiliares;

    public Auxiliares(String codigo, char categoria, String nombreCompleto, String servicio, boolean turnicidad, double sueldo, boolean discapacidadAuxiliares) {
        super(codigo, categoria, nombreCompleto, servicio, turnicidad, sueldo);
        this.discapacidadAuxiliares = discapacidadAuxiliares;
    }

    public static int getcontadorAuxiliares() {
        return contadorAuxiliares;
    }

    public static void setcontadorAuxiliares(int contadorAuxiliares) {
        Auxiliares.contadorAuxiliares = contadorAuxiliares;
    }


}