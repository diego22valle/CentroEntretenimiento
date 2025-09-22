/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.LocalDate;
/**
 *
 * @author USUARIO
 */
public class PlanEntrenamiento extends Servicio{
    
    private Empleado entrenadorACargo;
    private Cliente ClientePlan;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String objetivo;
    private int duracionDias;

    public PlanEntrenamiento() {
    }

    public PlanEntrenamiento(Empleado entrenadorACargo, Cliente ClientePlan, LocalDate fechaInicio, LocalDate fechaFin, String objetivo, int duracionDias) {
        this.entrenadorACargo = entrenadorACargo;
        this.ClientePlan = ClientePlan;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.objetivo = objetivo;
        this.duracionDias = duracionDias;
    }

    public PlanEntrenamiento(Empleado entrenadorACargo, Cliente ClientePlan, LocalDate fechaInicio, LocalDate fechaFin, String objetivo,int duracionDias, int duracion, int codigo, String nombre, String descripcion) {
        super(duracion, codigo, nombre, descripcion);
        this.entrenadorACargo = entrenadorACargo;
        this.ClientePlan = ClientePlan;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.objetivo = objetivo;
        this.duracionDias = duracionDias;
    }

    

    public Empleado getEntrenadorACargo() {
        return entrenadorACargo;
    }

    public void setEntrenadorACargo(Empleado entrenadorACargo) {
        this.entrenadorACargo = entrenadorACargo;
    }

    public Cliente getClientePlan() {
        return ClientePlan;
    }

    public void setClientePlan(Cliente ClientePlan) {
        this.ClientePlan = ClientePlan;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlanEntrenamiento{");
        sb.append("entrenadorACargo=").append(entrenadorACargo);
        sb.append(", ClientePlan=").append(ClientePlan);
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaFin=").append(fechaFin);
        sb.append(", objetivo=").append(objetivo);
        sb.append(", duracionDias=").append(duracionDias);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}
