/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import java.util.ArrayList;
/**
 *
 * @author Diego, Yesid
 */
public class GestionarRegistro {
    public static ArrayList<Integer>identificaciones= new ArrayList();
    
    public boolean registrarId(int id){
    if (identificaciones.contains(id)){
    return false;
    }
    identificaciones.add(id);
    return true;
    }
    public static boolean existeId(int id) {
        return identificaciones.contains(id);
    }
}
