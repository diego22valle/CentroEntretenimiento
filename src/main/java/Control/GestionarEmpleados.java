package Control;
import Model.Empleado;
import Util.Lectura;
import java.util.ArrayList;
import java.time.LocalDate;


/**
 * @author yesitJaramillo
 * @author diegoValle
 */

//Organizar la sobreescritura para mostrar todos los datos cuando muestro la información del arreglo
public class GestionarEmpleados {
    private Lectura lectura = new Lectura();
    private GestionarCliente gestionCliente;
    private GestionarPlanEntrenamiento gestionarPlan;
    public ArrayList<Empleado> entrenadores = new ArrayList();
    public ArrayList<Empleado> cajeros = new ArrayList();
    public ArrayList<Empleado> empleados = new ArrayList();
    public GestionarRegistro registro = new GestionarRegistro();
    private boolean liquidacion = false;
    public void setGestionCliente(GestionarCliente gestionCliente)
    {
        this.gestionCliente = gestionCliente;
    }
    public void setGestionarPlan(GestionarPlanEntrenamiento gestionarPlan) {
        this.gestionarPlan = gestionarPlan;
    }
    
    public Empleado crearEmpleado(){
        Empleado empleado = new Empleado();
        System.out.println("\n----Ingrese los datos del empleado----");
        empleado.setNombre(lectura.leerString("Nombre: "));
        
        int id = lectura.leerInt("Ingrese la identificación: ");
        if (registro.registrarId(id)){
            empleado.setIdentificación(id);
        }else{
            System.out.println("Ya existe un usuario con esa identificación");
            return null;
        }
        
        empleado.setDirección(lectura.leerString("Dirección: "));
        empleado.setTelefono(lectura.leerInt("Telefono: "));
        empleado.setAntiguedad(lectura.leerInt("Numero de años en la empresa: "));
        empleado.setCargo(lectura.leerString("Cargo en la empresa: "));
        empleado.setSalario(lectura.leerInt("Ingrese el salario del empleado: "));
        System.out.println("-------------------------------------");
        
        if(empleado.getCargo().equalsIgnoreCase("entrenador")) {
            entrenadores.add(empleado);
        }else if(empleado.getCargo().equalsIgnoreCase("cajero")) {
            cajeros.add(empleado);
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
        todos.addAll(cajeros);

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
    
    public void arqueoDeCajaDelDia() {
    ArrayList<Factura> facturas = gestionCliente.getFacturas();
    if (liquidacion) {
        System.out.println("No hay información disponible, la liquidación ya fue hecha.");
        return;
    }

    LocalDate hoy = LocalDate.now();
    int totalPagos = 0;
    int pagosEfectivo = 0;
    int pagosCheque = 0;
    int pagosCredito = 0;
    int pagosDebito = 0;
    double totalRecaudado = 0;

    System.out.println("\n--- ARQUEO DE CAJA DEL DÍA: " + hoy + " ---");

    for (Factura f : facturas) {
        if (f.getFechaPago() != null && f.getFechaPago().equals(hoy)) {
            totalPagos++;
            totalRecaudado += f.getMonto();

            String metodo = f.getMetodoPago();
            System.out.println("- Cliente: " + f.getCliente().getNombre() 
                + " | Método: " + metodo 
                + " | Monto: $" + f.getMonto());

            if (metodo.equalsIgnoreCase("Efectivo")) pagosEfectivo++;
            else if (metodo.equalsIgnoreCase("Cheque")) pagosCheque++;
            else if (metodo.equalsIgnoreCase("Tarjeta Crédito")) pagosCredito++;
            else if (metodo.equalsIgnoreCase("Tarjeta Débito")) pagosDebito++;
        }
    }

    System.out.println("\nResumen del día:");
    System.out.println("Total pagos realizados: " + totalPagos);
    System.out.println("Efectivo: " + pagosEfectivo);
    System.out.println("Cheque: " + pagosCheque);
    System.out.println("Tarjeta Crédito: " + pagosCredito);
    System.out.println("Tarjeta Débito: " + pagosDebito);
    System.out.println("Total recaudado: $" + totalRecaudado);

    String respuesta = lectura.leerString("\n¿Desea hacer la liquidación de caja? (si/no): ");
    if (respuesta.equalsIgnoreCase("si")) {
        System.out.println("Se realizó la liquidación del día: " + hoy);
        liquidacion = true;
    } else {
        System.out.println("No se realizó la liquidación del día.");
    }
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
                    if (cargoVerificado != null) {
                        if (cargoVerificado.equalsIgnoreCase("entrenador")) {
                            menuEntrenador();
                        } else if (cargoVerificado.equalsIgnoreCase("cajero")) {
                            menuCajero();
                        } else {
                            System.out.println("No se pudo acceder a un menú válido para el cargo: " + cargoVerificado);
                        }
                        break;
                    }
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
    
    public void menuCajero() {
        int opcion;
        do{
            System.out.println("\nCAJERO:");
            System.out.println("[1] Arqueo de caja");
            System.out.println("[0] Atras");
            opcion = lectura.leerInt("Ingrese la opción: ");
            switch (opcion){
                case 1:
                    arqueoDeCajaDelDia();
                    break;
            }
        }while(opcion!=0);
    }
}