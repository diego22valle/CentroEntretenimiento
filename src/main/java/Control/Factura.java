package Control;
import Model.Cliente;
import java.time.LocalDate;

public class Factura implements Pago {
    private Cliente cliente;
    private LocalDate fechaPago;
    private String metodoPago;
    private double monto;
    public static final double MENSUALIDAD = 100000; 


    public Factura(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }

    private void procesarPago(String metodo) {
        this.metodoPago = metodo;
        this.fechaPago = LocalDate.now();

        if (monto >= MENSUALIDAD) {
            cliente.setHaPagado(true);
            System.out.println("✅ Pago realizado con " + metodo + ". Monto: $" + monto);
            if (monto > MENSUALIDAD) {
                System.out.println("⚠️ Pago excedente de: $" + (monto - MENSUALIDAD));
            }
        } else {
            cliente.setHaPagado(false);
            System.out.println("❌ El monto ingresado ($" + monto + ") no cubre la mensualidad de $" + MENSUALIDAD);
        }
    }

    @Override
    public void pagoEfectivo() {
        procesarPago("Efectivo");
    }

    @Override
    public void pagoCheque() {
        procesarPago("Cheque");
    }

    @Override
    public void pagoTarjetaCredito() {
        procesarPago("Tarjeta Crédito");
    }

    @Override
    public void pagoTarjetaDebito() {
        procesarPago("Tarjeta Débito");
    }
}
