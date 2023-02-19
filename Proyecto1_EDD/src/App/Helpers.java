/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import MainClasses.Almacen;
import MainClasses.Grafo;
import MainClasses.LinkedList;
import MainClasses.RutaCorta;
import MainClasses.RutasPosibles;
import MainClasses.RutasYDistancias;
import javax.swing.JOptionPane;



/**
 *
 * @author Angel Granado
 */
public class Helpers {  
    
    /**
     * Busca el vertice (indice) con la menor distancia.
     * 
     * @param distancias, un array con las distancias desde el vertice origen
     * hasta el vertice destino.
     * @param verticesVisitados, un array de booleanos que inidican los vertices
     * que han sido visitados.
     * @return el vertice con la menor distancia.
     */
    private static int getVerticeMinDistance(double[] distancias, boolean[] verticesVisitados){
        double minDistancia = Double.MAX_VALUE;
        int verticeDistanciaMin = 1;
        
        for (int i = 0; i < distancias.length; i++){
            if (!verticesVisitados[i] && distancias[i] < minDistancia){
                minDistancia = distancias[i];
                verticeDistanciaMin = i;
            }
        }
        return verticeDistanciaMin;     
    }
    
    /**
     * Reconstruye la ruta obtenida con el algoritmo dijkstra.
     * 
     * @param ultimosVertices, un array con los indice de los ultimos vertices visitados.
     * @param distancias, un array con las distancia desde el vertice origen hasta el vertice destino
     * @param origen, vertice origen.
     * @param destino, vertice destino
     * @return un objeto RutasYDistancias que contiene la ruta mas corta y la distancia.
     */
    public static RutasYDistancias getPath(int[] ultimosVertices, double[] distancias, int origen, int destino){
        int target = destino;
        RutasYDistancias rutaYDistancia = new RutasYDistancias();
        int[] rutaInvertida = new int[ultimosVertices.length];
        int lengthPath = 0;
        
        while(target != origen){
            rutaInvertida[lengthPath] = target;
            target = ultimosVertices[target];
            lengthPath++;
        }
        
        rutaInvertida[lengthPath] = origen;
        int[] ruta = new int[lengthPath + 1];
        
        for (int i = 0; i < ruta.length; i++){
            ruta[i] = rutaInvertida[lengthPath - i];
        }
        
        rutaYDistancia.setRuta(ruta);
        rutaYDistancia.setDistancias(distancias);
        return rutaYDistancia;
    }
    
    /**
     * Determina la ruta mas corta entre dos vertices dados.
     * 
     * @param grafo, el grafo donde se va a aplicar dijkstra.
     * @param origen, el vertice origen.
     * @param destino, vetice destino.
     * @return un objeto RutasYDistancias que contiene la ruta mas corta entre
     * el vertice origen y el vertice destino, y la distancia entre ambos nodos.
     */
    public static RutasYDistancias dijkstra(Grafo grafo, int origen, int destino){
        int[] ultimosVisitados = new int[grafo.getNumVertices()];
        double[] distancias = new double[grafo.getNumVertices()];
        boolean[] verticesVisitados = new boolean[grafo.getNumVertices()];
        
        for (int i = 0; i< grafo.getNumVertices(); i++){
            distancias[i] = Double.MAX_VALUE;
            verticesVisitados[i]  = false;
        }
        
        distancias[origen] = 0;
        
        for (int i = 0; i < grafo.getNumVertices(); i++){
            int v = getVerticeMinDistance(distancias, verticesVisitados);
            
            for(int w = 0; w < grafo.getNumVertices(); w++){
                if (!verticesVisitados[w] && grafo.adjacency(v, w) && (distancias[v] + grafo.getPeso(v,w) < distancias[w])){
                    distancias[w] = distancias[v] + grafo.getPeso(v,w);
                    ultimosVisitados[w] = v;
                }
            }
        }
        
        return getPath(ultimosVisitados, distancias, origen, destino);
    }
    
    /**
     * Determina la ruta mas corta que hay entre un vertice destino y un array
     * con los vertices origen.
     * 
     * @param g, el grafo.
     * @param verticesOrigen, un array con los vertices origen.
     * @param target, el vertice destino.
     * @return un objeto RutaCorta, que contiene la ruta mas corta entre las rutas que hay
     * entre los vertices origen y el vertice destino, y la distancia de esa ruta.
     */
    public RutaCorta shortestPath(Grafo g, int[] verticesOrigen, int target) {
        RutasPosibles rutasPosibles = new RutasPosibles();
        for (int i = 0; i < verticesOrigen.length; i++) {
            RutasYDistancias rutaPosible = dijkstra(g, verticesOrigen[i], target);
            rutasPosibles.insertOrdered(rutaPosible, target);                  
	}      
        if (rutasPosibles.first().getTInfo().getDistancias()[target] < Double.MAX_VALUE){
            LinkedList<Almacen> almacenesRuta = new LinkedList<>();
            for (int i = 0; i <rutasPosibles.first().getTInfo().getRuta().length; i++){
                almacenesRuta.addEnd(App.g.getAlmacenes().getNode(rutasPosibles.first().getTInfo().getRuta()[i]));
            }
            RutaCorta rutaMin = new RutaCorta(rutasPosibles.first().getTInfo().getRuta(),almacenesRuta, rutasPosibles.first().getTInfo().getDistancias()[target]);
            return rutaMin;   
        } else {
            return null;
        }
    }
    
    /**
     * Convierte un string a entero.
     * 
     * @param num, el string a convertir. 
     * @return retorna la conversion a integer.
     */
    public static int validarNum(String num){
        try{
            return Integer.parseInt(num) ;
        } catch (NumberFormatException e){
        }
        return -1;
    }
               
}
