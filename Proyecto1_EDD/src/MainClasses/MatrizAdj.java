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

    /**
     * Matriz de adyacencia.
     */
    private double[][] matrix;
    /**
     * Numero de vertices.
     */
    private int numVertices;
    /**
     * Numero maximo de vertices.
     */
    private int numMaxVertices;

    /**
     * Constructor de la clase.
     *
     * @param numVertices, numero de vertices.
     */
    public MatrizAdj(int numVertices) {
        this.numVertices = numVertices;
        this.numMaxVertices = numVertices * 2;
        this.matrix = new double[numMaxVertices][numMaxVertices];
        for (int i = 0; i < numMaxVertices; i++) {
            for (int j = 0; j < numMaxVertices; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    /**
     * Constructor de la clase.
     */
    public MatrizAdj() {
        this.numVertices = 0;
        this.numMaxVertices = 30;
        this.matrix = new double[numMaxVertices][numMaxVertices];
        for (int i = 0; i < numMaxVertices; i++) {
            for (int j = 0; j < numMaxVertices; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    /**
     * Accede a la matriz con las distancias entre los vertices.
     *
     * @return la matriz de adyacencia.
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * Modifica la matriz de adyacencia.
     *
     * @param matrix, la nueva matriz de adyacencia.
     */
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Accede al numero de vertices.
     *
     * @return el numero de vertices.
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * Modifica el numero de vertices.
     *
     * @param numVertices, el numero de vertices.
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    /**
     * Agrega un camino entre dos vertices dados.
     *
     * @param source, indice del vertice origen.
     * @param destination, indice del vertice destino.
     * @param distance , la distancia entre los dos vertices.
     */
    public void addEdge(int source, int destination, double distance) {
        getMatrix()[source][destination] = distance;
    }

    /**
     * Verifica si hay un camino entre dos vertices.
     *
     * @param source, indice del vertice origen.
     * @param destination, indice del vertice destino.
     * @return true si hay un camino entre los dos vertices, false si ambos
     * vertices no estan conectados.
     */
    public boolean adjacency(int source, int destination) {
        return getMatrix()[source][destination] != 0;
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
     * Modifica el numero maximo de vertices.
     *
     * @param numMaxVertices, el nuevo numero maximo de vertices.
     */
    public void setNumMaxVertices(int numMaxVertices) {
        this.numMaxVertices = numMaxVertices;
    }

    /**
     * Retorna la distancia entre dos vertices dados.
     *
     * @param source, indice del vertice origen.
     * @param destination, indice del vertice destino.
     * @return la distancia entre los dos vertices.
     */
    public double getPeso(int source, int destination) {
        if (adjacency(source, destination)) {
            return matrix[source][destination];
        } else {
            return 0;
        }
    }

    /**
     * Modifica la distancia que hay entre dos vertices dados.
     *
     * @param source, indice del vertice origen.
     * @param destination, indice del vertice destino.
     * @param peso, la nueva distancia entre los dos vertices.
     */
    public void setPeso(int source, int destination, double peso) {
        this.matrix[source][destination] = peso;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.getNumVertices(); i++) {
            for (int j = 0; j < this.getNumVertices(); j++) {
                s += this.getMatrix()[i][j] + "  ";
            }
            s += "\n";
        }
        return s;
    }
}
