/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
/**
 *
 * @author Ali
 */
public class Servicio extends Producto {
    private int duracion;
    
    public Servicio() {
    }

    public Servicio(int duracion, int codigo, String nombre, String descripcion) {
        super(codigo, nombre, descripcion);
        this.duracion = duracion;
    }

    public Servicio(int codigo, String nombre, String descripcion) {
        super(codigo, nombre, descripcion);
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Servicio{");
        sb.append(" Duracion =").append(duracion);
        sb.append('}');
        return sb.toString();
    }   
}
