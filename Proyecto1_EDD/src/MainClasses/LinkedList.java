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
    
    // Interfaz para definir los métodos que se pueden sobreescribir
    public interface LinkedListMethods<T>{
        int compareTo(T tInfo1, T tInfo2);
        int hashCode(T tInfo);
        boolean equals(T tInfo1, T tInfo2);
    }
    
    // Clase privada para definir los métodos por defecto
    private class DefaultMethods implements LinkedListMethods<T>{

        @Override
        public int compareTo(T tInfo1, T tInfo2) {
            return tInfo1.toString().compareToIgnoreCase(tInfo2.toString());
        }

        public void print(T tInfo) {
            System.out.println(tInfo.toString());
        }
        
        public Node<T> search(T tInfo) {
            Node<T> pAux = getpFirst();
            while (pAux != null){
                if (getMethods().equals(pAux.getTInfo(), tInfo)) return pAux;
                pAux = pAux.getNextNode();
            }
            return null;
        }

        @Override
        public int hashCode(T tInfo) {
            return tInfo.hashCode();
        }

        @Override
        public boolean equals(T tInfo1, T tInfo2) {
            return tInfo1.equals(tInfo2);
        }
        
    }

    // Atributos de la clase
    private Node<T> pFirst;
    private int iSize;
    private LinkedListMethods<T> methods;

    /**
     * Constructor de la clase
     */
    public LinkedList(){
        this.pFirst = null;
        this.iSize = 0; 
        this.methods = new DefaultMethods();
    }

    /**
     * Constructor de la clase
     * @param methods 
     */
    public LinkedList(LinkedListMethods<T> methods){
        this.pFirst = null;
        this.iSize = 0; 
        this.methods = methods;
    }

    public LinkedListMethods<T> getMethods() {
        return methods;
    }

    public void setMethods(LinkedListMethods<T> methods) {
        this.methods = methods;
    }

    public void destroy(){
        Node<T> pAux = getpFirst();
        while (pAux != null){
            pAux = getpFirst();
            setpFirst(next(pAux));
            pAux = null;
        }
        setiSize(0);
        System.gc();
    }

    public Node<T> next(Node<T> pNode){
        if (pNode != null){
            return pNode.getNextNode();
        } else {
            return null;
        }
    }

    public boolean isEmpty(){
        return getpFirst() == null;
    }

    public int size(){
        return getiSize();
    }

    public Node<T> first(){
        return getpFirst();
    }

    public Node<T> last(){
        if (!isEmpty()){
            Node<T> pAux = getpFirst();
            while (next(pAux) != null){
                pAux = next(pAux);
            }
            return pAux;
        }
        return null;
    }
    

    public T getData(Node<T> pNode){
        if (pNode != null){
            return pNode.getTInfo();
        } else {
            return null;
        }
    }

    public Node<T> getNode(int index){
        if (!isEmpty()){
            if (index >= 0 && index < getiSize()){
                Node<T> pAux = getpFirst();
                for (int i = 0; i < index; i++){
                    pAux = next(pAux);
                }
                return pAux;            
            }
            return null;
        }
        return null;
    }

    public int indexOf(Node<T> pNode){
        if (!isEmpty() && pNode != null){
            Node<T> pAux = getpFirst();
            int index = 0;
            while (pAux != null){
                if (pAux.equals(pNode)){
                    return index;
                }
                pAux = next(pAux);
                index++;
            }
            return -1;
        }
        return -1;
    }

    public boolean isElement(Node<T> Node){
        int index = indexOf(Node);
        return index != -1;
    }

    public Node<T> search(T tInfo){
        if (!isEmpty()){
            Node<T> pAux = getpFirst();
            while (pAux != null){
                if (pAux.getTInfo().equals(tInfo)){
                    return pAux;
                }
                pAux = next(pAux);
            }
            return null;
        }
        return null;
    }

    public void deleteFirst(){
        if (!isEmpty()){
            Node<T> pAux = getpFirst();
            setpFirst(next(pAux));
            pAux = null;
            setiSize(getiSize() - 1);
        }
    }
    
    public void deleteLast(){
        if (!isEmpty()){
            Node<T> pAux = getpFirst();
            Node<T> pAux2;
            while (next(next(pAux)) != null){
                pAux = next(pAux);
            }
            pAux2 = next(pAux);
            pAux.setNextNode(next(pAux2));
            pAux2 = null;
            setiSize(getiSize() - 1);

        }
    }

    public void delete(Node<T> pNode){
        if (!isEmpty() && pNode != null){
            Node<T> pAux = getpFirst();
            if (pNode.equals(getpFirst())){
                setpFirst(next(pAux));
                pNode = null;
                setiSize(getiSize() - 1);
            } else {
                while (next(pAux) != null && !(next(pAux).equals(pNode))){
                    pAux = next(pAux);
                }
                if (next(pAux) != null){
                    pAux.setNextNode(next(pNode));
                    pNode = null;
                    setiSize(getiSize() - 1);
                }
            }
        }
    }

    public void delete(T tInfo){
        if (!isEmpty()){
            Node<T> pAux = getpFirst();
            if (getpFirst().getTInfo().equals(tInfo)){
                setpFirst(next(pAux));
                setiSize(getiSize() - 1);
            } else {
                while (next(pAux) != null && !(next(pAux).getTInfo().equals(tInfo))){
                    pAux = next(pAux);
                }
                if (next(pAux) != null){
                    pAux.setNextNode(next(next(pAux)));
                    setiSize(getiSize() - 1);
                }
            }
        }
    }

    public void pop(int index){
        if (!isEmpty()){
            if (index >= 0 && index < getiSize()){
                Node<T> pAux = getpFirst();
                if (index == 0){
                    setpFirst(next(pAux));
                } else {
                    Node<T> pAux2;
                    for (int i = 0; i < index-1; i++){
                        pAux = next(pAux);
                    }
                    pAux2 = next(pAux);
                    pAux.setNextNode(next(pAux2));
                    pAux2 = null;
                }
                setiSize(getiSize() - 1);
            }
        }
    }

    public Node<T> deleteAndReturn(Node<T> pNode){
        if (!isEmpty()){
            if (pNode != null){
                Node<T> pAux = getpFirst();
                if (pNode.equals(getpFirst())){
                    setpFirst(next(pAux));
                    setiSize(getiSize() - 1);
                    return pNode;
                } else {
                    while (next(pAux) != null && !(next(pAux).equals(pNode))){
                        pAux = next(pAux);
                    }
                    if (next(pAux) != null){
                        pAux.setNextNode(next(next(pAux)));
                        setiSize(getiSize() - 1);
                        return  pNode;
                    }
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    public Node<T> deleteAndReturn(int index){
        if (!isEmpty()){
            if (index >= 0 && index < getiSize()){
                Node<T> pAux = getpFirst();
                if (index == 0){
                    setpFirst(next(pAux));
                    setiSize(getiSize() - 1);
                    return pAux;
                } else {
                    for (int i = 0; i < index - 1; i++){
                        pAux = next(pAux);
                    }
                    pAux.setNextNode(next(next(pAux)));
                    setiSize(getiSize() - 1);
                    return pAux;
                }
            }
            return null;
        }
        return null;
    }


    public void addFirst(Node<T> pNode){
        if (pNode != null){
            pNode.setNextNode(getpFirst());
            setpFirst(pNode);
            setiSize(getiSize() + 1);
        }
    }

    public void addFirst(T tInfo){
        Node<T> pNode = new Node<>(tInfo);
        pNode.setNextNode(getpFirst());
        setpFirst(pNode);
        setiSize(getiSize() + 1);
    }

    public void addEnd(Node<T> pNode){
        if (pNode != null){
            if (isEmpty()){
                setpFirst(pNode);
            } else {
                Node<T> pAux = first();
                while (next(pAux) != null){
                    pAux = next(pAux);
                }
                pAux.setNextNode(pNode);
            }
            setiSize(getiSize() + 1);
        }
    }
    
    public void addEnd(T tInfo){
        Node<T> pNode = new Node<>(tInfo);
        if (isEmpty()){
            setpFirst(pNode);
        } else {
            Node<T> pAux = first();
            while (next(pAux) != null){
                pAux = next(pAux);
            }
            pAux.setNextNode(pNode);
        }
        setiSize(getiSize() + 1);
    }

    public void insertByIndex(Node<T> pNode, int index){
        if (!isEmpty()){
           if (index == 0){
                addFirst(pNode);
           } else if (index == getiSize() -1) {
                addEnd(pNode);
           } else if (index > 0 && index < getiSize() - 1){
                Node<T> pAux = getpFirst();
                for (int i = 0; i < index - 1; i++){
                    pAux = next(pAux);
                }
                pNode.setNextNode(next(pAux));
                pAux.setNextNode(pNode);
                setiSize(getiSize() + 1);
           }
        } else{
            if (index == 0){
                addFirst(pNode);
            }
        }
    }

    public void insertByIndex(T tInfo, int index){
        Node<T> pNode = new Node<>(tInfo);
        if (!isEmpty()){
           if (index == 0){
                addFirst(pNode);
           } else if (index == getiSize() -1) {
                addEnd(pNode);
           } else if (index > 0 && index < getiSize() - 1){
                Node<T> pAux = getpFirst();
                for (int i = 0; i < index - 1; i++){
                    pAux = next(pAux);
                }
                pNode.setNextNode(next(pAux));
                pAux.setNextNode(pNode);
                setiSize(getiSize() + 1);
           }
        } else{
            if (index == 0){
                addFirst(pNode);
            }
        }
    }

    public void toCircularList(){
        if (!isEmpty()){
            Node<T> pAux = first();
            while (next(pAux) != null){
                pAux = next(pAux);
            }
            pAux.setNextNode(getpFirst());
        }
    }

    public void toSimpleList(){
        if (!isEmpty()){
            Node<T> pAux = first();
            while (next(pAux) != first()){
                pAux = next(pAux);
            }
            pAux.setNextNode(null);
        }
    }

    public Node<T> getMiddle(){
        if (!isEmpty()){
            Node<T> pAux = first();
            Node<T> pMiddle = first();

            while (next(pAux) != null && next(next(pAux)) != null){
                pAux = next(next(pAux));
                pMiddle = next(pMiddle);
            }
            return pMiddle;
        } 
        return null;
    }
//
//    private Node<T> sortedMerge(Node<T> a, Node<T> b){
//        Node<T> result;
//        if (a == null){
//            return b;
//        } else if (b == null){
//            return a;
//        }
//
//        if (methods.compareTo(a.getTInfo(), b.getTInfo()) < 0){
//            result = a;
//            result.setNextNode(sortedMerge(next(a), b));
//        } else {
//            result = b;
//            result.setNextNode(sortedMerge(a, next(b)));
//        }
//        return result;
//    }
//
//    private Node<T> mergeSort(Node<T> head){
//        if (head == null || next(head) == null){
//            return head;
//        }
//        Node<T> middle = getMiddle();
//        Node<T> nextOfMiddle = next(middle);
//        middle.setNextNode(null);
//        Node<T> left = mergeSort(head);
//        Node<T> right = mergeSort(nextOfMiddle);
//        Node<T> sortedList = sortedMerge(left, right);
//        return sortedList;
//    }
//
//    public void sort(){
//        pFirst = mergeSort(pFirst);
//    }
//
//    public void sort(Node<T> pNode){
//        pFirst = mergeSort(pNode);
//    }

    public void reverse(){
        Node<T> pAux = first();
        if (pAux != null){
            deleteFirst();
            reverse();
            addEnd(pAux.getTInfo());
        }
    }
    
    public LinkedList<T> returnReverse(){
        LinkedList<T> reverse = new LinkedList<>();
        Node<T> current = first();
        if (current != null){
            deleteFirst();
            reverse = returnReverse();
            reverse.addEnd(current.getTInfo());
            addFirst(current.getTInfo());
        }
        return reverse;
    }

    public LinkedList<T> copy(){
        LinkedList<T> copy = new LinkedList<>();
        Node<T> pAux = first();
        if (pAux != null){
            deleteFirst();
            copy = copy();
            copy.addFirst(pAux.getTInfo());
            addFirst(pAux.getTInfo());
        }
        return copy;
    }

    public void eliminateRepetitions(){
        if (!isEmpty()){
            Node<T> pAux = first();
            Node<T> pAux2;
            while (next(pAux) != null){
                pAux2 = next(pAux);
                while (pAux2 != null){
                    if (pAux.getTInfo().equals(pAux2.getTInfo())){
                        delete(pAux2);
                    }
                    pAux2 = next(pAux2);
                }
                pAux = next(pAux);
            }
        }
    }


    public LinkedList<T> returnWithoutRepetitions(){
        LinkedList<T> withoutRepetitions = copy();
        withoutRepetitions.eliminateRepetitions();
        return withoutRepetitions;
    }

    public void addFirstWithoutRepetitions(T tInfo){
        addFirst(tInfo);
        eliminateRepetitions();
    }

    // AGREGAR EL METODO compareTo
    public void addEndWithoutRepetitions(T tInfo){
        addEnd(tInfo);
        eliminateRepetitions();
    }

    public LinkedList<T> filter(T tInfo){
        LinkedList<T> filter = new LinkedList<>();
        if (!isEmpty()){
            Node<T> pAux = first();
            deleteFirst();
            filter = filter(tInfo);
            if (getMethods().equals(pAux.getTInfo(), tInfo)){
                filter.addEnd(pAux.getTInfo());
            }
            addFirst(pAux);
        }
        return filter;
    }

    //A methods that returns the number of times that a element is repeated in the list
    public int repeated(T tInfo){
        int repeated = 0;
        if (!isEmpty()){
            Node<T> pAux = first();
            deleteFirst();
            repeated = repeated(tInfo);
            if (getMethods().compareTo(pAux.getTInfo(), tInfo) == 0){
                repeated++;
            }
            addFirst(pAux);
        }
        return repeated;
    }
    

    //A method that returns the nodes that are repeated in the list
    public LinkedList<T> repeatedNodes(){
        LinkedList<T> repeatedNodes = new LinkedList<>();
        if (!isEmpty()){
            Node<T> pAux = first();
            deleteFirst();
            repeatedNodes = repeatedNodes();
            if (repeated(pAux.getTInfo()) > 1){
                repeatedNodes.addFirst(pAux);
            }
            addFirst(pAux);
        }
        return repeatedNodes;
    }
            

    public void replace(Node<T> node, Node<T> newNode){
        if (node != null && newNode != null){
            if (node == first()){
                deleteFirst();
                addFirst(newNode.getTInfo());
            } else if (node == last()){
                deleteLast();
                addEnd(newNode.getTInfo());
            } else {
                Node<T> pAux = first();
                while (next(pAux) != node){
                    pAux = next(pAux);
                }
                pAux.setNextNode(newNode);
                newNode.setNextNode(next(node));
            }
        }
    }

    public boolean detectLoop(){
        if (!isEmpty()){
            Node<T> pSlow = first();
            Node<T> pFast = first();
            while (pSlow != null && pFast != null && next(pFast) != null){
                pSlow = next(pSlow);
                pFast = next(next(pFast));
                if (pSlow == pFast){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Node<T> findLoopStart(){
        boolean loop = detectLoop();
        if (loop){
            Node<T> pSlow = first();
            Node<T> pFast = first();
            while (pSlow != null && pFast != null && next(pFast) != null){
                pSlow = next(pSlow);
                pFast = next(next(pFast));
                if (pSlow == pFast){
                    pSlow = first();
                    while (pSlow != pFast){
                        pSlow = next(pSlow);
                        pFast = next(pFast);
                    }
                    return pSlow;
                }
            }
        }
        return null;
    }

    public void detectAndRemoveLoop(){
        Node<T> loopStart = findLoopStart();
        if (loopStart != null){
            Node<T> pAux = loopStart;
            while (next(pAux) != loopStart){
                pAux = next(pAux);
            }
            pAux.setNextNode(null);
        }
    }

    public int nodesInLoop(){
        Node<T> loopStart = findLoopStart();
        if (loopStart != null){
            Node<T> pAux = loopStart;
            int nodes = 1;
            while (next(pAux) != loopStart){
                pAux = next(pAux);
                nodes++;
            }
            return nodes;
        }
        return 0;
    }
    
    public void addAndSetNext(Node<T> node, Node<T> nextNode){
        if (node != null && nextNode != null){
            if (node == first()){
                deleteFirst();
                addFirst(node.getTInfo());
                node.setNextNode(nextNode);
            } else if (node == last()){
                deleteLast();
                addEnd(node.getTInfo());
                node.setNextNode(nextNode);
            } else {
                Node<T> pAux = first();
                while (next(pAux) != node){
                    pAux = next(pAux);
                }
                pAux.setNextNode(node);
                node.setNextNode(nextNode);
            }
        }
    }

    public void delateAll(){
        setpFirst(null);
        setiSize(0);
        System.gc();
    }

    // sort a linked list using bublle sort 
    public void bubleSort(){
        if (!isEmpty()){
            Node<T> pAux = first();
            while (pAux != null){
                Node<T> pAux2 = next(pAux);
                while (pAux2 != null){
                    if (getMethods().compareTo(pAux.getTInfo(), pAux2.getTInfo()) > 0){
                        T aux = pAux.getTInfo();
                        pAux.setTInfo(pAux2.getTInfo());
                        pAux2.setTInfo(aux);
                    }
                    pAux2 = next(pAux2);
                }
                pAux = next(pAux);
            }
        }
    }

    // sort a linked list using insertion sort
    public void insertionSort(){
        if (!isEmpty()){
            Node<T> pAux = first();
            while (pAux != null){
                Node<T> pAux2 = next(pAux);
                while (pAux2 != null){
                    if (getMethods().compareTo(pAux.getTInfo(), pAux2.getTInfo()) > 0){
                        T aux = pAux.getTInfo();
                        pAux.setTInfo(pAux2.getTInfo());
                        pAux2.setTInfo(aux);
                    }
                    pAux2 = next(pAux2);
                }
                pAux = next(pAux);
            }
        }
    }
    
    public int indexOf(T data){
        if (!isEmpty()){
          int index = 0;
          Node<T> aux = this.getpFirst();
          while (aux != null){
              if (methods.equals(data, data)){
                  return index;
              }
              index++;
          }
        }
        return -1;
        
    }
    
    

    @Override
    public String toString(){
        String s = "";
        if (!isEmpty()){
            Node<T> pAux = first();
            while (pAux != null){
                s += pAux.getTInfo() + "\n";
                pAux = next(pAux);
            }
        }
        return s;
    }

    /**
     * @return the pFirst
     */
    public Node<T> getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Node<T> pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the iSize
     */
    public int getiSize() {
        return iSize;
    }

    /**
     * @param iSize the iSize to set
     */
    public void setiSize(int iSize) {
        this.iSize = iSize;
    }
}
