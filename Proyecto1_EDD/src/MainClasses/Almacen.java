/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import MainClasses.ListUtilMethods.UtilMethodsPoducts;


/**
 *
 * @author Angel Granado
 */

public class Almacen {

    private String almacen;
    private LinkedList<Producto> listaProductos;
    /**
     * Constructor de la clase.
     * @param almacen, el nombre del almacen
     */
    public Almacen(String almacen){
        this.almacen = almacen;
        this.listaProductos =  new LinkedList<Producto>(new UtilMethodsPoducts());  
    }
    
    /**
     * Constructor de la clase.
     * 
     * @param almacen, el nombre del almacen.
     * @param listaProducts, la lista de los productos 
     * registrados en el almacen.
     */
    public Almacen(String almacen, LinkedList<Producto> listaProducts){
        this.almacen = almacen;
        this.listaProductos = listaProducts;
        listaProductos.setMethods(new UtilMethodsPoducts());
    }

    /**
     * Getter para acceder al nombre del almacen.
     * 
     * @return almacen, el nombre del almacen. 
     */
    public String getAlmacen() {
        return almacen;
    }

    /**
     * Setter para modificar el nombre del almacen.
     * 
     * @param almacen, el nuevo nombre.
     */
    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    /** Getter para acceder a la lista producto.
     * 
     * @return listaProductos.
     */
    public LinkedList<Producto> getListaProductos() {
        return listaProductos;
    }

    /** 
     * Setter para modificar listaProductos.
     * 
     * @param listaProducts, la nueva listaProductos.
     */
    public void setListaProductos(LinkedList<Producto> listaProducts) {
        this.listaProductos = listaProducts;
    }

    /**
     * Procedimiento que agrega un nuevo producto a listaProductos.
     * 
     * @param producto, el nombre del producto.
     * @param stock, la cantidad disponible.
     */
    public void addProduct(String producto, int stock) {
        if (stock >= 0){
            Producto newProduct = new Producto(producto, stock);
            this.listaProductos.addEnd(newProduct);
        } else {
            Producto newProduct = new Producto(producto);
            this.listaProductos.addEnd(newProduct);
        }
    }
    
    /**
     * Elimina un producto de listaProducto.
     * 
     * @param producto, el nombre del producto que se desea eliminar.
     */
    public void deleteProduct(String producto) {
        this.listaProductos.setMethods(new UtilMethodsPoducts());
        int index = listaProductos.indexOf(new Producto(producto));
        if (index != -1){
            this.listaProductos.pop(index);   
        }  
        
    }
    
    /**
     * Modifica el stock de un producto registrado.
     * 
     * @param producto, el nombre del producto.
     * @param newStock, la nueva cantidad disponible.
     */
    public void modifyStock(String producto, int newStock) {
        if (newStock >= 0){
            Node<Producto> productNodo = this.listaProductos.search(new Producto(producto));
            if (productNodo != null){
                Producto newProduct = new Producto(productNodo.getTInfo().getProducto(), newStock);
                productNodo.setTInfo(newProduct);      
            }
        }       
    }
    
    /**
     * Metodo que busca el producto en listaProductos.
     * 
     * @param producto, el nombre del producto a buscar.
     * @return product, el producto encontrado.
     */
    public Producto searchProduct(String producto) {
        Node<Producto> productNodo = this.listaProductos.search(new Producto(producto));
        if (productNodo != null){
            Producto product = productNodo.getTInfo();
            return product;    
        }
        return null;
    }
    
    /**
     * Retorna un string con toda la informacion de la instacia.
     * 
     * @return string
     */
    @Override
    public String toString(){
        String string = "";
        string += this.almacen + "\n" + listaProductos.toString();
        return string;
    }

}