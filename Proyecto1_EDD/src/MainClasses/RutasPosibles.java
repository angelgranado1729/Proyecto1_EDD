/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class RutasPosibles extends LinkedList<RutasYDistancias>{
    
    public void addAfter(Node<RutasYDistancias> node, RutasYDistancias tInfo){
        if (node != null){
            if (node == last()){
                addEnd(tInfo);
            } else {
                Node<RutasYDistancias> pAux = new Node<>(tInfo);
                pAux.setNextNode(next(node));
                node.setNextNode(pAux);
                this.setiSize(this.getiSize() + 1);
            }
        }
    }

    //insertar de forma ordenada, suponiendo que la lista esta ordenada
    public void insertOrdered(RutasYDistancias tInfo, int target){
        if (!isEmpty()){
            Node<RutasYDistancias> pAux = first();
            if (pAux.getTInfo().getDistancias()[target] >  tInfo.getDistancias()[target]){
                addFirst(tInfo);
            } else {
                while (next(pAux) != null && next(pAux).getTInfo().getDistancias()[target] < tInfo.getDistancias()[target] ){
                    pAux = next(pAux);
                }
                addAfter(pAux, tInfo);
            }
        } else {
            addFirst(tInfo);
        }
    }
    

   
}
