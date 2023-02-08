/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 * @param <T>
 */
public class LinkedList<T> {
    
    /**
     * Tamaño de la lista.
     */
    private int iSize;
    /**
     * Primer nodo de la lista.
     */
    private Nodo<T> firstNodo;
    /**
     * Ultimo nodo de la lista.
     */
    private Nodo<T> lastNodo;

    /**
     * Constructor de la clase.
     */
    public LinkedList() {
        this.iSize = 0;
        this.firstNodo = null;
        this.lastNodo = null;
    }
    
    /**
     * Retorna el primer nodo de la lista.
     * 
     * @return firstNodo
     */
    public Nodo<T> first() {
        return firstNodo;
    }
    
    /**
     * Retorna el ultimo nodo de la lista/
     * 
     * @return lastNodo
     */
    public Nodo<T> last() {
        return lastNodo;
    }
    
    /**
     * Setter para modificar el primer nodo de la lista.
     * 
     * @param firstNodo el nuevo nodo que sera el primero de la lista.
     */
    public void setFirstNodo(Nodo<T> firstNodo) {
        this.firstNodo = firstNodo;
    }

    /**
     * Setter para modificar el ultimo nodo de la lista.
     * 
     * @param lastNodo el nuevo nodo que sera el ultimo de la lista.
     */
    public void setLastNodo(Nodo<T> lastNodo) {
        this.lastNodo = lastNodo;
    }
    
    /**
     * Retorna el siguiente nodo enlazado.
     * 
     * @param pNodo el nodo dado.
     * @return nextNodo el siguiente nodo.
     */
    public Nodo<T> next(Nodo<T> pNodo) {
        Nodo<T> nextNodo = null;
        if (pNodo != null) {
            nextNodo = pNodo.getNextNodo();
            return nextNodo;
        }
        return nextNodo;
    }
    
    /**
     * Metodo que retorna el nodo que se encuentra en el punto 
     * medio de la lista, dado un punto inicial.
     * 
     * @param startNodo nodo inicial.
     * @return middleNodo
     */
    public Nodo<T> getMiddle(Nodo<T> startNodo){
        if (startNodo == null){
            return null;
        }
        Nodo<T> middleNodo = startNodo, finalNodo = startNodo;
        
        while (next(finalNodo) != null && next(next(finalNodo)) != null){
            finalNodo = next(next(finalNodo));
            middleNodo = next(middleNodo);
        }
        return middleNodo;        
    }
    
    /**
     * Verifica si la lista esta vacia.
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return firstNodo == null;
    }
    
    /**
     * Procedimiento que destruye completamente la lista.
     */
    public void destroy() {
        setFirstNodo(null);
        iSize = 0;
        setLastNodo(null);
    }
    
    /**
     * Retorna el tamaño de la lista.
     * 
     * @return iSize
     */
    public int size() {
        return iSize;
    }
    
    /**
     * Metodo que inserta un nodo con la informacion dada a 
     * insertar en la primera posicion de la lista.
     * 
     * @param tInfo informacion a insertar
     */
    public void insertFirst(T tInfo) {
        Nodo<T> NodoAux = new Nodo<>(tInfo);
        NodoAux.setNextNodo(first());
        if (isEmpty()) {
            setLastNodo(NodoAux);
        }
        setFirstNodo(NodoAux);
        iSize++;
    }
    
    /**
     * Metodo que inserta un nodo con la informacion dada a 
     * insertar, en la posicion siguiente de un nodo dado.
     * 
     * @param tInfo informacion a insertar.
     * @param position nodo de referencia.
     */
    public void postInsert(T tInfo, Nodo<T> position) {
        Nodo<T> newNodo = new Nodo<>(tInfo);        
        if (isEmpty()){
            setFirstNodo(newNodo);
            setLastNodo(newNodo);
        } else {
            newNodo.setNextNodo(position.getNextNodo());
            position.setNextNodo(newNodo);
            if (position.equals(lastNodo)){
                setLastNodo(newNodo);
            }
        }
        iSize++;
    }
    
    /**
     * Metodo que inserta un nodo con la informacion dada a 
     * insertar, en la posicion anterior a un nodo dado.
     * 
     * @param tInfo informacion a insertar.
     * @param position nodo de referencia.
     */
    public void preInsert(T tInfo, Nodo<T> position){
        Nodo<T> newNodo = new Nodo<>(tInfo);
        if (isEmpty()){
            setFirstNodo(newNodo);  
            setLastNodo(newNodo);
        } else if (position.equals(firstNodo)){
            newNodo.setNextNodo(firstNodo);
            setFirstNodo(newNodo);
        } else {
            Nodo<T> auxNodo = first();
            while (!(next(auxNodo).equals(position))){
                auxNodo = next(auxNodo);
            }
            newNodo.setNextNodo(position);
            auxNodo.setNextNodo(newNodo);
        }
        iSize++;
    }
    
