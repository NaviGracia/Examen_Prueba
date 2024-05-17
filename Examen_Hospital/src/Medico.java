/**
 * Medico
 */
public class Medico extends Empleado{
    private int numeroGuardiasMedico;

    private static int contadorMedico;

    public Medico(String codigo, char categoria, String nombreCompleto, String servicio, boolean turnicidad,
        double sueldo, int numeroGuardiasMedico) {
        super(codigo, categoria, nombreCompleto, servicio, turnicidad, sueldo);
        this.numeroGuardiasMedico = numeroGuardiasMedico;
    }

    public int getNumeroGuardiasMedico() {
        return numeroGuardiasMedico;
    }

    public void setNumeroGuardiasMedico(int numeroGuardiasMedico) {
        this.numeroGuardiasMedico = numeroGuardiasMedico;
    }

    public static int getContadorMedico() {
        return contadorMedico;
    }

    public static void setContadorMedico(int contadorMedico) {
        Medico.contadorMedico = contadorMedico;
    }


}