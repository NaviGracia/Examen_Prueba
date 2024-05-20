import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class App extends Entrada_Salida{
    //Colores para el texto
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    private static HashMap<Character, Integer> sueldosBase = new HashMap<>();
    private static HashMap<String, Integer> suplementos = new HashMap<>();

    public static ArrayList<Empleado> empleados = new ArrayList<>();

    public static int siguienteCodigoMedico = 00000;
    public static int siguienteCodigoEnfermero = 00000;
    public static int siguienteCodigoAuxiliar = 00000;

    //Métodos para precargar los hashmap
    public static String precargaHashMaps(){
        sueldosBase.put('A', 2000);
        sueldosBase.put('B', 1800);
        sueldosBase.put('C', 1500);
        suplementos.put("Trasplantes", 15);
        suplementos.put("Cirugia", 10);
        suplementos.put("Quemados", 5);
        return "Precarga Completada";
    }

    public static double calcularSueldo(int guardiasMedico, char categoria, boolean turnicidad, boolean discapacidad){
        double salario = sueldosBase.get(categoria);
        if (turnicidad == true) {
            salario+=(salario*5)/100;
        }
        switch (categoria) {
            case 'A':      
                salario+= guardiasMedico * 30;       
                break;
            case 'C':
            if (turnicidad == true) {
                salario+=(salario*3)/100;
            }
        }
        return salario;
    }

    public static Empleado generarEmpleado(char categoria, String nombreCompleto, String servicio, boolean turnicidad){
        switch (categoria) {
            case 'A':
                System.out.println("Nº de Guardias Real:");
                int numeroGuardias = devolverInt();
                return new Medico(generarCodigo(categoria), categoria, nombreCompleto, servicio, turnicidad, calcularSueldo(categoria, categoria, turnicidad, turnicidad), 0);
            case 'B':
                return new Enfermeros(generarCodigo(categoria), categoria, nombreCompleto, servicio, turnicidad, sueldosBase.get(categoria));
            default:
                System.out.println("Discapacidad (true o false):");
                boolean discapacidad = devolverBoolean();
                return new Auxiliares(generarCodigo(categoria), categoria, nombreCompleto, servicio, turnicidad, sueldosBase.get(categoria), discapacidad);
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

    //Controlador para que no muestre directamente 200 empleados, qye vaya de 7 en 7 mostrando
    public static String controladorObjetos(){
        System.out.println(ANSI_GREEN + "Presione Enter para continuar." + ANSI_RESET);
        return devolverString();
    }

    public static void listarEmpleados(){
        System.out.println("Lista Empleados: ");
        int controladorCatalogo = 0;
        int posicion = 0;
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
        empleados.add(new Enfermeros(generarCodigo('B'), 'B', "Mayra", "Oftalmología", false, calcularSueldo(0, 'B', false, false)));
        empleados.add(new Auxiliares(generarCodigo('C'), 'C', "Yoana", "Dentista", true, calcularSueldo(0, 'C', true, false), false));
        empleados.add(new Medico("A100000", 'A', "Ivan", "Dermatología", false, calcularSueldo(2, 'A', true, false), 0));

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
                        empleados.add(generarEmpleado(categoria, nombreCompleto, servicio, turnicidad));   
                    }else{
                        System.out.println("Categoría Incorrecta");
                    }
                    break;
                case 2:
                    listarEmpleados();
                    controladorObjetos();
                    break;
                case 3:
                    System.out.println("Nº de Empleados: " + Empleado.getContadorEmpleados());
                    controladorObjetos();
                    break;
                case 4:
                    System.out.println("Nº de Médic@s: " + Medico.getContadorMedico());
                    System.out.println("Nº de Enfermer@s: " + Enfermeros.getContadorEnfermeros());
                    System.out.println("Nº de Auxiliares: " + Auxiliares.getcontadorAuxiliares());
                    controladorObjetos();
                    break;
                case 5:
                    System.out.println("Introduzca el código del empleado:");
                    String empleadoBuscar = devolverString();
                    int posicion = 0;
                    boolean encontrado = false;
                    for (Empleado e : empleados) {
                        posicion++;
                        if (e.getCodigo().equalsIgnoreCase(empleadoBuscar)) {
                            System.out.println(posicion + " " + e.toString() + "\n" + averiguarCategoria(e.getCategoria()));
                            encontrado = true;
                        }
                    }
                    if (encontrado==false) {
                        System.out.println("No hay registrado ningún empleado con el código introducido.");
                    }
                    controladorObjetos();
                    break;
                case 6:
                    listarEmpleados();
                    System.out.println("Introduzca la posición del empleado a eliminar:");
                    int eliminarEmpleado=devolverInt();
                    if (eliminarEmpleado >= 0 && eliminarEmpleado < empleados.size()) {
                        System.out.println(averiguarCategoria(empleados.get(eliminarEmpleado).getCategoria()) + " eliminado.");
                        empleados.remove(eliminarEmpleado);
                    }else{
                        System.out.println("Posición Incorrecta.");
                    }
                    break;
                case 7:
                    Comparator<Empleado> comparadorCodigo = Comparator.comparing(Empleado::getCodigo);
                    listarEmpleados();
                    break;
                case 8:
                    System.out.println("Lista Empleados");
                    int controladorCatalogo = 0;
                    int posicionEmpleados = 0;
                    for (Empleado e : empleados) {
                        if (e.getCategoria()=='A') {
                            if (controladorCatalogo == 6) {
                                System.out.println(posicionEmpleados + e.toString());
                                posicionEmpleados++;
                                controladorObjetos();
                                controladorCatalogo = 0;
                            }else{
                                controladorCatalogo++;
                            }
                        } else{
                            posicionEmpleados++;
                        }
                    }
                    System.out.println("Introduzca la posición del médic@");
                    int posicionMedico = devolverInt();
                    if (posicionMedico >= 0 && posicionMedico < empleados.size()) {
                        System.out.println("Introduzca el nuevo nº de guardias:");
                        int nuevasGuardias = devolverInt();
                        Medico medicoReemplazado = new Medico(empleados.get(posicionMedico).getCodigo(), empleados.get(posicionMedico).getCategoria(), empleados.get(posicionMedico).getNombreCompleto(), empleados.get(posicionMedico).getServicio(), empleados.get(posicionMedico).isTurnicidad(), calcularSueldo(nuevasGuardias, empleados.get(posicionMedico).getCategoria(), empleados.get(posicionMedico).isTurnicidad(), empleados.get), nuevasGuardias);
                        empleados.set(posicionMedico, medicoReemplazado);
                    }else{
                        System.out.println("Posición Incorrecta.");
                    }
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
