/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class Producto {

    /**
     * Nombre del producto.
     */
    private String producto;
    /**
     * Cantidad disponible.
     */
    private int stock;

    /**
     * Constructor de la clase.
     *
     * @param producto nombre del producto.
     * @param stock cantidad disponible.
     */
    public Producto(String producto, int stock) {
        this.producto = producto;
        this.stock = stock;
    }

    /**
     * Constructor de la clase.
     *
     * @param producto nombre del producto.
     */
    public Producto(String producto) {
        this.producto = producto;
        this.stock = 0;
    }

    /**
     * Getter para acceder al nombre del producto.
     *
     * @return producto nombre del producto.
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Setter para modificar el nombre del producto.
     *
     * @param producto nuevo nombre del producto.
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * Getter para acceder a la cantidad disponible del producto.
     *
     * @return stock cantidad disponible del producto.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Setter para modificar la cantidad disponible del producto.
     *
     * @param stock nueva cantidad disponible del producto.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Retorna un string con toda la informacion de la instacia.
     *
     * @return string
     */
    @Override
    public String toString() {
        String string = "";
        string += "-Producto: " + this.producto + "\n";
        string += "-Stock: " + String.valueOf(stock);
        return string;
    }

}
