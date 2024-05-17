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
    private double sueldo;
    private static int contadorEmpleados;

    public Empleado(String codigo, char categoria, String nombreCompleto, String servicio, boolean turnicidad, double sueldo) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nombreCompleto = nombreCompleto;
        this.servicio = servicio;
        this.turnicidad = turnicidad;
        this.sueldo = sueldo;
        contadorEmpleados++;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public boolean isTurnicidad() {
        return turnicidad;
    }

    public void setTurnicidad(boolean turnicidad) {
        this.turnicidad = turnicidad;
    }

    public static int getContadorEmpleados() {
        return contadorEmpleados;
    }

    public static void setContadorEmpleados(int contadorEmpleados) {
        Empleado.contadorEmpleados = contadorEmpleados;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\t" + codigo + "\t" + nombreCompleto;
    }
}