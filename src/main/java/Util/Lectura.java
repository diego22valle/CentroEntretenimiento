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
    
   public int leerInt(String mensaje){
    System.out.println(mensaje);
    int valor = entrada.nextInt();
    entrada.nextLine(); // 👈 limpiar el salto de línea pendiente
    return valor;
}

    public String leerString(String mensaje){
        System.out.println(""+mensaje);
        return entrada.nextLine();
    }
    
    public float leerFloat(String mensaje){
        System.out.println(""+mensaje);
        return entrada.nextFloat();
    }
    
    public Boolean leerBoolean(String mensaje){
        System.out.println(""+mensaje);
        return entrada.hasNextBoolean();
    }
}
