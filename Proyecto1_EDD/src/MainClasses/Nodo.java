/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;
/**
 *
 * @author Angel Granado
 */
public class Nodo<T> {

    private T tInfo;
    private Nodo<T> nextNodo;

    /**
     * Constructor de la clase nodo
     *
     * @param tInfo
     */
    public Nodo(T tInfo) {
        this.tInfo = tInfo;
        this.nextNodo = null;
    }
    
    public Nodo(){
        this.tInfo = null;
        this.nextNodo = null;
    }

    /**
     * Getter method para acceder al atributo tInfo
     *
     * @return tInfo
     */
    public T gettInfo() {
        return tInfo;
    }

    /**
     * @param tInfo the tInfo to set
     */
    public void settInfo(T tInfo) {
        this.tInfo = tInfo;
    }

    /**
     * Getter method para acceder al nodo nextNodo
     *
     * @return the nextNodo
     */
    public Nodo<T> getNextNodo() {
        return nextNodo;
    }

    /**
     * @param nextNodo
     */
    public void setNextNodo(Nodo<T> nextNodo) {
        this.nextNodo = nextNodo;
    }
    @Override
    public String toString(){
        return tInfo.toString();
    }

}
