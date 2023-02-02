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

    public ListaAlmacenes() {
        super();
    }

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
    
    public void sort(){
        if (!isEmpty()){
            Nodo<Almacen> newHead = mergeSort(first());
            setFirstNodo(newHead);
        }
    }
    
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
     *
     * @return
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
