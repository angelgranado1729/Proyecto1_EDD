/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Angel Granado
 */
public class MatrizAdj {
    private double[][] matrix;
    private int numVertices;
    private int numMaxVertices;


    public MatrizAdj(int numVertices){
        this.numVertices = numVertices;
        this.numMaxVertices = 30;
        this.matrix = new double[numMaxVertices][numMaxVertices];
        for (int i = 0; i < numMaxVertices; i++){
            for (int j = 0; j <  numMaxVertices; j++){
                matrix[i][j] = 0;
            }
        }
    }  
    
    public MatrizAdj(){
        this.numVertices = 0;
        this.numMaxVertices = 30;
        this.matrix = new double[numMaxVertices][numMaxVertices];
        for (int i = 0; i < numMaxVertices; i++){
            for (int j = 0; j <  numMaxVertices; j++){
                matrix[i][j] = 0;
            }
        }
    } 
    
       /**
     * @return the matrix
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * @param matrix the matrix to set
     */
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
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
    
    public void addEdge(int source, int destination, double distance){
        getMatrix()[source][destination] = distance;
    }
    
    public boolean adjacency(int source, int destination){
        return getMatrix()[source][destination] != 0;
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
    
    public double getPeso(int source, int destination){
        if (adjacency(source, destination)){
            return matrix[source][destination];
        } else {
            return 0;
        }
    }
    
    public void setPeso(int source, int destination, double peso){
        this.matrix[source][destination] = peso;
    }
}
