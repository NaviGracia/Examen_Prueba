/**
 * Auxiliares
 */
public class Auxiliares extends Empleado{
    private boolean discapacidadAuxiliares;

    public Auxiliares(String codigo, char categoria, String nombreCompleto, String servicio, boolean turnicidad,
            boolean discapacidadAuxiliares) {
        super(codigo, categoria, nombreCompleto, servicio, turnicidad);
        this.discapacidadAuxiliares = discapacidadAuxiliares;
    }

    public static int totalAuxiliares(){
        return 0;
    }
}