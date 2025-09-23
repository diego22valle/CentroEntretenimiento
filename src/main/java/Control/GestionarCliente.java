/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Util.Lectura;
import Model.Cliente;
import java.util.ArrayList;
import Model.PlanEntrenamiento;

/**
 *
 * @author Alima
 */
//
public class GestionarCliente {
    private Lectura lectura = new Lectura();
    private GestionarPlanEntrenamiento gestionarPlan;
    public ArrayList<Cliente> clientes = new ArrayList(); 
    public void setGestionarPlan(GestionarPlanEntrenamiento gestionarPlan) {
        this.gestionarPlan = gestionarPlan;
    }

    
    public Cliente crearCliente(){
        Cliente cliente = new Cliente();
        System.out.println("\n----Ingrese los datos del cliente----");
        
        cliente.setNombre(lectura.leerString("Nombre: "));
        cliente.setIdentificación(lectura.leerInt("Identificación: "));
        cliente.setDirección(lectura.leerString("Dirección: ")); 
        cliente.setTelefono(lectura.leerInt("Telefono: "));
        cliente.setEstratoSE(lectura.leerInt("Estrato: "));
        cliente.setTrabajaEn(lectura.leerString("Empleo: "));
        cliente.setPeso(lectura.leerInt("Peso: "));
        String pA = lectura.leerString("Practica alguna actividad fisica si/no");
        System.out.println("-------------------------------------");
        
        if (pA.equalsIgnoreCase("si")){ //Corregír esta doble verificación
        cliente.setPracticaActividadFisica(true);}
        else{
            cliente.setPracticaActividadFisica(false);
        }
        if(cliente.getPracticaActividadFisica()){
        cliente.setActividadFisica(lectura.leerString("Ingrese la actividad fisica que practica: "));
        cliente.setCantidadAFMinutos(lectura.leerInt("Ingrese la cantidad de minutos: "));
        
        }
        clientes.add(cliente);
        
        return cliente;
    }
    
    public void mostrarClientes() {
        ArrayList<Cliente> clientesPagados = obtenerClientesPagados();
        for (int i = 0; i < clientesPagados.size(); i++) {
            Cliente clienteAux = clientesPagados.get(i);
            System.out.println((i + 1) + ". " + clienteAux.getNombre());
        }
    }
    
    public Cliente buscarCliente(String nombre, int identificacion) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre) && cliente.getIdentificación() == identificacion) {
                return cliente; // Cliente encontrado
            }
        }
        return null; // Cliente no encontrado
    }
    
 

    public ArrayList<Cliente> obtenerClientesPagados() {
        ArrayList<Cliente> pagados = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.getHaPagado()) {
                pagados.add(c);
            }
        }
        return pagados;
    }
    
    public Cliente verificarCliente() {
        String nombre = lectura.leerString("Nombre: ");
        int id = lectura.leerInt("Identificación: ");

        Cliente cliente = buscarCliente(nombre, id);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return null;
        }

        System.out.println("Cliente verificado.");
        return cliente;
    }
    
     public void registrarPago(Cliente cliente) {
        String metodoPago = lectura.leerString("¿Cómo desea pagar? (efectivo/cheque/ninguno): ");
        Factura factura = new Factura(cliente);

        if (metodoPago.equalsIgnoreCase("efectivo")) {
            factura.pagoEfectivo();
        } else if (metodoPago.equalsIgnoreCase("cheque")) {
            factura.pagoCheque();
        } else {
            cliente.setHaPagado(false);
            System.out.println("No se registró ningún pago.");
        }
        
    }
    
    public void mostrarEstadoCuenta(Cliente cliente) {
        if (cliente == null) {
            System.out.println("No se puede mostrar el estado de cuenta: cliente inválido.");
            return;
        }

        PlanEntrenamiento primerPlan = gestionarPlan.obtenerPrimerPlanDelCliente(cliente);

        if (primerPlan != null) {
            System.out.println("Fecha de inicio: " + primerPlan.getFechaInicio());
            System.out.println("Fecha de fin: " + primerPlan.getFechaInicio().plusDays(30));
        } else {
            System.out.println("El cliente no tiene planes registrados.");
        }

        if (cliente.getHaPagado()) {
            System.out.println("Estado de pago: Pagado");
        } else {
            System.out.println("Estado de pago: Pendiente");
        }
    }
    
    public void menuCliente() {
        int opcion;
        do{
            System.out.println("\nCLIENTE:");
            System.out.println("[1] Registrar");
            System.out.println("[2] Ingresar");
            System.out.println("[0] Atras");
            opcion = lectura.leerInt("Ingrese la opción: ");
            switch (opcion){
                case 1:
                    crearCliente();
                    break;
                case 2:
                    Cliente clienteVerificado = verificarCliente();
                    if (clienteVerificado != null) {
                        menuClienteVerificado(clienteVerificado);
                    }
                    break;
            }
        }while(opcion!=0);
    }
    
    public void menuClienteVerificado(Cliente cliente) {
        int opcion;
        do {
            System.out.println("\nCLIENTE VERIFICADO");
            System.out.println("[1] Consultar estado de cuenta");
            System.out.println("[2] Pagar mensualidad");
            System.out.println("[0] Volver");
            opcion = lectura.leerInt("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    mostrarEstadoCuenta(cliente);
                    break;
                case 2:
                    registrarPago(cliente);    
            }
        } while (opcion != 0);
}

}
