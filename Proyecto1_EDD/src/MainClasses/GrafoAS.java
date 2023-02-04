/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author andre
 */
class GrafoAS {
    private final int numVertices; 
    private final int[][] matrizAdyacencia; 
    private final boolean[] visitados; 
    private final int[] distancias; 
    private final int[] predecesores; 

    // constructor que recibe el número de vértices y inicializa las variables
    public GrafoAS (int numVertices) {
        this.numVertices = numVertices;
        // inicializamos la matriz de adyacencia con número de vértices
        matrizAdyacencia = new int[numVertices][numVertices];
        // inicializamos el arreglo visitados para llevar registro de los vértices visitados
        visitados = new boolean[numVertices];
        // inicializamos el arreglo distancias para llevar registro de la distancia desde el vértice origen hasta cada vértice
        distancias = new int[numVertices];
        // inicializamos el arreglo predecesores para llevar registro del predecesor de cada vértice
        predecesores = new int[numVertices];
    }

    // agrega una arista (origen, destino) con un peso específico
    public void agregarArista(int origen, int destino, int peso) {
        matrizAdyacencia[origen][destino] = peso;
    }

    // implementa el algoritmo BFS (búsqueda en amplitud) a partir de un vértice origen
    public void BFS(int origen) {
        // creamos una cola para almacenar los vértices a visitar
        java.util.LinkedList<Integer> cola = new java.util.LinkedList<>();
        // agregamos el vértice origen a la cola y lo marcamos como visitado
        cola.add(origen);
        visitados[origen] = true;
        // mientras la cola no esté vacía
        while (!cola.isEmpty()) {
            // sacamos un vértice de la cola
            int vertice = cola.poll();
            // recorremos todos los vértices adyacentes al vértice actual
            for (int i = 0; i < numVertices; i++) {
                // si hay una arista entre el vértice actual y el vértice adyacente y el vértice adyacente no ha sido visitado
                if (matrizAdyacencia[vertice][i] != 0 && !visitados[i]) {
                    // agregamos el vértice adyacente a la cola y lo marcamos como visitado
                    cola.add(i);
                    visitados[i] = true;
                }
            }
        }
    }

    // implementa el algoritmoDijkstra para encontrar el camino más corto desde el vértice origen hasta todos los demás vértices
    public void Dijkstra(int origen) {
    // inicializamos el arreglo distancias con infinito para todos los vértices excepto para el vértice origen, que es 0
    for (int i = 0; i < numVertices; i++) {
    distancias[i] = Integer.MAX_VALUE;
    predecesores[i] = -1;
}
distancias[origen] = 0;
        // creamos una cola de prioridad para almacenar los vértices por visitar, ordenados por distancia
    java.util.PriorityQueue<NodoDijkstra> cola = new java.util.PriorityQueue<>();
    cola.add(new NodoDijkstra(origen, 0));

    // mientras la cola no esté vacía
    while (!cola.isEmpty()) {
        // sacamos el vértice con la distancia mínima de la cola
        NodoDijkstra nodo = cola.poll();
        int vertice = nodo.vertice;
        // recorremos todos los vértices adyacentes al vértice actual
        for (int i = 0; i < numVertices; i++) {
            // si hay una arista entre el vértice actual y el vértice adyacente
            if (matrizAdyacencia[vertice][i] != 0) {
                // si la distancia desde el vértice origen hasta el vértice adyacente a través del vértice actual es más corta
                // que la distancia actual
                if (distancias[vertice] + matrizAdyacencia[vertice][i] < distancias[i]) {
                    // actualizamos la distancia y el predecesor del vértice adyacente
                    distancias[i] = distancias[vertice] + matrizAdyacencia[vertice][i];
                    predecesores[i] = vertice;
                    // agregamos el vértice adyacente a la cola
                    cola.add(new NodoDijkstra(i, distancias[i]));
                }
            }
        }
    }
}

    // clase interna para representar un vértice en la cola de prioridad de Dijkstra
    private class NodoDijkstra implements Comparable<NodoDijkstra> {
        int vertice;
        int distancia;

        public NodoDijkstra(int vertice, int distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(NodoDijkstra otro) {
            return Integer.compare(distancia, otro.distancia);
        }
    }
}

    
