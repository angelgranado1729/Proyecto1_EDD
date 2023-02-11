/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class ListaProductos extends LinkedList<Producto> {
    
    /**
     * Constructor de la clase.
     */
    public ListaProductos() {
        super();
    }

    /**
     * Dado dos nodos, retorna el nodo cabeza de la lista ordenada.
     * 
     * @param a, nodo dado
     * @param b nodo dado.
     * @return result, nuevo nodo cabeza.
     */
    public Nodo<Producto> sortedMerge(Nodo<Producto> a, Nodo<Producto> b){
        Nodo<Producto> result;
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        } 
        
        if (a.gettInfo().getProducto().compareToIgnoreCase(b.gettInfo().getProducto()) < 0) {
            result = a;
            result.setNextNodo(sortedMerge(next(a), b));           
        } else {
            result = b;
            result.setNextNodo(sortedMerge(a, next(b)));
        }
        return result;      
    }
    
    /**
     * A partir de un nodo dado, ordena la lista de forma ascendente,
     * segun los nombres de los productos registrados en la lista.
     * 
     * @param headNodo, nodo de referencia.
     * @return sortedList, el nuevo nodo cabeza.
     */
    public Nodo<Producto> mergeSort(Nodo<Producto> headNodo){
        if (headNodo == null || next(headNodo) == null){
            return headNodo;
        }
        Nodo<Producto> middleNodo = getMiddle(headNodo);
        Nodo<Producto> nextOfMiddle = next(middleNodo);
        middleNodo.setNextNodo(null);
        Nodo<Producto> leftNodo = mergeSort(headNodo);
        Nodo<Producto> rightNodo = mergeSort(nextOfMiddle);
        Nodo<Producto> sortedList = sortedMerge(leftNodo, rightNodo);
        return sortedList;
    }
    
    /**
     * Ordena toda la lista de forma alfabetica, segun los
     * nombres de los productos registrados en la lista.
     */
    public void sort(){
        if (!isEmpty()){
            Nodo<Producto> newHead = mergeSort(first());
            setFirstNodo(newHead);
        }
    }
    
    /**
     * Metodo que retorna la posicion que ocupa en la lista un nodo
     * con el nombre del producto dado.
     * 
     * @param producto, el nombre del producto dado.
     * @return -1 si la lista esta vacia o no hay ningun producto con 
     * el nombre dado. Si se encontro el producto con el nombre, entonces
     * retorna su posicion en la lista.
     */
    public int indexOf(String producto) {
        if (!isEmpty()){
            Nodo<Producto> auxNodo = first();
            int count = 0;
            while (auxNodo != null) {
                if (auxNodo.gettInfo().getProducto().equals(producto)) {
                    return count;
                }
                auxNodo = next(auxNodo);
                count++;
            }
            return -1;
        }
        return -1;
    }
    
    /**
     * Retorna el nodo que guarda el producto con el nombre dado.
     * 
     * @param producto, nombre del producto.
     * @return auxNodo, el nodo que guarda el producto con el 
     * nombre dado.
     */
    public Nodo<Producto> search(String producto) {
        if (!isEmpty()){
           Nodo<Producto> auxNodo = first();
           while (auxNodo != null) {
               if (auxNodo.gettInfo().getProducto().equals(producto)) {
                   return auxNodo;
               }
               auxNodo = next(auxNodo);
           }
           return null;
        }     
        return null;
    }
    
    /**
     * Elimina el nodo que guarda el producto con el 
     * nombre dado.
     * 
     * @param producto, el nombre del producto a eliminar.
     */
    public void delateProduct(String producto) {
        if (!isEmpty()){
            Nodo<Producto> auxNodo = search(producto);
            while (auxNodo != null){
                if (next(auxNodo).gettInfo().getProducto().equals(producto)){
                    auxNodo.setNextNodo(next(next(auxNodo)));
                    this.setSize(this.size() - 1);
                    break;
                }
                auxNodo = next(auxNodo);
            }
        }
    }
    
    /**
     * Retorna todos los nodos de la lista en un array.
     * 
     * @return arrayOfProducto, un array con todos los nodos
     * de la lista en un array.
     */
    public Producto[] toArray() {
        int len = size();
        Nodo<Producto> auxNodo = first();
        Producto[] arrayOfProducto = new Producto[len];
        if (!isEmpty()) {
            for (int num = 0; num < len; num++){
                arrayOfProducto[num] = auxNodo.gettInfo();
                auxNodo = next(auxNodo);
            }
        }
        return arrayOfProducto;
    }

    /**
     *Retorna un string con toda la informacion de la instacia.
     * 
     * @return string
     */
    @Override
    public String toString() {
        String string = "";
        if (!isEmpty()) {
            Nodo<Producto> auxNodo = first();
            while (auxNodo != null) {
                string += auxNodo.gettInfo().toString();
                auxNodo = next(auxNodo);
            }
        }
        return string;
    }
   
}