/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
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
    private Nodo<T> rear;
    
    /**
     * Constructor
     */
    
    public Queue(){
        this.length = 0;
        this.front = this.rear = null;
    }
    
    /**
     * Retorna el nodo que le precede
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
     * ultimo nodo en cola, y desplaza el rear nodo al 
     * siguiente nodo.
     * 
     * @param tInfo informacion a almacenar
     */
    public void enqueue(T tInfo){
        Nodo<T> newNodo = new Nodo(tInfo);
        if (isEmpty()){
            this.front = newNodo;
        } else {
            this.rear = newNodo;
        }
        length++;
    }
    
    /**
     * Saca el primer nodo en cola.
     * 
     * @throws Exception No hay elementos en cola.
     * @return aux el elemento que guarda el primer nodo
     * en cola.
     */
    public T dequeue() throws Exception {
        T aux;
        if (!isEmpty()){
            aux = front.gettInfo();
            front = next(front);
            length--;
        } else throw new Exception("No hay elementos en cola.");
        return aux;
    }
    
    /**
     * Libera todos los nodo que estan en la cola.
     */
    public void destroyQueue(){
        for(; front != null;){
            front = next(front);
        }
        System.gc();
    }
    
    
}
