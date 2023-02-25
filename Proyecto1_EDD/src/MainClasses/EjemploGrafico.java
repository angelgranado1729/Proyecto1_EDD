/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author andre
 */


import App.App;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class EjemploGrafico {

    public static void main(String[] args) {

        // Crear un objeto Graph vacío
        Graph graph = new SingleGraph("Mi grafo");

        // Agregar nodos al grafo
        String[] nombreAlmacenes = new String[App.getG().getNumVertices()];
        var aux = App.getG().getAlmacenes().getpFirst();
        for (int i = 0; i < App.getG().getNumVertices(); i++) {
            String nombre = aux.getTInfo().getAlmacen();
            nombreAlmacenes[i] = nombre;
            graph.addNode(nombre);
            aux = App.getG().getAlmacenes().next(aux);
        }

        // Agregar aristas al grafo
        for (int i = 0; i < App.getG().getNumVertices(); i++) {
            for (int j = i + 1; j < App.getG().getNumVertices(); j++) {
                double peso = App.getG().getPeso(i, j);
                if (peso > 0) {
                    String nombreNodo1 = nombreAlmacenes[i];
                    String nombreNodo2 = nombreAlmacenes[j];
                    graph.addEdge(nombreNodo1 + nombreNodo2, nombreNodo1, nombreNodo2);
                }
            }
        }
        System.setProperty("org.graphstream.ui", "swing");

        // Mostrar el grafo
        graph.display();
    }
}
