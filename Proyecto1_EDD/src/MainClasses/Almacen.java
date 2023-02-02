/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class Almacen {

    private String almacen;
    private ListaProductos listaProductos;
    
    public Almacen(String almacen){
        this.almacen = almacen;
        this.listaProductos =  new ListaProductos();        
    }
    
    public Almacen(String almacen, ListaProductos listaProductos){
        this.almacen = almacen;
        this.listaProductos = listaProductos;
    }

    /**
     * @return the almacen
     */
    public String getAlmacen() {
        return almacen;
    }

    /**
     * @param almacen the almacen to set
     */
    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    /**
     * @return the listaProductos
     */
    public ListaProductos getListaProductos() {
        return listaProductos;
    }

    /**
     * @param listaProductos the listaProductos to set
     */
    public void setListaProductos(ListaProductos listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void addProduct(String producto, int stock) {
        if (stock >= 0){
            Producto newProduct = new Producto(producto, stock);
            this.listaProductos.append(newProduct);
        } else {
            Producto newProduct = new Producto(producto);
            this.listaProductos.append(newProduct);
        }
    }

    public void delateProduct(String producto) {
        int index = this.listaProductos.indexOf(producto);
        this.listaProductos.delate(index);
    }

    public void modifyStock(String producto, int newStock) {
        if (newStock >= 0){
            Nodo<Producto> productNodo = this.listaProductos.getProduct(producto);
            Producto newProduct = new Producto(productNodo.gettInfo().getProducto(), newStock);
            productNodo.settInfo(newProduct);
        }       
    }

    public Producto searchProduct(String producto) {
        Nodo<Producto> productNodo = this.listaProductos.getProduct(producto);
        Producto product = productNodo.gettInfo();
        return product;
    }
    
    @Override
    public String toString(){
        String string = "";
        string += this.almacen + "\n";
        for (int num = 0; num < this.listaProductos.size(); num++) {
            string += this.listaProductos.getByIndex(num).gettInfo().toString() + "\n";
        }
        return string;
    }

}