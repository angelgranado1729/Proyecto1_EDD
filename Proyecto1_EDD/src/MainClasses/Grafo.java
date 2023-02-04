/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
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
    
    public ListaAlmacenes BFSreport(){
        
    }
    
    
    
    
    
}
