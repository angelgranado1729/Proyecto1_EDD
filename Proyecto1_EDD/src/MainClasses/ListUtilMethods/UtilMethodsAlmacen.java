/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses.ListUtilMethods;

import MainClasses.Almacen;
import MainClasses.LinkedList;

/**
 *
 * @author Angel Granado
 */
public class UtilMethodsAlmacen implements LinkedList.LinkedListMethods<Almacen> {

    @Override
    public int compareTo(Almacen tInfo1, Almacen tInfo2) {
        return tInfo1.getAlmacen().strip().compareToIgnoreCase(tInfo2.getAlmacen().strip());
    }

    @Override
    public int hashCode(Almacen tInfo) {
        return tInfo.getAlmacen().hashCode();
    }

    @Override
    public boolean equals(Almacen tInfo1, Almacen tInfo2) {
        return tInfo1.getAlmacen().equalsIgnoreCase(tInfo2.getAlmacen());
    }

}
