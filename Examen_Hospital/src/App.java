import java.util.ArrayList;
import java.util.HashMap;

public class App extends Entrada_Salida{
    //Colores para el texto
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    private static HashMap<String, Integer> sueldosBase = new HashMap<>();
    private static HashMap<String, Integer> suplementos = new HashMap<>();

    public static ArrayList<Empleado> empleados = new ArrayList<>();

    //Métodos para precargar los hashmap
    public static String precargaHashMaps(){
        sueldosBase.put("A", 2000);
        sueldosBase.put("B", 1800);
        sueldosBase.put("C", 1500);
        suplementos.put("Trasplantes", 15);
        suplementos.put("Cirugia", 10);
        suplementos.put("Quemados", 5);
        return "Precarga Completada";
    }

    public static int calcularSueldo(char categoria, ){
        return 1;
    }

    public static String generarCodigo(char categoria){
        String codigo = categoria + "";
        return codigo;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(ANSI_GREEN + precargaHashMaps() + ANSI_RESET);
        int eleccion;
        do {
            System.out.println(ANSI_RED + "Bienvenido al Sistema Gestor de Empleados." + ANSI_RESET
                + ANSI_CYAN + "\nMenú:" +  "\n1) Dar de Alta Empleado" + "\n2) Lista de Empleados" + "\n3) Empleados Activos" + "\n4) Empleados por Categoría" + 
                "\n5) Buscar Empleado" + "\n6) Dar de Baja Empleado" + "\n7) Ordenar Empleados" + "\n8) Modificar Guardias(Medicos)" + "\n9) Salir"
                + "\nIntroduzca el nº de la opción:");   
            eleccion =  devolverInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Tipo de Empleado:" + "\n1) Médic@: A" + "\n2) Enfermer@: B" + "\n3) Auxiliar: C");
                    char categoria = devolverChar();
                    if (categoria != 'A' || categoria != 'B' || categoria != 'C') {
                        System.out.println("Introduzca el nombre completo:");
                        String nombreCompleto = devolverString();
                        System.out.println("Introduzca el servicio:");
                        String servicio = devolverString();
                        System.out.println("Tiene turnicidad (true o false):");
                        boolean turnicidad = devolverBoolean();
                        switch (categoria) {
                            case 'A':
                                empleados.add(new Medico(generarCodigo(categoria), categoria, nombreCompleto, servicio, turnicidad, 0));
                                break;
                            case 'B':
                                empleados.add(new Enfermeros(generarCodigo(categoria), categoria, nombreCompleto, servicio, turnicidad));
                                break;
                            case 'C':
                                System.out.println("Discapacidad (true o false):");
                                boolean discapacidad =
                                break;
                        
                            default:
                                break;
                        }
                    }else{
                        System.out.println("Categoría Incorrecta");
                    }


                    break;
                case 2:
                    for (Empleado e : empleados) {
                        System.out.println(e.toString());
                    }
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;

                default:
                    System.out.println("Nº Incorrecto");
                    break;
            }
        } while (eleccion!=9);
        
        

    }
}
