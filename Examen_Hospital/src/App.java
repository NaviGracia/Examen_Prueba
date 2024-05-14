import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class App extends Entrada_Salida{
    //Colores para el texto
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    private static HashMap<String, Integer> sueldosBase = new HashMap<>();
    private static HashMap<String, Integer> suplementos = new HashMap<>();

    public static ArrayList<Empleado> empleados = new ArrayList<>();

    public static int siguienteCodigoMedico = 00000;
    public static int siguienteCodigoEnfermero = 00000;
    public static int siguienteCodigoAuxiliar = 00000;

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

    public static int calcularSueldo(char categoria ){
        return 1;
    }

    public static Empleado generarEmpleado(char categoria, String nombreCompleto, String servicio, boolean turnicidad){
        switch (categoria) {
            case 'A':
                return new Medico(generarCodigo(categoria), categoria, nombreCompleto, servicio, turnicidad, 0);
            case 'B':
                return new Enfermeros(generarCodigo(categoria), categoria, nombreCompleto, servicio, turnicidad);
            default:
                System.out.println("Discapacidad (true o false):");
                boolean discapacidad = devolverBoolean();
                return new Auxiliares(generarCodigo(categoria), categoria, nombreCompleto, servicio, turnicidad, discapacidad);
        }
    }

    public static String generarCodigo(char categoria){
        String codigo = "";
        switch (categoria) {
            case 'A':
                codigo = categoria + "1" + siguienteCodigoMedico;
                siguienteCodigoMedico++;
                break;
            case 'B':
                codigo = categoria + "1" + siguienteCodigoEnfermero;
                siguienteCodigoEnfermero++;
                break;
            case 'C':
                codigo = categoria + "1" + siguienteCodigoAuxiliar;
                siguienteCodigoAuxiliar++;
                break;
        }
        return codigo;
    }

    public static int mostrarNumeroEmpleadosCategoria(char categoria){
        int numeroEmpleados = 0;
        for (Empleado e : empleados) {
            if (e.getCategoria()==categoria) {
                numeroEmpleados++;
            }
        }
        return numeroEmpleados;
    }

    //Controlador para que no muestre directamente 200 empleados, qye vaya de 7 en 7 mostrando
    public static String controladorObjetos(){
        System.out.println(ANSI_GREEN + "Presione Enter para continuar." + ANSI_RESET);
        return devolverString();
    }

    public static void listarEmpleados(){
        int controladorCatalogo = 0;
        int posicion = 1;
        for (Empleado e : empleados) {
            if (controladorCatalogo == 6) {
                System.out.println(posicion + e.toString());
                posicion++;
                controladorObjetos();
                controladorCatalogo = 0;
            } else{
                System.out.println(posicion + e.toString());
                posicion++;
                controladorCatalogo++;
            }
        }
    }

    public static String averiguarCategoria(char categoria){
        String categoriaAveriguada = "";
        switch (categoria) {
            case 'A':
                categoriaAveriguada = "Médic@";
                break;
            case 'B':
                categoriaAveriguada = "Enfermer@";
                break;
            case 'C':
                categoriaAveriguada = "Auxiliar";
                break;
        }
        return categoriaAveriguada;
    }
    public static void main(String[] args) throws Exception {
        //Anti-Hardcoding
        empleados.add(new Medico("A100000", 'A', "Ivan", "Dermatología", true, 0));
        empleados.add(new Enfermeros("B200000", 'B', "Daniela", "Oftalmología", false));
        empleados.add(new Auxiliares("C300000", 'C', "Yoana", "Dermatología", true, false));

        System.out.println(ANSI_GREEN + precargaHashMaps() + ANSI_RESET);
        int eleccion;
        do {
            System.out.println(ANSI_RED + "Bienvenido al Sistema Gestor de Empleados." + ANSI_RESET
                + ANSI_CYAN + "\nMenú:" +  "\n1) Dar de Alta Empleado" + "\n2) Lista de Empleados" + "\n3) Empleados Activos" + "\n4) Empleados por Categoría" + 
                "\n5) Buscar Empleado" + "\n6) Dar de Baja Empleado" + "\n7) Ordenar Empleados" + "\n8) Modificar Guardias(Medicos)" + "\n9) Salir"
                + "\nIntroduzca el nº de la opción:" + ANSI_RESET);   
            eleccion =  devolverInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Tipo de Empleado:" + "\n-Médic@: A" + "\n-Enfermer@: B" + "\n -Auxiliar: C" + "\n Introduzca el caracter:");
                    char categoria = devolverChar();
                    if (categoria != 'A' || categoria != 'B' || categoria != 'C') {
                        System.out.println("Introduzca el nombre completo:");
                        String nombreCompleto = devolverString();
                        System.out.println("Introduzca el servicio:");
                        String servicio = devolverString();
                        System.out.println("Tiene turnicidad (true o false):");
                        boolean turnicidad = devolverBoolean();
                        if (categoria != 'A' || categoria != 'B' || categoria != 'C') {
                            empleados.add(generarEmpleado(categoria, nombreCompleto, servicio, turnicidad));   
                        }else{
                            System.out.println("Nº Incorrecto");
                        }
                    }else{
                        System.out.println("Categoría Incorrecta");
                    }
                    break;
                case 2:
                    System.out.println("Lista Empleados: ");
                    listarEmpleados();
                    controladorObjetos();
                    break;
                case 3:
                    System.out.println("Nº de Empleados: " + empleados.size());
                    controladorObjetos();
                    break;
                case 4:
                    System.out.println("Nº de Médic@s: " + mostrarNumeroEmpleadosCategoria('A'));
                    System.out.println("Nº de Enfermer@s: " + mostrarNumeroEmpleadosCategoria('B'));
                    System.out.println("Nº de Auxiliares: " + mostrarNumeroEmpleadosCategoria('C'));
                    controladorObjetos();
                    break;
                case 5:
                    System.out.println("Introduzca el código del empleado:");
                    String empleadoBuscar = devolverString();
                    Iterator<Empleado> iterador = empleados.iterator();
                    int posicion = 0;
                    boolean encontrado = false;
                    while (iterador.hasNext()) {  //Aqui estamos, arreglando el bucle
                        posicion++;
                        if (iterador.next().getCodigo().equalsIgnoreCase(empleadoBuscar)) {
                            System.out.println(posicion + " " + iterador.next().toString() + averiguarCategoria(iterador.next().getCategoria()));
                            encontrado = true;
                        }
                    }
                    if (encontrado==false) {
                        System.out.println("No hay registrado ningún empleado con el código introducido.");
                    }
                    controladorObjetos();
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("Saliendo del Sistema Gestor de Empleados.");
                    break;
                default:
                    System.out.println("Nº Incorrecto");
                    break;
            }
        } while (eleccion!=9);
        
        

    }
}
