/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import MainClasses.Almacen;
import MainClasses.Grafo;
import MainClasses.ListaAlmacenes;



/**
 *
 * @author Angel Granado
 */
public class MainFuctions {
    

    public static int getMinDistance(double[] distancias, boolean[] verticesVisitados){
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
    
    
    public static Object[] getPath(int[] ultimosVertices, double[] distancias, int origen, int destino){
        int target = destino;
        Object[] rutaYDistancia = new Object[2];
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
        rutaYDistancia[0] = ruta;
        rutaYDistancia[1] = distancias[destino];
        return rutaYDistancia;
    }
    
    public static Object[] dijkstra(Grafo grafo, int origen, int destino){
        int[] ultimosVisitados = new int[grafo.getNumVertices()];
        double[] distancias = new double[grafo.getNumVertices()];
        boolean[] verticesVisitados = new boolean[grafo.getNumVertices()];
        
        for (int i = 0; i< grafo.getNumVertices(); i++){
            distancias[i] = Double.MAX_VALUE;
            verticesVisitados[i]  = false;
        }
        
        distancias[origen] = 0;
        
        for (int i = 0; i < grafo.getNumVertices(); i++){
            int v = getMinDistance(distancias, verticesVisitados);
            
            for(int w = 0; w < grafo.getNumVertices(); w++){
                if (!verticesVisitados[w] && grafo.adjacency(v, w) && (distancias[v] + grafo.getPeso(v,w) < distancias[w])){
                    distancias[w] = distancias[v] + grafo.getPeso(v,w);
                    ultimosVisitados[w] = v;
                }
            }
        }
        
        return getPath(ultimosVisitados, distancias, origen, destino);
    }
    
    public static void merge(Object[] rutas, int l, int m, int r){
        int n1 = m - l + 1;
	int n2 = r - m;
	Object[] L = new Object[n1];
	Object[] R = new Object[n2];
        
	for (int i = 0; i < n1; i++) {
            L[i] = rutas[l + i];
	}
	for (int j = 0; j < n2; j++) {
            R[j] = rutas[m + 1 + j];
	}
        
	int i = 0, j = 0;
	int k = l;
        
	while (i < n1 && j < n2) {
            if ((double) ((Object[]) L[i])[1] <= (double) ((Object[]) R[j])[1]) {
                rutas[k] = L[i];
                i++;
            } else {
                rutas[k] = R[j];
            	j++;
            }
            k++;
	}
	while (i < n1) {
            rutas[k] = L[i];
            i++;
            k++;
	}
	while (j < n2) {
            rutas[k] = R[j];
            j++;
            k++;
	}    
    }
    
    public void mergeSort(Object[] rutas, int l, int r){
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(rutas, l, m);
            mergeSort(rutas, m + 1, r);
            merge(rutas, l, m, r);
        }
    }
    
    public Object shortestPath(Grafo g, int[] verticesOrigen, int target) {
        Object[] rutas = new Object[verticesOrigen.length];
        int count = 0;
        for (int i = 0; i < verticesOrigen.length; i++) {
            rutas[count] = dijkstra(g, verticesOrigen[i], target);
            count++;
	}
	mergeSort(rutas, 0, rutas.length - 1);
        
        if ((double) ((Object[]) rutas[0])[1] < Double.MAX_VALUE){
            return rutas[0];
        } else {
            return null;
        }
    }
               
}
