/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class ListaProductos extends LinkedList {
    
    public ListaProductos() {
        super();
    }

    /*
    Une las listas a y b
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
    
    public void sort(){
        if (!isEmpty()){
            Nodo<Producto> newHead = mergeSort(first());
            setFirstNodo(newHead);
        }
    }
    
    public int indexOf(String producto) {
        if (!isEmpty()){
            Nodo<Producto> auxNodo = first();
            int count = 0;
            while (auxNodo != null) {
                if (auxNodo.gettInfo().getProducto().equalsIgnoreCase(producto)) {
                    return count;
                }
                auxNodo = next(auxNodo);
                count++;
            }
            return -1;
        }
        return -1;
    }

    public Nodo<Producto> getProduct(String producto) {
        if (!isEmpty()){
           Nodo<Producto> auxNodo = first();
           while (auxNodo != null) {
               if (auxNodo.gettInfo().getProducto().equalsIgnoreCase(producto)) {
                   return auxNodo;
               }
               auxNodo = next(auxNodo);
           }
           return null;
        }     
        return null;
    }
    

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
     *
     * @return
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
    
    public void delate(String product){
        
    }

}