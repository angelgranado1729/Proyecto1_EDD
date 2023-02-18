/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import MainClasses.Almacen;
import MainClasses.Grafo;
import MainClasses.LinkedList;
import MainClasses.Node;
import MainClasses.RutaCorta;
import MainClasses.RutasPosibles;
import MainClasses.RutasYDistancias;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 *
 * @author Angel Granado
 */
public class Helpers {  

    public static int getVerticeMinDistance(double[] distancias, boolean[] verticesVisitados){
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
     
    public static int validarNum(String num){
        try{
            return Integer.parseInt(num) ;
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Revise los datos ingresados.");
        }
        return -1;
    }
    

    
//    public static void guardarTXT() throws IOException{
//        String data = App.getPlaylist().toString().replaceAll(" ", "");
//        
//     
//        try{
//            // Crear un objeto FileWriter para escribir en el archivo
//            FileWriter fileWriter = new FileWriter(App.getSelectedFile());
//
//            // Crear un objeto PrintWriter para escribir texto en el archivo
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            // Escribir en el archivo utilizando el método print o println
//            printWriter.println(data);
//
//            // Cerrar el archivo para liberar recursos
//            printWriter.close();
//            
//        } catch (Exception e){
//            
//        }
//            
//    }
               
}
