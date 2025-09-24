package com.mycompany.centroentretenimiento;

import Control.GestionarEmpleados;
import Control.GestionarCliente;
import Control.GestionarPlanEntrenamiento;
import Util.Lectura;

public class CentroEntretenimiento {
    
   public static void main(String[] args) {
    Lectura lectura = new Lectura();   
    GestionarCliente gestionCliente = new GestionarCliente();
    GestionarEmpleados gestionEmpleado = new GestionarEmpleados();
    GestionarPlanEntrenamiento gestionPlan = new GestionarPlanEntrenamiento(gestionCliente, gestionEmpleado);
    gestionEmpleado.setGestionarPlan(gestionPlan);
    gestionEmpleado.setGestionCliente(gestionCliente);


    int opcion;
    do{
        System.out.println("\nMENU:");
        System.out.println("[1] Cliente");
        System.out.println("[2] Empleado");
        System.out.println("[0] Salir");
        opcion = lectura.leerInt("Ingrese la opción: ");
        switch (opcion){
            case 1:
                gestionCliente.menuCliente();
                break;
            case 2:
                gestionEmpleado.menuEmpleado();
                break;        
        }
    }while(opcion!=0);
}
}