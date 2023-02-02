/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
class LinkedList<T> {

    private int iSize;
    private Nodo<T> firstNodo;
    private Nodo<T> lastNodo;

    /*
    *Constructor de la clase
     */
    public LinkedList() {
        this.iSize = 0;
        this.firstNodo = null;
        this.lastNodo = null;
    }

    public Nodo<T> first() {
        return firstNodo;
    }

    public Nodo<T> last() {
        return lastNodo;
    }
    
 /**
     * @param firstNodo the firstNodo to set
     */
    public void setFirstNodo(Nodo<T> firstNodo) {
        this.firstNodo = firstNodo;
    }

    /**
     * @param lastNodo the lastNodo to set
     */
    public void setLastNodo(Nodo<T> lastNodo) {
        this.lastNodo = lastNodo;
    }
    
    public Nodo<T> next(Nodo<T> pNodo) {
        if (pNodo != null) {
            return pNodo.getNextNodo();
        }
        return null;
    }
    
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

    public boolean isEmpty() {
        return firstNodo == null;
    }

    public void destroy() {
        setFirstNodo(null);
        iSize = 0;
        setLastNodo(null);
    }

    public int size() {
        return iSize;
    }

    public void insertFirst(T tInfo) {
        Nodo<T> NodoAux = new Nodo<>(tInfo);
        NodoAux.setNextNodo(first());
        if (isEmpty()) {
            setLastNodo(NodoAux);
        }
        setFirstNodo(NodoAux);
        iSize++;
    }
    
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
    
    public T getInfo(Nodo<T> nodo){
        return nodo.gettInfo();
    }

    public Nodo<T> search(T tInfo) {
        if (!isEmpty()) {
            Nodo<T> auxNodo = first();
            while (auxNodo != null) {
                if (auxNodo.gettInfo().equals(tInfo)) {
                    return auxNodo;
                }
                auxNodo = next(auxNodo);
            }
        }
        return null;
    }

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

    public void delateByInfo(T tInfo) {
        if (!isEmpty()){
            Nodo<T> nodo = search(tInfo);
            if (nodo != null){
                delate(nodo);
            }
        }
    }
    
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
