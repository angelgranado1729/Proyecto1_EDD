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
    public interface LinkedListMethods<T> {

        int compareTo(T tInfo1, T tInfo2);

        int hashCode(T tInfo);

        boolean equals(T tInfo1, T tInfo2);
    }

    // Clase privada para definir los métodos por defecto
    private class DefaultMethods implements LinkedListMethods<T> {

        @Override
        public int compareTo(T tInfo1, T tInfo2) {
            return tInfo1.toString().compareToIgnoreCase(tInfo2.toString());
        }

        public void print(T tInfo) {
            System.out.println(tInfo.toString());
        }

        public Node<T> search(T tInfo) {
            Node<T> pAux = getpFirst();
            while (pAux != null) {
                if (getMethods().equals(pAux.getTInfo(), tInfo)) {
                    return pAux;
                }
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
    public LinkedList() {
        this.pFirst = null;
        this.iSize = 0;
        this.methods = new DefaultMethods();
    }

    /**
     * Constructor de la clase
     *
     * @param methods
     */
    public LinkedList(LinkedListMethods<T> methods) {
        this.pFirst = null;
        this.iSize = 0;
        this.methods = methods;
    }

    /**
     * Getter para acceder a los metodos utilies de la lista.
     *
     * @return la clase de los metodos de la lista.
     */
    public LinkedListMethods<T> getMethods() {
        return methods;
    }

    /**
     * Setter para modificar los metodos utilies de la lista.
     *
     * @param methods, los nuevos metodos utilies de la lista.
     */
    public void setMethods(LinkedListMethods<T> methods) {
        this.methods = methods;
    }

    /**
     * Destruye la lista completamente.
     */
    public void destroy() {
        Node<T> pAux = getpFirst();
        while (pAux != null) {
            pAux = getpFirst();
            setpFirst(next(pAux));
            pAux = null;
        }
        setiSize(0);
        System.gc();
    }

    /**
     * Dado un nodo de la lista, retorna el siguiente nodo enlazado.
     *
     * @param pNode, un nodo que pertenece a la lista.
     * @return null si el nodo dado no pertenece a la lista o si es el ultimo,
     * en caso contrario retorna el siguiente nodo enlazado.
     */
    public Node<T> next(Node<T> pNode) {
        if (pNode != null) {
            return pNode.getNextNode();
        } else {
            return null;
        }
    }

    /**
     * Verifica si la lista es vacia.
     *
     * @return retorna true si la lista esta vacia, en caso contrario retorna
     * false.
     */
    public boolean isEmpty() {
        return getpFirst() == null;
    }

    /**
     * Retorna el numero de nodos que conforman la lista.
     *
     * @return el tamaño de la lista.
     */
    public int size() {
        return getiSize();
    }

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return el primer nodo.
     */
    public Node<T> first() {
        return getpFirst();
    }

    /**
     * Retorna el ultimo nodo de la lista.
     *
     * @return el ultimo nodo.
     */
    public Node<T> last() {
        if (!isEmpty()) {
            Node<T> pAux = getpFirst();
            while (next(pAux) != null) {
                pAux = next(pAux);
            }
            return pAux;
        }
        return null;
    }

    /**
     * Dado un nodo de la lista, retorna el contenido que guarda.
     *
     * @param pNode, el nodo dado.
     * @return null si el nodo es null, en caso contrario retorna el contenido
     * que guarda.
     */
    public T getData(Node<T> pNode) {
        if (pNode != null) {
            return pNode.getTInfo();
        } else {
            return null;
        }
    }

    /**
     * Retorna el nodo a traves de la posicion que ocupa en la lista.
     *
     * @param index, la posicion que ocupa el nodo.
     * @return el nodo en la posicion dada, en caso contrario retorna null.
     */
    public Node<T> getNode(int index) {
        if (!isEmpty()) {
            if (index >= 0 && index < getiSize()) {
                Node<T> pAux = getpFirst();
                for (int i = 0; i < index; i++) {
                    pAux = next(pAux);
                }
                return pAux;
            }
            return null;
        }
        return null;
    }

    /**
     * Retorna la posicion del nodo dado.
     *
     * @param pNode, el nodo dado.
     * @return retorna la posicion que ocupa el nodo en la lista. Si el nodo es
     * null, la lista esta vacia o si el nodo no pertence a la lista, retorna
     * -1.
     */
    public int indexOf(Node<T> pNode) {
        if (!isEmpty() && pNode != null) {
            Node<T> pAux = getpFirst();
            int index = 0;
            while (pAux != null) {
                if (pAux.equals(pNode)) {
                    return index;
                }
                pAux = next(pAux);
                index++;
            }
            return -1;
        }
        return -1;
    }

    /**
     * Verifica si un nodo pertenece a la lista.
     *
     * @param Node, el nodo dado.
     * @return
     */
    public boolean isElement(Node<T> Node) {
        int index = indexOf(Node);
        return index != -1;
    }

    /**
     * Retorna el nodo que guarda la informacion dada.
     *
     * @param tInfo, la informacion dada.
     * @return el nodo que guarda la informacion, en caso contrario retorna
     * null.
     */
    public Node<T> search(T tInfo) {
        if (!isEmpty()) {
            Node<T> pAux = getpFirst();
            while (pAux != null) {
                if (pAux.getTInfo().equals(tInfo)) {
                    return pAux;
                }
                pAux = next(pAux);
            }
            return null;
        }
        return null;
    }

    /**
     * Elimina el primer nodo de la lista.
     */
    public void deleteFirst() {
        if (!isEmpty()) {
            Node<T> pAux = getpFirst();
            setpFirst(next(pAux));
            pAux = null;
            setiSize(getiSize() - 1);
        }
    }

    /**
     * Elimina el ultimo nodo de la lista.
     */
    public void deleteLast() {
        if (!isEmpty()) {
            Node<T> pAux = getpFirst();
            Node<T> pAux2;
            while (next(next(pAux)) != null) {
                pAux = next(pAux);
            }
            pAux2 = next(pAux);
            pAux.setNextNode(next(pAux2));
            pAux2 = null;
            setiSize(getiSize() - 1);

        }
    }

    /**
     * Elimina el nodo dado.
     *
     * @param pNode, el nodo a eliminar.
     */
    public void delete(Node<T> pNode) {
        if (!isEmpty() && pNode != null) {
            Node<T> pAux = getpFirst();
            if (pNode.equals(getpFirst())) {
                setpFirst(next(pAux));
                pNode = null;
                setiSize(getiSize() - 1);
            } else {
                while (next(pAux) != null && !(next(pAux).equals(pNode))) {
                    pAux = next(pAux);
                }
                if (next(pAux) != null) {
                    pAux.setNextNode(next(pNode));
                    pNode = null;
                    setiSize(getiSize() - 1);
                }
            }
        }
    }

    /**
     * Elimina el nodo que ocupa la posicion dada.
     *
     * @param index, la posicion dada.
     */
    public void pop(int index) {
        if (!isEmpty()) {
            if (index >= 0 && index < getiSize()) {
                Node<T> pAux = getpFirst();
                if (index == 0) {
                    setpFirst(next(pAux));
                } else {
                    Node<T> pAux2;
                    for (int i = 0; i < index - 1; i++) {
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

    /**
     * Elimina el nodo dado y lo retorna.
     *
     * @param pNode, el nodo a eliminar.
     * @return retorna el nodo que ha sido eliminado, si el nodo no pertenece a
     * la lista entonces retorna null.
     */
    public Node<T> deleteAndReturn(Node<T> pNode) {
        if (!isEmpty()) {
            if (pNode != null) {
                Node<T> pAux = getpFirst();
                if (pNode.equals(getpFirst())) {
                    setpFirst(next(pAux));
                    setiSize(getiSize() - 1);
                    return pNode;
                } else {
                    while (next(pAux) != null && !(next(pAux).equals(pNode))) {
                        pAux = next(pAux);
                    }
                    if (next(pAux) != null) {
                        pAux.setNextNode(next(next(pAux)));
                        setiSize(getiSize() - 1);
                        return pNode;
                    }
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    /**
     * Elimina el nodo de la posicion dada y lo retorna.
     *
     * @param index, la posicion dada.
     * @return el nodo que ha sido eliminado, si no pertenece a la lista
     * entonces retorna null.
     */
    public Node<T> deleteAndReturn(int index) {
        if (!isEmpty()) {
            if (index >= 0 && index < getiSize()) {
                Node<T> pAux = getpFirst();
                if (index == 0) {
                    setpFirst(next(pAux));
                    setiSize(getiSize() - 1);
                    return pAux;
                } else {
                    for (int i = 0; i < index - 1; i++) {
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

    /**
     * Agrega el nodo dado en la primera posicion de la lista.
     *
     * @param pNode, el nodo a insertar.
     */
    public void addFirst(Node<T> pNode) {
        if (pNode != null) {
            pNode.setNextNode(getpFirst());
            setpFirst(pNode);
            setiSize(getiSize() + 1);
        }
    }

    /**
     * Guarda la informacion dada en un nuevo nodo que ocupara la primera
     * posicion de la lista.
     *
     * @param tInfo, la informacion a guardar.
     */
    public void addFirst(T tInfo) {
        Node<T> pNode = new Node<>(tInfo);
        pNode.setNextNode(getpFirst());
        setpFirst(pNode);
        setiSize(getiSize() + 1);
    }

    /**
     * Agrega el nodo dado en la ultima posicion de la lista.
     *
     * @param pNode, el nodo a insertar.
     */
    public void addEnd(Node<T> pNode) {
        if (pNode != null) {
            if (isEmpty()) {
                setpFirst(pNode);
            } else {
                Node<T> pAux = first();
                while (next(pAux) != null) {
                    pAux = next(pAux);
                }
                pAux.setNextNode(pNode);
            }
            setiSize(getiSize() + 1);
        }
    }

    /**
     * Guarda la informacion dada en un nuevo nodo que sera insertado en la
     * ultima posicion de la lista.
     *
     * @param tInfo, la informacion a guardar.
     */
    public void addEnd(T tInfo) {
        Node<T> pNode = new Node<>(tInfo);
        if (isEmpty()) {
            setpFirst(pNode);
        } else {
            Node<T> pAux = first();
            while (next(pAux) != null) {
                pAux = next(pAux);
            }
            pAux.setNextNode(pNode);
        }
        setiSize(getiSize() + 1);
    }

    /**
     * Inserta un nodo dado en la posicion dada.
     *
     * @param pNode, el nodo a insertar.
     * @param index , la posicion que ocupara en la lista.
     */
    public void insertByIndex(Node<T> pNode, int index) {
        if (!isEmpty()) {
            if (index == 0) {
                addFirst(pNode);
            } else if (index == getiSize() - 1) {
                addEnd(pNode);
            } else if (index > 0 && index < getiSize() - 1) {
                Node<T> pAux = getpFirst();
                for (int i = 0; i < index - 1; i++) {
                    pAux = next(pAux);
                }
                pNode.setNextNode(next(pAux));
                pAux.setNextNode(pNode);
                setiSize(getiSize() + 1);
            }
        } else {
            if (index == 0) {
                addFirst(pNode);
            }
        }
    }

    /**
     * Guarda la informacion dada en un nuevo nodo que ocupara la posicion dada.
     *
     * @param tInfo, la informacion a guardar.
     * @param index, la posicion dada.
     */
    public void insertByIndex(T tInfo, int index) {
        Node<T> pNode = new Node<>(tInfo);
        if (!isEmpty()) {
            if (index == 0) {
                addFirst(pNode);
            } else if (index == getiSize() - 1) {
                addEnd(pNode);
            } else if (index > 0 && index < getiSize() - 1) {
                Node<T> pAux = getpFirst();
                for (int i = 0; i < index - 1; i++) {
                    pAux = next(pAux);
                }
                pNode.setNextNode(next(pAux));
                pAux.setNextNode(pNode);
                setiSize(getiSize() + 1);
            }
        } else {
            if (index == 0) {
                addFirst(pNode);
            }
        }
    }

    /**
     * Elimina la lista.
     */
    public void delateAll() {
        setpFirst(null);
        setiSize(0);
        System.gc();
    }

    /**
     * Ordena la lista usando el metodo de buble sort.
     */
    public void bubleSort() {
        if (!isEmpty()) {
            Node<T> pAux = first();
            while (pAux != null) {
                Node<T> pAux2 = next(pAux);
                while (pAux2 != null) {
                    if (getMethods().compareTo(pAux.getTInfo(), pAux2.getTInfo()) > 0) {
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

    /**
     * Ordena la lista usando el metodo insertion sort
     */
    public void insertionSort() {
        if (!isEmpty()) {
            Node<T> pAux = first();
            while (pAux != null) {
                Node<T> pAux2 = next(pAux);
                while (pAux2 != null) {
                    if (getMethods().compareTo(pAux.getTInfo(), pAux2.getTInfo()) > 0) {
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

    /**
     * Retorna la posicion del nodo que guarda la informacion dada.
     *
     * @param data, la informacion a buscar.
     * @return el indice del nodo que guarda la informacion, en caso de no
     * existir el nodo entonces retorna -1.
     */
    public int indexOf(T data) {
        if (!isEmpty()) {
            int index = 0;
            Node<T> aux = this.getpFirst();
            while (aux != null) {
                if (methods.equals(data, data)) {
                    return index;
                }
                index++;
            }
        }
        return -1;

    }

    @Override
    public String toString() {
        String s = "";
        if (!isEmpty()) {
            Node<T> pAux = first();
            while (pAux != null) {
                s += pAux.getTInfo().toString() + "\n";
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
