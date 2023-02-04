/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class ListaAlmacenes extends LinkedList<Almacen> {
    
    /**
     * Constructor de la clase.
     */
    public ListaAlmacenes() {
        super();
    }
    
    /**
     * Ordena la lista dado dos extremos.
     * 
     * @param a extremo inferior.
     * @param b extremo superior.
     * @return result nuevo nodo inicial
     */
    public Nodo<Almacen> sortedMerge(Nodo<Almacen> a, Nodo<Almacen> b){
        Nodo<Almacen> result;
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        } 
        
        if (a.gettInfo().getAlmacen().compareToIgnoreCase(b.gettInfo().getAlmacen()) < 0) {
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
     * segun los nombres de los almacenes registrados en la lista.
     * 
     * @param headNodo nodo de referencia.
     * @return sortedList nuevo nodo cabeza.
     */
    public Nodo<Almacen> mergeSort(Nodo<Almacen> headNodo){
        if (headNodo == null || next(headNodo) == null){
            return null;
        }
        Nodo<Almacen> middleNodo = getMiddle(headNodo);
        Nodo<Almacen> nextOfMiddle = next(middleNodo);
        middleNodo.setNextNodo(null);
        Nodo<Almacen> leftNodo = mergeSort(headNodo);
        Nodo<Almacen> rightNodo = mergeSort(nextOfMiddle);
        Nodo<Almacen> sortedList = sortedMerge(leftNodo, rightNodo);
        return sortedList;
    }
    
    /**
     * Ordena toda la lista de forma alfabetica, segun los
     * nombres de los almacenes registrados en la lista.
     */
    public void sort(){
        if (!isEmpty()){
            Nodo<Almacen> newHead = mergeSort(first());
            setFirstNodo(newHead);
        }
    }
    
    /**
     * Metodo que retorna la posicion que ocupa en la lista un nodo
     * con el nombre del almacen dada.
     * 
     * @param almacen nombre del almacen dado.
     * @return index la posicion del nodo que guarda el almacen
     */
    public int indexOf(String almacen) {
        if (!isEmpty()) {
            Nodo<Almacen> auxNodo = first();
            int count = 0;
            while (auxNodo != null) {
                if (auxNodo.gettInfo().getAlmacen().equalsIgnoreCase(almacen)) {
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
     * Retorna un nodo que esta guardando un almacen con el nombre dado.
     * 
     * @param almacen nombre del almacen
     * @return auxNodo nodo que esta guarda el almacen con el nombre dado
     */
    public Almacen getByAlmacen(String almacen) {
        Almacen temp = null;
        if (!isEmpty()) {
            Nodo<Almacen> auxNodo = first();
            while (auxNodo != null) {
                if (auxNodo.gettInfo().getAlmacen().equalsIgnoreCase(almacen)) {
                    temp = auxNodo.gettInfo();
                    return temp;
                }
                auxNodo = next(auxNodo);
            }
            return temp;
        }
        return temp;
    }
    
    /**
     * Retorna todos los nodos de la lista en un array.
     * 
     * @return arrayOfAlacen
     */
    public Almacen[] toArray() {
        int len = size();
        Nodo<Almacen> auxNodo = first();
        Almacen[] arrayOfAlmacen = new Almacen[len];
        if (!isEmpty()){
            for (int num = 0; num < len; num++){
                arrayOfAlmacen[num] = auxNodo.gettInfo();
                auxNodo = next(auxNodo);
            }
        }
        return arrayOfAlmacen;
    }

    /**
     * Retorna un string con toda la informacion de la instacia.
     * 
     * @return string
     */
    @Override
    public String toString() {
        String string = "";
        if (!isEmpty()){
            Nodo<Almacen> auxNodo = first();
            while (auxNodo != null) {
                string += auxNodo.gettInfo().toString();
                auxNodo = next(auxNodo);                
            } 
        }
        return string;              
    }
    
    public void delate(String storageName){
        
    }
    
}
