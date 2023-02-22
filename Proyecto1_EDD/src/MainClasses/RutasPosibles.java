/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class RutasPosibles extends LinkedList<RutaYDistancia>{
    
    public void addAfter(Node<RutaYDistancia> node, RutaYDistancia tInfo){
        if (node != null){
            if (node == last()){
                addEnd(tInfo);
            } else {
                Node<RutaYDistancia> pAux = new Node<>(tInfo);
                pAux.setNextNode(next(node));
                node.setNextNode(pAux);
                this.setiSize(this.getiSize() + 1);
            }
        }
    }

    //insertar de forma ordenada, suponiendo que la lista esta ordenada
    public void insertOrdered(RutaYDistancia tInfo){
        if (!isEmpty()){
            Node<RutaYDistancia> pAux = first();
            if (pAux.getTInfo().distancia>  tInfo.distancia){
                addFirst(tInfo);
            } else {
                while (pAux.getTInfo().distancia < tInfo.distancia && pAux != last()){
                    pAux = next(pAux);
                }
                addAfter(pAux, tInfo);
            }
        } else {
            addFirst(tInfo);
        }
    }
       

   
}
