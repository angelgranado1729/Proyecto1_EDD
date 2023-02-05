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
        return almacenes.isEmpty();
    }
    public int numAlmacen(String almacen){
        return almacenes.indexOf(almacen);
    }
    
    public boolean isVertex(String almacen){
        return numAlmacen(almacen) != -1;
    }
    
    public void addAlmacen(String almacen){
        if (!isVertex(almacen) && almacenes.size() < numMaxVertices){
            Almacen newAlmacen = new Almacen(almacen);
            almacenes.append(newAlmacen);
            numVertices++;
        }
    }
    
    public void addEdge(String source, String destination, double distance) throws Exception{
        int numSource = numAlmacen(source);
        int numDestination = numAlmacen(destination);
        if (numSource < 0 || numDestination < 0) throw new Exception("Vertice no existe");
        if (distance < 0) throw new Exception("Distancia no valida");
        matrixAdj.addEdge(numSource, numDestination, distance);
    }
    
    public boolean adjacency(String source, String destination) throws Exception{
        int numSource = numAlmacen(source);
        int numDestination = numAlmacen(destination);
        if (numSource < 0 || numDestination < 0) throw new Exception("Vertice no existe");
        return matrixAdj.adjacency(numSource, numDestination);
    }
    
    public boolean adjacency(int source, int destination){
        boolean b = matrixAdj.adjacency(source, destination);
        return b;
    }
    
    public ListaAlmacenes BFS() throws Exception{
        if (!isEmpty()){
            Queue<Almacen> cola = new Queue<>();
            ListaAlmacenes almacenesVisitados = new ListaAlmacenes();
            boolean visitados[] = new boolean[numVertices];
            Almacen almacenActual;

            for (int i = 0; i < numVertices; i++){
                visitados[i] = false;
            }
            for(int i = 0; i < numVertices; i++){

                if (!visitados[i]){
                    cola.enqueue(almacenes.getByIndex(i).gettInfo());
                    visitados[i] = true;

                    while (!cola.isEmpty()){
                        almacenActual = cola.dequeue();
                        almacenesVisitados.append(almacenActual);
                        System.out.println(almacenActual.getAlmacen());
                        int numAux = numAlmacen(almacenActual.getAlmacen());

                        for (int j = 0; j < numVertices; j++){
                            if ((numAux != j) && (adjacency(numAux,j)) && (!visitados[j])){                            
                                cola.enqueue(almacenes.getByIndex(j).gettInfo());
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
        almacenesVisitados.append(almacenes.getByIndex(numVertice).gettInfo());
        
        for (int i = 0; i < numVertices; i++){
            if ((numVertice != i) && (!visitados[i]) && (matrixAdj.adjacency(numVertice, i))){
                almacenesVisitados = deepTraveling(i, visitados,almacenesVisitados);
            }
        }
        return almacenesVisitados;
    }
    
    public ListaAlmacenes DFS() throws Exception{
        if (!isEmpty()){
            boolean[] visitados = new boolean[numVertices];
            ListaAlmacenes almacenesVisitados = new ListaAlmacenes();

            for (int i = 0; i < numVertices; i++){
                visitados[i] = false;
            }
            for (int i = 0; i < numVertices; i++){
                if (!visitados[i]){
                    almacenesVisitados = deepTraveling(i, visitados, almacenesVisitados);
                }
            }
            return almacenesVisitados; 
        } else throw new Exception("Grafo vacio.");
        
    }
    
    public void dijktra(String almacenOrigen){
        
    }
    
    
    
    
    
}
