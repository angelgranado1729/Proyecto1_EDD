/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import MainClasses.ListUtilMethods.UtilMethodsAlmacen;

/**
 *
 * @author Angel Granado & andre
 */
public class Grafo {

    /**
     * Lista con los almacenes registrados.
     */
    private LinkedList<Almacen> almacenes;
    /**
     * Numero maximo de vertices.
     */
    private int numMaxVertices;
    /**
     * Numero actual de vertices.
     */
    private int numVertices;
    /**
     * Matriz de adyacencia.
     */
    private MatrizAdj matrixAdj;

    /**
     * Constructor de la clase.
     *
     * @param numVertices, cantidad de vertices
     */
    public Grafo(int numVertices) {
        this.almacenes = new LinkedList<>(new UtilMethodsAlmacen());
        this.numMaxVertices = numVertices * 2;
        this.numVertices = numVertices;
        this.matrixAdj = new MatrizAdj(numVertices);
    }

    /**
     * Constructor de la clase.
     */
    public Grafo() {
        this.almacenes = new LinkedList<>(new UtilMethodsAlmacen());
        this.numMaxVertices = 30;
        this.numVertices = 0;
        this.matrixAdj = new MatrizAdj();
    }

    /**
     * Verifica si el grafo es vacio.
     *
     * @return true si el grafo es vacio, false si hay al menos un vertice.
     */
    public boolean isEmpty() {
        return numVertices == 0;
    }

    /**
     * Verifica si un almacen esta registrado en la red de almacenes (grafo).
     *
     * @param almacen, el nombre del almacen.
     * @return true si pertenece a la red, false si no esta registrado.
     */
    public boolean isVertex(String almacen) {
        return getIndexWarehouse(almacen) != -1;
    }

    /**
     * Registra un nuevo almacen.
     *
     * @param almacen nombre del almacen.
     */
    public void addAlmacen(String almacen) {
        if (!isVertex(almacen) && getAlmacenes().size() < getNumMaxVertices()) {
            Almacen newAlmacen = new Almacen(almacen);
            getAlmacenes().addEnd(newAlmacen);
            setNumVertices(getNumVertices() + 1);
        }
    }

    /**
     * Registra una nueva ruta entre dos almacenes dados.
     *
     * @param source, nombre del almacen origen.
     * @param destination, nombre del almacen destino.
     * @param distance, la distancia de la ruta.
     * @throws java.lang.Exception
     * @throws "Distancia no valida", si la distancia es negativa.
     * @throws "Vertice no existe", si el almacen no esta registrado.
     */
    public void addEdge(String source, String destination, double distance) throws Exception {
        int numSource = getIndexWarehouse(source);
        int numDestination = getIndexWarehouse(destination);
        if (numSource < 0 || numDestination < 0) {
            throw new Exception("Vertice no existe");
        }
        if (distance < 0) {
            throw new Exception("Distancia no valida");
        }
        getMatrixAdj().addEdge(numSource, numDestination, distance);
    }

    /**
     * Verifica si hay una ruta que conecte dos almacenes dados.
     *
     * @param source, el nombre del almacen origen.
     * @param destination, el nombre del almacen destino.
     * @return true si hay una ruta que conecte ambos almacenes, false si no hay
     * ninguna ruta que los conecte.
     * @throws java.lang.Exception
     * @throws "Vertice no existe", si uno de los almacenes no esta registrado
     * en el grafo.
     */
    public boolean adjacency(String source, String destination) throws Exception {
        int numSource = getIndexWarehouse(source);
        int numDestination = getIndexWarehouse(destination);
        if (numSource < 0 || numDestination < 0) {
            throw new Exception("Vertice no existe");
        }
        return getMatrixAdj().adjacency(numSource, numDestination);
    }

    /**
     * Verifica si hay una ruta que conecte dos almacenes dados, a traves de sus
     * indices.
     *
     * @param source, inidice del almacen origen.
     * @param destination, indice del almacen destino.
     * @return true si hay una ruta que conecte ambos almacenes, false si no hay
     * ninguna ruta que los conecte.
     */
    public boolean adjacency(int source, int destination) {
        boolean b = getMatrixAdj().adjacency(source, destination);
        return b;
    }

    /**
     * Retirna una lista con los almecenes registrados, siguiendo el algoritmo
     * de Recorrido en Anchura (BFS).
     *
     * @return lista con los almacenes.
     * @throws java.lang.Exception
     * @throws "Grafo vacio" si no hay almacenes registrados.
     */
    public LinkedList<Almacen> BFS() throws Exception {
        if (!isEmpty()) {
            Queue<Almacen> cola = new Queue<>();
            LinkedList<Almacen> almacenesVisitados = new LinkedList<>();
            boolean visitados[] = new boolean[getNumVertices()];
            Almacen almacenActual;

            for (int i = 0; i < getNumVertices(); i++) {
                visitados[i] = false;
            }
            for (int i = 0; i < getNumVertices(); i++) {

                if (!visitados[i]) {
                    cola.enqueue(getAlmacenes().getNode(i).getTInfo());
                    visitados[i] = true;

                    while (!cola.isEmpty()) {
                        almacenActual = cola.dequeue();
                        almacenesVisitados.addEnd(almacenActual);
                        int numAux = getIndexWarehouse(almacenActual.getAlmacen());

                        for (int j = 0; j < getNumVertices(); j++) {
                            if ((numAux != j) && (adjacency(numAux, j)) && (!visitados[j])) {
                                cola.enqueue(getAlmacenes().getNode(j).getTInfo());
                                visitados[j] = true;
                            }
                        }
                    }
                }
            }
            return almacenesVisitados;
        } else {
            throw new Exception("Grafo vacio.");
        }
    }

