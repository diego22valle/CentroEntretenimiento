/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.Cliente;
/**
 *
 * @author Diego
 */
public class Factura implements Pago {
    private Cliente cliente;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void pagoEfectivo() {
        System.out.println("Pago en efectivo realizado.");
        cliente.setHaPagado(true);
    }

    @Override
    public void pagoCheque() {
        System.out.println("Pago con cheque realizado.");
        cliente.setHaPagado(true);
    }

    @Override
    public void pagoCredito() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

