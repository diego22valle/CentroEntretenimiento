package Control;
import Model.*;
import java.util.ArrayList;
import Util.Lectura;
import java.time.LocalDate;

/**
 * @author yesitJaramillo
 * @author diegoValle
 */
public class GestionarPlanEntrenamiento {
    public Lectura leer = new Lectura();
    public ArrayList<PlanEntrenamiento> planes = new ArrayList();
    public GestionarEmpleados empleado;
    public GestionarCliente cliente;
    public GestionarPlanEntrenamiento(GestionarCliente cliente, GestionarEmpleados empleado) {
        this.cliente = cliente;    
        this.empleado = empleado;  
    }
    
    public PlanEntrenamiento crearPlan() {
    // Verificar que hay clientes registrados
        ArrayList<Cliente> clientesPagados = cliente.obtenerClientesPagados();
        if (clientesPagados.isEmpty()) {
            System.out.println("No hay clientes disponibles.");
            return null;
        }

        // Verificar que hay entrenadores registrados
        if (empleado.entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados disponibles.");
            return null;
        }

        PlanEntrenamiento plan = new PlanEntrenamiento();

        // Selección de entrenador
        System.out.println("\n--- SELECCIÓN DE ENTRENADOR ---");
        empleado.mostrarEntrenadores();
        int entrenadorNumero = leer.leerInt("Ingrese el número del entrenador: ");

        if (entrenadorNumero < 1 || entrenadorNumero > empleado.entrenadores.size()) {
            System.out.println("Número de entrenador inválido.");
            return null;
        }
        Empleado entrenadorSeleccionado = empleado.entrenadores.get(entrenadorNumero - 1);
        plan.setEntrenadorACargo(entrenadorSeleccionado);

        // Selección de cliente (solo los que han pagado)
        System.out.println("\n--- SELECCIÓN DE CLIENTE ---");
        cliente.mostrarClientes();
        int clienteNumero = leer.leerInt("Ingrese el número del cliente: ");
        System.out.println("-------------------------------------");

        if (clienteNumero < 1 || clienteNumero > clientesPagados.size()) {
            System.out.println("Número de cliente inválido.");
            return null;
        }

        Cliente clienteSeleccionado = clientesPagados.get(clienteNumero - 1);
        plan.setClientePlan(clienteSeleccionado);

        System.out.println("Peso: " + clienteSeleccionado.getPeso());

        if (clienteSeleccionado.getPracticaActividadFisica()) {
            System.out.println("Cantidad de actividad física (min): " + clienteSeleccionado.getCantidadAFMinutos());
        } else {
            System.out.println("El cliente no practica actividad física");
        }

        // Configuración de fechas
        LocalDate fechaInicio = LocalDate.now();
        plan.setFechaInicio(fechaInicio);

        // Objetivo y detalles del plan
        plan.setObjetivo(leer.leerString("Ingrese el objetivo del plan: "));

        int duracion = leer.leerInt("Ingrese la duración del plan en días (máximo 30): ");
        if (duracion < 1 || duracion > 30) {
            System.out.println("Duración inválida. El plan debe ser entre 1 y 30 días.");
            return null;
        }
        plan.setDuracionDias(duracion);

        // Calcular fecha de fin basada en la duración
        LocalDate fechaFin = fechaInicio.plusDays(duracion);
        plan.setFechaFin(fechaFin);

        plan.setCodigo(leer.leerInt("Ingrese el código del plan: "));
        plan.setNombre(leer.leerString("Ingrese el nombre del plan: "));
        plan.setDescripcion(leer.leerString("Ingrese la descripción del plan: "));
        System.out.println("-------------------------------------");

        planes.add(plan);
        System.out.println("Plan creado correctamente.");
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Fecha de finalización: " + fechaFin);

        return plan;
    }
    
    public void mostrarPlanes() {
        if (planes.isEmpty()) {
            System.out.println("No hay planes creados. Debes crear un plan primero.");
            return;
        }
        
        for (int i = 0; i < planes.size(); i++) {
            PlanEntrenamiento planAux = planes.get(i);
            System.out.println("-------------------------------------");
            System.out.println("Plan #" + (i + 1));
            System.out.println("Nombre: " + planAux.getNombre());
            System.out.println("Cliente: " + planAux.getClientePlan().getNombre() + " (ID: " + planAux.getClientePlan().getIdentificación() + ")");
            System.out.println("Entrenador a cargo: " + planAux.getEntrenadorACargo().getNombre() + " (ID: " + planAux.getEntrenadorACargo().getIdentificación() + ")");
            System.out.println("Código: " + planAux.getCodigo());
            System.out.println("Objetivo: " + planAux.getObjetivo());
            System.out.println("Descripción: " + planAux.getDescripcion());
            System.out.println("Duración (días): " + planAux.getDuracionDias());
            System.out.println("Fecha de inicio: " + planAux.getFechaInicio());
            System.out.println("Fecha de fin: " + planAux.getFechaFin());
            System.out.println("-------------------------------------");
}
}
}