    /**
     * Agrega en la ultima posicion, un nodo con la 
     * informacion dada.
     * 
     * @param tInfo informacion a insertar.
     */
    public void append(T tInfo) {
        Nodo<T> auxNodo = new Nodo<>(tInfo);
        if (isEmpty()) {
            setFirstNodo(auxNodo);
        } else {
            lastNodo.setNextNodo(auxNodo);
        }
        setLastNodo(auxNodo);
        iSize++;
    }
    
    /**
     * Inserta un nodo con la informacion dada, en la 
     * posicion indicada.
     * 
     * @param tInfo informacion a insertar.
     * @param index posicion indicada.
     */
    public void insert(T tInfo, int index) {
        if (index == 0){
            insertFirst(tInfo);
        } else if (index == size() - 1){
            append(tInfo);
        } else if (index > 0 && index < size()-1){
            Nodo<T> auxNodo = first();
            for (int num = 0; num <index-1; num++){
                auxNodo = next(auxNodo);
            }
            postInsert(tInfo, auxNodo);            
        } else {
        }
    }
   
    /**
     * Metodo que accede a los nodos de la lista a traves
     * de la posicion que ocupan.
     * 
     * @param index posicion del nodo.
     * @return auxNodo nodo a acceder.
     */
    public Nodo<T> getByIndex(int index) {
        if (index >= 0 && index < iSize) {
            int aux = 0;
            Nodo<T> auxNodo = first();
            while (aux != index) {
                auxNodo = next(auxNodo);
                aux++;
            }
            return auxNodo;
        }
        return null;
    }
    
    /**
     * Retorna la informacion que almacena el nodo dado.
     * 
     * @param nodo nodo dado.
     * @return tInfo informacion que guarda el nodo.
     */
    public T getInfo(Nodo<T> nodo){
        return nodo.gettInfo();
    }

    /**
     * Busca un nodo en la lista que este guardando
     * la informacion dada.
     * 
     * @param tInfo informacion dada.
     * @return auxNodo nodo con la informacion dada.
     */
    public Nodo<T> search(T tInfo) {
        if (!isEmpty()) {
            Nodo<T> auxNodo;
            for (auxNodo = first(); auxNodo != null; auxNodo = next(auxNodo)){
                if (auxNodo.gettInfo().equals(tInfo)){
                    return auxNodo;
                }
            }
            return null;
        }
        return null;    
    }
    
    /**
     * Procedimiento que elimina el primer nodo de la lista.
     */
    public void delateAtStart() {
        if (iSize == 1) {
            destroy();
        } else if (iSize > 1) {
            Nodo<T> auxNodo = first();
            setFirstNodo(auxNodo.getNextNodo());
            iSize--;
        } else {
        }
    }

    /**
     * Procedimiento que elimina el primer nodo de la lista.
     */
    public void delateAtEnd() {
        if (iSize == 1) {
            destroy();
        } else if (iSize > 1) {
            Nodo<T> auxNodo = first();
            while (!(next(auxNodo).equals(last()))) {
                auxNodo = next(auxNodo);
            }
            auxNodo.setNextNodo(null);
            setLastNodo(auxNodo);
            iSize--;
        }
    }
    
    /**
     * Elimina el nodo que ocupa la posicion dada.
     * 
     * @param index posicion dada.
     */
    public void delate(int index) {
        if (index >= 0 && index < iSize) {
            Nodo<T> auxNodo = first();
            for (int num = 0; num <= index - 1; num++) {
                auxNodo = next(auxNodo);
            }
            Nodo<T> tempNodo = auxNodo.getNextNodo();
            auxNodo.setNextNodo(tempNodo.getNextNodo());
            iSize--;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * Elimina el nodo dado.
     * 
     * @param nodo nodo dado.
     */
    public void delate(Nodo<T> nodo){
        if (!isEmpty() && nodo != null){
            if (nodo.equals(firstNodo)){
                delateAtStart();
            } else if (nodo.equals(firstNodo)){
                delateAtEnd();
            } else{
                Nodo<T> auxNodo = first();
                while (!(next(auxNodo).equals(nodo))){
                    auxNodo =next(auxNodo);
                }
                auxNodo.setNextNodo(next(nodo));
                iSize--;
            }
        } 
    }
    
    /**
     * Elimina un nodo que este guardando la informacion dada.
     * 
     * @param tInfo informacion dada.
     */
    public void delateByInfo(T tInfo) {
        if (!isEmpty()){
            Nodo<T> nodo = search(tInfo);
            if (nodo != null){
                delate(nodo);
            }
        }
    }
    
    /**
     * Retorna un string con toda la informacion de la instacia.
     * 
     * @return string
     */
    @Override
    public String toString(){
        String string = "";
        if (!isEmpty()){
            Nodo<T> auxNodo = first();
            while (auxNodo != null){
                string += auxNodo.gettInfo() + "\n";
                auxNodo = next(auxNodo);
            }
            return string;
        }
        return string;
    }
       
}
