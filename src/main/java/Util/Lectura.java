/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import java.util.*;

/**
 *
 * @author Ali
 */
public class Lectura {
    private Scanner entrada = new Scanner(System.in);
    
   public int leerInt(String mensaje) {
    int valor = 0;
    boolean valido = false;

    while (!valido) {
        try {
            System.out.println(mensaje);
            valor = entrada.nextInt();  
            entrada.nextLine(); 
            valido = true; 
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número válido.");
            entrada.nextLine(); 
        }
    }

    return valor;
}

    public String leerString(String mensaje){
        System.out.println(""+mensaje);
        return entrada.nextLine();
    }
    
    public float leerFloat(String mensaje) {
    float valor = 0;
    boolean valido = false;

    while (!valido) {
        try {
            System.out.println(mensaje);
            valor = entrada.nextFloat();
            entrada.nextLine(); // 👈 limpia el salto de línea pendiente
            valido = true;
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número decimal válido.");
            entrada.nextLine(); // limpia el buffer en caso de error
        }
    }

    return valor;
}

    
    public Boolean leerBoolean(String mensaje){
        System.out.println(""+mensaje);
        return entrada.hasNextBoolean();
    }
}
