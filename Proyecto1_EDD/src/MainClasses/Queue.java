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
     * Constructor de la clase.
     */
    
    public Queue(){
        this.length = 0;
        this.front = this.rear = null;
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
     * @return rear el ultimo nodo en cola.
     */
    public Nodo<T> getRear(){
        return rear;
    }
    
    /**
     * Setter para modificar el ultimo nodo en cola.
     * 
     * @param newRear nuevo nodo que sera el ultimo de la cola.
     */
    public void setRear(Nodo<T> newRear){
        this.rear = newRear;
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
            this.front = next(front);
            length--;
        } else throw new Exception("No hay elementos en cola.");
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
