import java.util.ArrayList;
import java.util.HashMap;

/**
 * Empleado
 */
public class Empleado {
    private final String codigo;
    private char categoria;
    private String nombreCompleto;
    private String servicio;
    private boolean turnicidad;
    
    public Empleado(String codigo, char categoria, String nombreCompleto, String servicio, boolean turnicidad) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nombreCompleto = nombreCompleto;
        this.servicio = servicio;
        this.turnicidad = turnicidad;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return servicio + "\t" + codigo + "\t" + nombreCompleto;
    }

}