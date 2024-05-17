/**
 * Enfermeros
 */
public class Enfermeros extends Empleado{
    private static int contadorEnfermeros;
    
    public Enfermeros(String codigo, char categoria, String nombreCompleto, String servicio, boolean turnicidad,
        double sueldo) {
        super(codigo, categoria, nombreCompleto, servicio, turnicidad, sueldo);
        //TODO Auto-generated constructor stub
    }

    public static int getContadorEnfermeros() {
        return contadorEnfermeros;
    }

    public static void setContadorEnfermeros(int contadorEnfermeros) {
        Enfermeros.contadorEnfermeros = contadorEnfermeros;
    }
}