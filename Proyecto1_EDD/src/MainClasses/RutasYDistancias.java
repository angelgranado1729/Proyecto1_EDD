/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class RutasYDistancias {
    
    private int[] ruta;
    private double[] distancias;

    public RutasYDistancias(int[] ruta, double[] distancias) {
        this.ruta = ruta;
        this.distancias = distancias;
    }

    public RutasYDistancias() {
    }
    
    

    /**
     * @return the ruta
     */
    public int[] getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(int[] ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the distancias
     */
    public double[] getDistancias() {
        return distancias;
    }

    /**
     * @param distancias the distancias to set
     */
    public void setDistancias(double[] distancias) {
        this.distancias = distancias;
    }
    
    
}
