/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Diego
 */
public class Cliente extends Persona {
    private int estratoSE;
    private String trabajaEn;
    private Boolean practicaActividadFisica;
    private String actividadFisica;
    private int cantidadAFMinutos;
    private int peso;
    private boolean haPagado;


    public Cliente() {
    }

    public Cliente(int estratoSE, String trabajaEn, Boolean practicaActividadFisica, String actividadFisica, int cantidadAFMinutos, int identificación, String nombre, String dirección, int telefono, int peso) {
        super(identificación, nombre, dirección, telefono);
        this.estratoSE = estratoSE;
        this.trabajaEn = trabajaEn;
        this.practicaActividadFisica = practicaActividadFisica;
        this.actividadFisica = actividadFisica;
        this.cantidadAFMinutos = cantidadAFMinutos;
        this.peso = peso;
    }

    public int getEstratoSE() {
        return estratoSE;
    }

    public void setEstratoSE(int estratoSE) {
        this.estratoSE = estratoSE;
    }

    public String getTrabajaEn() {
        return trabajaEn;
    }

    public void setTrabajaEn(String trabajaEn) {
        this.trabajaEn = trabajaEn;
    }

    public Boolean getPracticaActividadFisica() {
        return practicaActividadFisica;
    }

    public void setPracticaActividadFisica(Boolean practicaActividadFisica) {
        this.practicaActividadFisica = practicaActividadFisica;
    }

    public String getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(String actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public int getCantidadAFMinutos() {
        return cantidadAFMinutos;
    }

    public void setCantidadAFMinutos(int cantidadAFMinutos) {
        this.cantidadAFMinutos = cantidadAFMinutos;
    }
    
    public int getPeso() {
        return peso;
    }
    
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public boolean getHaPagado() {
    return haPagado;
    }

    public void setHaPagado(boolean haPagado) {
        this.haPagado = haPagado;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Cliente");
        sb.append("estratoSE=").append(estratoSE);
        sb.append(", trabajaEn=").append(trabajaEn);
        sb.append(", practicaActividadFisica=").append(practicaActividadFisica);
        sb.append(", actividadFisica=").append(actividadFisica);
        sb.append(", cantidadAFMinutos=").append(cantidadAFMinutos);
        sb.append(", peso=").append(peso);
        sb.append('}');
        return sb.toString();
    }   
}
