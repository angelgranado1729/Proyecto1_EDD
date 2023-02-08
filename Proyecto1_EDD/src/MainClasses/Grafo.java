/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado & andre
 */
public class Grafo{
    private ListaAlmacenes almacenes;
    private int numMaxVertices;
    private int numVertices;
    private MatrizAdj matrixAdj;
    
    public Grafo(int numMaxVertices){
        this.almacenes = new ListaAlmacenes();
        this.numMaxVertices = numMaxVertices;
        this.numVertices = 0;
        this.matrixAdj = new MatrizAdj(numMaxVertices);
    }
    
    public Grafo(){
        this.almacenes = new ListaAlmacenes();
        this.numMaxVertices = 30;
        this.numVertices = 0;
        this.matrixAdj = new MatrizAdj();
    }
    
    public boolean isEmpty(){
        return getAlmacenes().isEmpty();
    }
    public int numAlmacen(String almacen){
        return getAlmacenes().indexOf(almacen);
    }
    
    public boolean isVertex(String almacen){
        return numAlmacen(almacen) != -1;
    }
    
    public void addAlmacen(String almacen){
        if (!isVertex(almacen) && getAlmacenes().size() < getNumMaxVertices()){
            Almacen newAlmacen = new Almacen(almacen);
            getAlmacenes().append(newAlmacen);
            setNumVertices(getNumVertices() + 1);
        }
    }
    
    public void addEdge(String source, String destination, double distance) throws Exception{
        int numSource = numAlmacen(source);
        int numDestination = numAlmacen(destination);
        if (numSource < 0 || numDestination < 0) throw new Exception("Vertice no existe");
        if (distance < 0) throw new Exception("Distancia no valida");
        getMatrixAdj().addEdge(numSource, numDestination, distance);
    }
    
    public boolean adjacency(String source, String destination) throws Exception{
        int numSource = numAlmacen(source);
        int numDestination = numAlmacen(destination);
        if (numSource < 0 || numDestination < 0) throw new Exception("Vertice no existe");
        return getMatrixAdj().adjacency(numSource, numDestination);
    }
    
    public boolean adjacency(int source, int destination){
        boolean b = getMatrixAdj().adjacency(source, destination);
        return b;
    }
    
    public ListaAlmacenes BFS() throws Exception{
        if (!isEmpty()){
            Queue<Almacen> cola = new Queue<>();
            ListaAlmacenes almacenesVisitados = new ListaAlmacenes();
            boolean visitados[] = new boolean[getNumVertices()];
            Almacen almacenActual;

            for (int i = 0; i < getNumVertices(); i++){
                visitados[i] = false;
            }
            for(int i = 0; i < getNumVertices(); i++){

                if (!visitados[i]){
                    cola.enqueue(getAlmacenes().getByIndex(i).gettInfo());
                    visitados[i] = true;

                    while (!cola.isEmpty()){
                        almacenActual = cola.dequeue();
                        almacenesVisitados.append(almacenActual);
                        System.out.println(almacenActual.getAlmacen());
                        int numAux = numAlmacen(almacenActual.getAlmacen());

                        for (int j = 0; j < getNumVertices(); j++){
                            if ((numAux != j) && (adjacency(numAux,j)) && (!visitados[j])){                            
                                cola.enqueue(getAlmacenes().getByIndex(j).gettInfo());
                                visitados[j] = true;
                            }
                        }   
                    }
                }
            }
            return almacenesVisitados;
        } else throw new Exception("Grafo vacio.");
    }
    
    public ListaAlmacenes deepTraveling(int numVertice, boolean[]visitados, ListaAlmacenes almacenesVisitados){
        visitados[numVertice] = true;
        almacenesVisitados.append(getAlmacenes().getByIndex(numVertice).gettInfo());
        
        for (int i = 0; i < getNumVertices(); i++){
            if ((numVertice != i) && (!visitados[i]) && (getMatrixAdj().adjacency(numVertice, i))){
                almacenesVisitados = deepTraveling(i, visitados,almacenesVisitados);
            }
        }
        return almacenesVisitados;
    }
    
    public ListaAlmacenes DFS() throws Exception{
        if (!isEmpty()){
            boolean[] visitados = new boolean[getNumVertices()];
            ListaAlmacenes almacenesVisitados = new ListaAlmacenes();

            for (int i = 0; i < getNumVertices(); i++){
                visitados[i] = false;
            }
            for (int i = 0; i < getNumVertices(); i++){
                if (!visitados[i]){
                    almacenesVisitados = deepTraveling(i, visitados, almacenesVisitados);
                }
            }
            return almacenesVisitados; 
        } else throw new Exception("Grafo vacio.");    
    } 

    /**
     * @return the almacenes
     */
    public ListaAlmacenes getAlmacenes() {
        return almacenes;
    }

    /**
     * @param almacenes the almacenes to set
     */
    public void setAlmacenes(ListaAlmacenes almacenes) {
        this.almacenes = almacenes;
    }

    /**
     * @return the numMaxVertices
     */
    public int getNumMaxVertices() {
        return numMaxVertices;
    }

    /**
     * @param numMaxVertices the numMaxVertices to set
     */
    public void setNumMaxVertices(int numMaxVertices) {
        this.numMaxVertices = numMaxVertices;
    }

    /**
     * @return the numVertices
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * @param numVertices the numVertices to set
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    /**
     * @return the matrixAdj
     */
    public MatrizAdj getMatrixAdj() {
        return matrixAdj;
    }

    /**
     * @param matrixAdj the matrixAdj to set
     */
    public void setMatrixAdj(MatrizAdj matrixAdj) {
        this.matrixAdj = matrixAdj;
    }
    
    public double getPeso(int source, int target){
        return matrixAdj.getPeso(source, target);
    }
    
}
