/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class RutaYDistancia {

    /**
     * Un array con los indices que conforman la ruta.
     */
    public int[] ruta;
    /**
     * La distancia total de la ruta.
     */
    public double distancia;

    /**
     * Constructor de la clase.
     *
     * @param ruta, un array con los los indices que conforman la ruta.
     * @param distancia, la distancia total de la ruta.
     */
    public RutaYDistancia(int[] ruta, double distancia) {
        this.ruta = ruta;
        this.distancia = distancia;
    }

    /**
     * Constructor de la clase.
     */
    public RutaYDistancia() {
    }
}
