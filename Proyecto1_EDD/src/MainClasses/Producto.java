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

    private String producto;
    private int stock;

    public Producto(String producto, int stock) {
        this.producto = producto;
        this.stock = stock;
    }

    public Producto(String producto) {
        this.producto = producto;
        this.stock = 0;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString(){
        String string = "";
        string += "Producto: " + this.producto + "\n";
        string += "Stock: " + String.valueOf(stock) + "\n";
        return string;
    }

}
