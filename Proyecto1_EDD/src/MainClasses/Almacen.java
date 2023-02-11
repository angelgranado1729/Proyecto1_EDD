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
     * @param almacen, el nombre del almacen
     */
    public Almacen(String almacen){
        this.almacen = almacen;
        this.listaProductos =  new ListaProductos();        
    }
    
    /**
     * Constructor de la clase.
     * 
     * @param almacen, el nombre del almacen.
     * @param listaProducts, la lista de los productos 
     * registrados en el almacen.
     */
    public Almacen(String almacen, ListaProductos listaProducts){
        this.almacen = almacen;
        this.listaProductos = listaProducts;
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
    public ListaProductos getListaProductos() {
        return listaProductos;
    }

    /** 
     * Setter para modificar listaProductos.
     * 
     * @param listaProducts, la nueva listaProductos.
     */
    public void setListaProductos(ListaProductos listaProducts) {
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
            this.listaProductos.append(newProduct);
        } else {
            Producto newProduct = new Producto(producto);
            this.listaProductos.append(newProduct);
        }
    }
    
    /**
     * Elimina un producto de listaProducto.
     * 
     * @param producto, el nombre del producto que se desea eliminar.
     */
    public void delateProduct(String producto) {
        int index = this.listaProductos.indexOf(producto);
        this.listaProductos.delate(index);
    }
    
    /**
     * Modifica el stock de un producto registrado.
     * 
     * @param producto, el nombre del producto.
     * @param newStock, la nueva cantidad disponible.
     */
    public void modifyStock(String producto, int newStock) {
        if (newStock >= 0){
            Nodo<Producto> productNodo = this.listaProductos.search(producto);
            Producto newProduct = new Producto(productNodo.gettInfo().getProducto(), newStock);
            productNodo.settInfo(newProduct);
        }       
    }
    
    /**
     * Metodo que busca el producto en listaProductos.
     * 
     * @param producto, el nombre del producto a buscar.
     * @return product, el producto encontrado.
     */
    public Producto searchProduct(String producto) {
        Nodo<Producto> productNodo = this.listaProductos.search(producto);
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