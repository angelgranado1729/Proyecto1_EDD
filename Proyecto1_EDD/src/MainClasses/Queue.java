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
public class Queue<T> {
    private int length;
    /**
     * Primer elemento de la cola, primero en salir.
     */
    private Nodo<T> front;
    /**
     * Ultimo elemento de la cola, ultimo en salir
     */
    private Nodo<T> back;
    
    /**
     * Constructor de la clase.
     */
    
    public Queue(){
        this.length = 0;
        this.front = this.back = null;
    }
    
    /**
     * Getter para acceder a length.
     * 
     * @return length el tamaño de la cola.
     */
    public int getLength(){
        return length;
    }
    
    /**
     * Setter para modificarl a length.
     * 
     * @param newLength nuevo tamaño de la cola.
     */
    public void setLegth(int newLength){
        this.length = newLength;
    }
    
    /**
     * Getter para acceder al primer nodo en cola.
     * 
     * @return front primer nodo en la cola.
     */
    public Nodo<T> getFront(){
        return front;
    }
    
    /**
     * Setter para modificar el primer nodo en cola.
     * 
     * @param newFront el nuevo nodo que estara al inicio de la cola.
     */
    public void setFrond(Nodo<T> newFront){
        this.front = newFront;
    }
    
    /**
     * Getter para acceder al ultimo nodo en cola.
     * 
     * @return back el ultimo nodo en cola.
     */
    public Nodo<T> getback(){
        return back;
    }
    
    /**
     * Setter para modificar el ultimo nodo en cola.
     * 
     * @param newback nuevo nodo que sera el ultimo de la cola.
     */
    public void setback(Nodo<T> newback){
        this.back = newback;
    }
    
    /**
     * Retorna el nodo que le precede.
     * 
     * @param nodo nodo dado
     * @return nextNodo 
     */
    public Nodo<T> next(Nodo<T> nodo){
        return nodo.getNextNodo();
    }
    
    /**
     * Verifica si no hay elementos en cola.
     * 
     * @return boolean true si no hay nodos en cola
     * false si hay al menos un nodo en la cola.
     */
    public boolean isEmpty(){
        return front == null;
    }
    
    /**
     * Inserta un nodo con la informacion dada despues del
     * ultimo nodo en cola, y desplaza el back nodo al 
     * siguiente nodo.
     * 
     * @param tInfo informacion a almacenar
     */
    public void enqueue(T tInfo){
        Nodo<T> newNodo = new Nodo(tInfo);
        if (isEmpty()){
            front = newNodo;
        } else {
            back.setNextNodo(newNodo);
        }
        back = newNodo;
        length++;
    }
    
    /**
     * Saca el primer nodo en cola.
     * 
     * @return aux el elemento que guarda el primer nodo
     * en cola.
     */
    public T dequeue(){
        T aux = null;
        if (!isEmpty()){
            aux = front.gettInfo();
            this.front = next(front);
            length--;
        } 
        return aux;
    }
    
    /**
     * Libera todos los nodo que estan en la cola.
     */
    public void destroyQueue(){
        for(; front != null;){
            this.front = next(front);
        }
        System.gc();
    }
    
    
}
