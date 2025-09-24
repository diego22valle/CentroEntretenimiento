package Control;

import Util.Lectura;
import Model.Cliente;
import java.util.ArrayList;

/**
 * @author yesitJaramillo
 * @author diegoValle
 */
//
public class GestionarCliente {

    private Lectura lectura = new Lectura();
    public ArrayList<Cliente> clientes = new ArrayList();
    private ArrayList<Factura> facturas = new ArrayList<>();
    public GestionarRegistro registro = new GestionarRegistro();

    public Cliente crearCliente() {
        Cliente cliente = new Cliente();
        System.out.println("\n----Ingrese los datos del cliente----");

        cliente.setNombre(lectura.leerString("Nombre: "));

        int id = lectura.leerInt("Ingrese la identificación del cliente: ");
        if (registro.registrarId(id)) {
            cliente.setIdentificación(id);
        } else {
            System.out.println("Ya hay un usuario con esa identificación");
            return null;
        }

        cliente.setDirección(lectura.leerString("Dirección: "));
        cliente.setTelefono(lectura.leerInt("Telefono: "));
        cliente.setEstratoSE(lectura.leerInt("Estrato: "));
        cliente.setTrabajaEn(lectura.leerString("Empleo: "));
        cliente.setPeso(lectura.leerInt("Peso: "));
        String pA = lectura.leerString("Practica alguna actividad fisica si/no");
        System.out.println("-------------------------------------");

        if (pA.equalsIgnoreCase("si")) { //Corregír esta doble verificación
            cliente.setPracticaActividadFisica(true);
        } else {
            cliente.setPracticaActividadFisica(false);
        }
        if (cliente.getPracticaActividadFisica()) {
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
                return cliente;
            }
        }
        return null;
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
        // ✅ Verificamos si ya pagó
        if (cliente.getHaPagado()) {
            System.out.println("⚠️ El cliente ya ha pagado la mensualidad. No es posible realizar otro pago.");
            return;
        }

        double monto = lectura.leerFloat("Ingrese el monto a pagar: ");
        cliente.setMensualidad(Factura.MENSUALIDAD);

        if (monto < Factura.MENSUALIDAD) {
            System.out.println("El monto es insuficiente. Mensualidad: " + Factura.MENSUALIDAD);
            cliente.setHaPagado(false);
            return;
        }

        // Ahora sí preguntamos método de pago
        String metodoPago = lectura.leerString("¿Cómo desea pagar? (efectivo/cheque/tarjeta credito/tarjeta debito): ");
        Factura factura = new Factura(cliente, monto); // 👈 importante pasar monto

        switch (metodoPago.toLowerCase()) {
            case "efectivo":
                factura.pagoEfectivo();
                break;
            case "cheque":
                factura.pagoCheque();
                break;
            case "tarjeta credito":
                factura.pagoTarjetaCredito();
                break;
            case "tarjeta debito":
                factura.pagoTarjetaDebito();
                break;
            default:
                System.out.println("Método de pago no válido.");
                return;
        }

        facturas.add(factura);
        cliente.setHaPagado(true);
        cliente.setSaldoPendiente(0); // ya pagó
        System.out.println(" Pago registrado con éxito. Factura generada.");
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void mostrarEstadoCuenta(Cliente cliente) { //Hay que organizar bien el Estado de Cuenta
        if (cliente == null) {
            System.out.println("No se puede mostrar el estado de cuenta: cliente inválido.");
            return;
        }
        if (cliente.getHaPagado()) {
            System.out.println("Estado de pago: Pagado");
            for (Factura f : facturas) {
                if (f.getCliente().equals(cliente) && f.getFechaPago() != null) {
                    System.out.println("Fecha de inicio: " + f.getFechaPago());
                    System.out.println("Fecha de fin: " + f.getFechaPago().plusDays(30));
                    break;
                }
            }
        } else {
            System.out.println("Estado de pago: Pendiente");
            System.out.println("El cliente no ha pagado la mensualidad.");
        }
    }

    public void menuCliente() {
        int opcion;
        do {
            System.out.println("\nCLIENTE:");
            System.out.println("[1] Registrar");
            System.out.println("[2] Ingresar");
            System.out.println("[0] Atras");
            opcion = lectura.leerInt("Ingrese la opción: ");
            switch (opcion) {
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
        } while (opcion != 0);
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
