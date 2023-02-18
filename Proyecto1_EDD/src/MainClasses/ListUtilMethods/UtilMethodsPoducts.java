/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses.ListUtilMethods;

import MainClasses.LinkedList;
import MainClasses.Producto;

/**
 *
 * @author Angel Granado
 */
public class UtilMethodsPoducts implements LinkedList.LinkedListMethods<Producto>{

    @Override
    public int compareTo(Producto tInfo1, Producto tInfo2) {
        return tInfo1.getProducto().compareToIgnoreCase(tInfo2.getProducto());
    }

    @Override
    public int hashCode(Producto tInfo) {
        return tInfo.hashCode();
    }

    @Override
    public boolean equals(Producto tInfo1, Producto tInfo2) {
        return tInfo1.getProducto().equalsIgnoreCase(tInfo2.getProducto());
    }
    
}
