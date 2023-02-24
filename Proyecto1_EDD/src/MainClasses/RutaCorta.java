/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class RutaCorta {
    
    private int[] index;
    private LinkedList<Almacen> almacenes;
    private double distance;

    public RutaCorta(int[] index, LinkedList<Almacen> almacenes, double distance) {
        this.index = index;
        this.almacenes = almacenes;
        this.distance = distance;
    }

    /**
     * @return the index
     */
    public int[] getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int[] index) {
        this.index = index;
    }

    /**
     * @return the almacenes
     */
    public LinkedList<Almacen> getAlmacenes() {
        return almacenes;
    }

    /**
     * @param almacenes the almacenes to set
     */
    public void setAlmacenes(LinkedList<Almacen> almacenes) {
        this.almacenes = almacenes;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
   
    
    
}
