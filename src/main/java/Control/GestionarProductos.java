/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Producto;
import Util.Lectura;

/**
 * Ingresar un producto
 * Buscar un producto
 * @author Diego, yesid
 */
public class GestionarProductos {
    private Lectura lectura = new Lectura();
    public Producto crearProducto(){
        Producto producto = new Producto();
        System.out.println("A continuación ingrese los datos del producto.");
        producto.setCodigo(lectura.leerInt("Igrese el código: "));
        producto.setDescripcion(lectura.leerString("Ingrese el nombre: "));
        producto.setDescripcion(lectura.leerString("Ingrese la descripción: "));
        return producto;
    }

    public GestionarProductos() {
    }
}
