/**
 * Medico
 */
public class Medico extends Empleado{
    private int numeroGuardiasMedico;

    public Medico(String codigo, char categoria, String nombreCompleto, String servicio, boolean turnicidad,
            int numeroTotalMedicos) {
        super(codigo, categoria, nombreCompleto, servicio, turnicidad);
        this.numeroGuardiasMedico = numeroGuardiasMedico;
    }

    public static int totalMedicos(){
        return 0;
    }
}