    /**
     * Recorre el grafo en Profundidad.
     *
     * @param numVertice, indice del vertice.
     * @param visitados, lista con los vertices visitados
     * @param almacenesVisitados, lista con los almacenesvisitados.
     * @return Lista con los almacenes recorridos.
     */
    private LinkedList<Almacen> deepTraveling(int numVertice, boolean[] visitados, LinkedList<Almacen> almacenesVisitados) {
        visitados[numVertice] = true;
        almacenesVisitados.addEnd(getAlmacenes().getNode(numVertice).getTInfo());

        for (int i = 0; i < getNumVertices(); i++) {
            if ((numVertice != i) && (!visitados[i]) && (getMatrixAdj().adjacency(numVertice, i))) {
                almacenesVisitados = deepTraveling(i, visitados, almacenesVisitados);
            }
        }
        return almacenesVisitados;
    }

    /**
     * Retirna una lista con los almecenes registrados, siguiendo el algoritmo
     * de Recorrido en Profundida (DFS).
     *
     * @return lista con los almacenes.
     * @throws java.lang.Exception
     * @throws "Grafo vacio" si no hay almacenes registrados.
     */
    public LinkedList<Almacen> DFS() throws Exception {
        if (!isEmpty()) {
            boolean[] visitados = new boolean[getNumVertices()];
            LinkedList<Almacen> almacenesVisitados = new LinkedList<>();

            for (int i = 0; i < getNumVertices(); i++) {
                visitados[i] = false;
            }
            for (int i = 0; i < getNumVertices(); i++) {
                if (!visitados[i]) {
                    almacenesVisitados = deepTraveling(i, visitados, almacenesVisitados);
                }
            }
            return almacenesVisitados;
        } else {
            throw new Exception("Grafo vacio.");
        }
    }

    /**
     * Accede a la lista almacenes.
     *
     * @return la lista almacenes.
     */
    public LinkedList<Almacen> getAlmacenes() {
        return almacenes;
    }

    /**
     * Modifica la lista almacenes.
     *
     * @param almacenes, la nueva lista almacenes.
     */
    public void setAlmacenes(LinkedList<Almacen> almacenes) {
        this.almacenes = almacenes;
    }

    /**
     * Accede al numero maximo de vertices.
     *
     * @return el numero maximo de vertices.
     */
    public int getNumMaxVertices() {
        return numMaxVertices;
    }

    /**
     * Modifica el numero maximo de veritces.
     *
     * @param numMaxVertices, el nuevo numero maximo de vertices.
     */
    public void setNumMaxVertices(int numMaxVertices) {
        this.numMaxVertices = numMaxVertices;
    }

    /**
     * Accede al numero de vertices.
     *
     * @return the numVertices, el numero de vertices.
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * Modifica el numero de vertices del grafo.
     *
     * @param numVertices el nuevo numero de vertices.
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    /**
     * Accede a la matriz de adyacencia.
     *
     * @return la matriz de adyacencia.
     */
    public MatrizAdj getMatrixAdj() {
        return matrixAdj;
    }

    /**
     * Modifica la matriz de adyacencia.
     *
     * @param matrixAdj, la nueva matriz de adyacencia.
     */
    public void setMatrixAdj(MatrizAdj matrixAdj) {
        this.matrixAdj = matrixAdj;
    }

    /**
     * Retorna la distancia que hay entre dos almacenes.
     *
     * @param source, indice del almacen origen.
     * @param target, indice del almacen destino.
     * @return la distancia entre los dos almacenes.
     */
    public double getPeso(int source, int target) {
        return matrixAdj.getPeso(source, target);
    }

    /**
     * Retorna el indice del vertice (almacen).
     *
     * @param name, el nombre del almacen.
     * @return retorna -1 si el almacen no pertenece al grafo, en caso contrario
     * retorna el indice del almacen.
     */
    public int getIndexWarehouse(String name) {
        if (!(this.getAlmacenes().isEmpty())) {
            int index = 0;
            Node<Almacen> aux = this.getAlmacenes().getpFirst();
            while (aux != null) {
                if (aux.getTInfo().getAlmacen().equalsIgnoreCase(name)) {
                    break;
                }
                aux = this.getAlmacenes().next(aux);
                index++;
            }
            return index;
        }
        return -1;
    }

    @Override
    public String toString() {
        String s = "";
        if (!this.isEmpty()) {
            s = "Numero de Vertices: " + this.getNumVertices() + "\n"
                    + "Numero Maximo de Vetices: " + this.getNumMaxVertices() + "\n" + "Almacenes\n" + this.getAlmacenes().toString()
                    + "Matriz de Adyacencia\n" + this.getMatrixAdj().toString();
        }
        return s;
    }

}
