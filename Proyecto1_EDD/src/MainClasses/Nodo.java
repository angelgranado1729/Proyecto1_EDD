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
public class Nodo<T> {
    
    /**
     * La informacion que guarda el nodo.
     */
    private T tInfo;
    /**
     * Nodo que predecesor.
     */
    private Nodo<T> nextNodo;

    /**
     * Constructor de la clase.
     *
     * @param tInfo informacion a guardar.
     */
    public Nodo(T tInfo) {
        this.tInfo = tInfo;
        this.nextNodo = null;
    }
    
    /**
     * COnstructor de la clase.
     */
    public Nodo(){
        this.tInfo = null;
        this.nextNodo = null;
    }

    /**
     * Getter para acceder al atributo tInfo
     *
     * @return tInfo informacion guardada en el nodo.
     */
    public T gettInfo() {
        return tInfo;
    }

    /**
     * Setter para modificar la informacion almacenada en el nodo.
     * 
     * @param tInfo nueva informacion a guardar en el nodo.
     */
    public void settInfo(T tInfo) {
        this.tInfo = tInfo;
    }

    /**
     * Getter para acceder al nodo predecesor.
     *
     * @return the nextNodo
     */
    public Nodo<T> getNextNodo() {
        return nextNodo;
    }

    /**
     * Setter para modicicar el nodo predecesor.
     * @param nextNodo nuevo predecesor del nodo.
     */
    public void setNextNodo(Nodo<T> nextNodo) {
        this.nextNodo = nextNodo;
    }
    
    /**
     * Retorna un string con la informacion guardada en el nodo.
     * 
     * @return string
     */
    @Override
    public String toString(){
        return tInfo.toString();
    }

}
