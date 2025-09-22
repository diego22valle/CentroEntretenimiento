/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.Empleado;
import Util.Lectura;
import java.util.ArrayList;
/**
 *
 * @author Alima
 */

//Organizar la sobreescritura para mostrar todos los datos cuando muestro la información del arreglo
public class GestionarEmpleados {
    private Lectura lectura = new Lectura();
    private GestionarPlanEntrenamiento gestionarPlan;
    public ArrayList<Empleado> entrenadores = new ArrayList();
    public ArrayList<Empleado> empleados = new ArrayList();
     public void setGestionarPlan(GestionarPlanEntrenamiento gestionarPlan) {
        this.gestionarPlan = gestionarPlan;
    }
    
    public Empleado crearEmpleado(){
        Empleado empleado = new Empleado();
        System.out.println("\n----Ingrese los datos del cliente----");
        empleado.setNombre(lectura.leerString("Nombre: "));
        empleado.setIdentificación(lectura.leerInt("Identificacion: "));
        empleado.setDirección(lectura.leerString("Dirección: "));
        empleado.setTelefono(lectura.leerInt("Telefono: "));
        empleado.setAntiguedad(lectura.leerInt("Numero de años en la empresa: "));
        empleado.setCargo(lectura.leerString("Cargo en la empresa: "));
        empleado.setSalario(lectura.leerInt("Ingrese el salario del empleado: "));
        System.out.println("-------------------------------------");
        
        if (empleado.getCargo().equalsIgnoreCase("entrenador")){
        entrenadores.add(empleado);
        }else{
        empleados.add(empleado);
        }
        return empleado;
    }
    public void mostrarEntrenadores() {
        for (int i = 0; i < entrenadores.size(); i++) {
            Empleado entrenadorAux = entrenadores.get(i);
            System.out.println((i+1) + ". " + entrenadorAux.getNombre());
        }
    }
    
    public Empleado buscarEmpleado(String nombre, int identificacion, String cargo) {
        ArrayList<Empleado> todos = new ArrayList<>();
        todos.addAll(entrenadores);
        todos.addAll(empleados);

        for (Empleado empleado : todos) {
            if (empleado.getNombre().equalsIgnoreCase(nombre) && empleado.getIdentificación() == identificacion && empleado.getCargo().equalsIgnoreCase(cargo)) {
                return empleado;
            }
        }
        return null;
    }

    public String probarVerificacion() {
        String nombre = lectura.leerString("Nombre: ");
        int id = lectura.leerInt("Identificación: ");
        String cargo = lectura.leerString("Cargo: ");

        Empleado empleado = buscarEmpleado(nombre, id, cargo);

        if (empleado == null) {
            System.out.println("Empleado no encontrado.");
            return null;
        }

        System.out.println("Empleado verificado.");
        return empleado.getCargo(); // Retorna el cargo
    }
    
    public void menuEmpleado() {
        int opcion;
        do{
            System.out.println("\nEMPLEADO:");
            System.out.println("[1] Registrar");
            System.out.println("[2] Ingresar");
            System.out.println("[0] Atras");
            opcion = lectura.leerInt("Ingrese la opción: ");
            switch (opcion){
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    String cargoVerificado = probarVerificacion();
                    if (cargoVerificado != null && cargoVerificado.equalsIgnoreCase("entrenador")) {
                        menuEntrenador();
                    } else {
                        System.out.println("No se pudo acceder al menú de entrenador.");
                    }
                    break;
            }
        }while(opcion!=0);
    }
    
    public void menuEntrenador() {
        int opcion;
        do{
            System.out.println("\nENTRENADOR:");
            System.out.println("[1] Crear plan de entrenamiento");
            System.out.println("[2] Mostrar planes de los clientes");
            System.out.println("[0] Atras");
            opcion = lectura.leerInt("Ingrese la opción: ");
            switch (opcion){
                case 1:
                    gestionarPlan.crearPlan();
                    break;
                case 2:
                    gestionarPlan.mostrarPlanes();
            }
        }while(opcion!=0);
    }
}
