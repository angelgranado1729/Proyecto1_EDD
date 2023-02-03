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
    
    /**
     * Nombre del almacen.
     */
    private String almacen;
    /**
     * Lista con los productos registrados en el almacen.
     */
    private ListaProductos listaProductos;
    
    /**
     * Constructor de la clase.
     * @param almacen nombre del almacen
     */
    public Almacen(String almacen){
        this.almacen = almacen;
        this.listaProductos =  new ListaProductos();        
    }
    
    /**
     * Constructor de la clase.
     * 
     * @param almacen nombre del almacen.
     * @param listaProductos lista de los productos registrados en el almacen.
     */
    public Almacen(String almacen, ListaProductos listaProductos){
        this.almacen = almacen;
        this.listaProductos = listaProductos;
    }

    /**
     * Getter para acceder al nombre del almacen.
     * 
     * @return almacen nombre del almacen. 
     */
    public String getAlmacen() {
        return almacen;
    }

    /**
     * Setter para modificar el nombre del almacen.
     * 
     * @param almacen nuevo nombre.
     */
    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    /** Getter para acceder a la lista producto.
     * 
     * @return listaProductos
     */
    public ListaProductos getListaProductos() {
        return listaProductos;
    }

    /** 
     * Setter para modificar listaProductos.
     * 
     * @param listaProductos nueva listaProductos.
     */
    public void setListaProductos(ListaProductos listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * Procedimiento que agrega un nuevo producto a listaProductos.
     * 
     * @param producto nombre del producto.
     * @param stock cantidad disponible.
     */
    public void addProduct(String producto, int stock) {
        if (stock >= 0){
            Producto newProduct = new Producto(producto, stock);
            this.listaProductos.append(newProduct);
        } else {
            Producto newProduct = new Producto(producto);
            this.listaProductos.append(newProduct);
        }
    }
    
    /**
     * Elimina un producto de listaProducto.
     * 
     * @param producto nombre del producto que se desea eliminar.
     */
    public void delateProduct(String producto) {
        int index = this.listaProductos.indexOf(producto);
        this.listaProductos.delate(index);
    }
    
    /**
     * Modifica el stock de un producto registrado.
     * 
     * @param producto nombre del producto.
     * @param newStock nueva cantidad disponible.
     */
    public void modifyStock(String producto, int newStock) {
        if (newStock >= 0){
            Nodo<Producto> productNodo = this.listaProductos.getProduct(producto);
            Producto newProduct = new Producto(productNodo.gettInfo().getProducto(), newStock);
            productNodo.settInfo(newProduct);
        }       
    }
    
    /**
     * Metodo que busca el producto en listaProductos.
     * 
     * @param producto nombre del producto a buscar.
     * @return product el producto encontrado.
     */
    public Producto searchProduct(String producto) {
        Nodo<Producto> productNodo = this.listaProductos.getProduct(producto);
        Producto product = productNodo.gettInfo();
        return product;
    }
    
    /**
     * Retorna un string con toda la informacion de la instacia.
     * 
     * @return string
     */
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