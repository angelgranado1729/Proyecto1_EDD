/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import MainClasses.Almacen;
import MainClasses.Grafo;
import MainClasses.LinkedList;
import MainClasses.Node;
import MainClasses.Producto;
import MainClasses.RutasPosibles;
import MainClasses.RutaYDistancia;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel Granado
 */
public class Helpers {

    public static RutaYDistancia dijkstra(Grafo graph, int source, int target) {
        int[] ultimos = new int[graph.getNumVertices()];
        double[] distancias = new double[graph.getNumVertices()];
        boolean[] verticesMarcados = new boolean[graph.getNumVertices()];

        for (int i = 0; i < graph.getNumVertices(); i++) {
            distancias[i] = Double.MAX_VALUE;
            verticesMarcados[i] = false;
        }

        distancias[source] = 0;

        for (int i = 0; i < graph.getNumVertices(); i++) {
            int v = findMinDistance(distancias, verticesMarcados);
            verticesMarcados[v] = true;

            for (int w = 0; w < graph.getNumVertices(); w++) {
                if (!verticesMarcados[w] && graph.getPeso(v, w) != 0 && (distancias[v] + graph.getPeso(v, w) < distancias[w])) {
                    distancias[w] = distancias[v] + graph.getPeso(v, w);
                    ultimos[w] = v;
                }
            }
        }
        return path(ultimos, distancias, source, target);
    }

    // Finding the minimum distance
    private static int findMinDistance(double[] distance, boolean[] visitedVertex) {
        double minDistance = Double.MAX_VALUE;
        int minDistanceVertex = 1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static RutaYDistancia path(int[] ultimos, double[] distancias, int source, int target) {
        int finalPoint = target;
        RutaYDistancia result = new RutaYDistancia();
        int[] aux = new int[ultimos.length];
        int lengthPath = 0;

        while (target != source) {
            aux[lengthPath] = target;
            target = ultimos[target];
            lengthPath++;
        }
        aux[lengthPath] = source;
        int[] path = new int[lengthPath + 1];
        for (int i = 0; i < path.length; i++) {
            path[i] = aux[lengthPath - i];
        }
        result.ruta = path;
        result.distancia = distancias[finalPoint];
        return result;
    }

    public static RutaYDistancia shortestPath(Grafo graph, int[] sources, int target) {
        double minDistance = Double.MAX_VALUE;
        RutasPosibles rutas = new RutasPosibles();
        for (int i = 0; i < sources.length; i++) {
            RutaYDistancia result = dijkstra(graph, sources[i], target);
            if (result.distancia < minDistance) {
                rutas.insertOrdered(result);
                minDistance = result.distancia;
            }
        }
        if (rutas.isEmpty()) {
            return null;
        }
        return rutas.first().getTInfo();
    }

    /**
     * Convierte un string a entero.
     *
     * @param num, el string a convertir.
     * @return retorna la conversion a integer.
     */
    public static int validarNum(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
        }
        return -1;
    }

    /**
     * Convierte un string a double.
     *
     * @param num, el string a convertir.
     * @return retorna la conversion a double.
     */
    public static double validarNumDouble(String num) {
        try {
            return Double.parseDouble(num);
        } catch (NumberFormatException e) {
        }
        return -1;
    }

    public static String toStringPedido(LinkedList<Producto> pedido) {
        String s = "";
        Node<Producto> aux = pedido.first();
        for (int i = 0; i < pedido.size(); i++) {
            s += "-Producto: " + aux.getTInfo().getProducto() + "\n"
                    + "Cantidad Ordenada: " + aux.getTInfo().getStock() + "\n";
            aux = pedido.next(aux);
        }
        return s;
    }

    public static Node<Producto> searchProduct(LinkedList<Producto> list, String product) {
        if (!list.isEmpty()) {
            Node<Producto> aux = list.first();
            Producto prod = new Producto(product);
            while (aux != null) {
                if (aux.getTInfo().getProducto().equalsIgnoreCase(product)) {
                    return aux;
                }
                aux = list.next(aux);
            }
        }
        return null;
    }

    public static void realizarPedidoProced(Almacen almacenOrigen, LinkedList<Producto> pedido) {
        if (!pedido.isEmpty()) {
            boolean pedido_realizable = true;
            LinkedList<Producto> productosNoDisponibles = new LinkedList<>();
            LinkedList<Almacen> almacenesAux = new LinkedList<>();
            Node<Producto> product = pedido.getpFirst();

            // Primero verificamos si el podido se puede reaizar con los productos del almacen origen
            for (int i = 0; i < pedido.size(); i++) {
                Node<Producto> productoEnAlmacen = Helpers.searchProduct(almacenOrigen.getListaProductos(), product.getTInfo().getProducto());
                if (product.getTInfo().getStock() > productoEnAlmacen.getTInfo().getStock()) {
                    pedido_realizable = false;
                    //Agregamos a la lista de productos no disponibles, el producto con las unidades FALTANTES
                    productosNoDisponibles.addEnd(new Producto(product.getTInfo().getProducto(), product.getTInfo().getStock() - productoEnAlmacen.getTInfo().getStock()));
                }
                product = pedido.next(product);
            }

            //Si el pedido se puede realizar con los productos que hay en el almacen origen, entonces se hace el pedido.
            if (pedido_realizable) {
                Node<Producto> producto_pedido = pedido.getpFirst();
                for (int i = 0; i < pedido.size(); i++) {
                    Producto producEnAlmacen = Helpers.searchProduct(almacenOrigen.getListaProductos(), producto_pedido.getTInfo().getProducto()).getTInfo();
                    producEnAlmacen.setStock(producEnAlmacen.getStock() - producto_pedido.getTInfo().getStock());
                    producto_pedido = pedido.next(producto_pedido);
                }
                //Si no, se busca los productos restantes en los otros almacenes de la red
            } else {
                //Primero buscamos los almacenes de la red que tienen los productos faltantes
                Node<Almacen> almacenActual = App.g.getAlmacenes().getpFirst();

                for (int i = 0; i < App.g.getAlmacenes().getiSize(); i++) {
                    if (!almacenActual.getTInfo().getAlmacen().equalsIgnoreCase(almacenOrigen.getAlmacen())) {

                        boolean almacenAux = true;
                        Node<Producto> producNoDisponible = productosNoDisponibles.getpFirst();
                        for (int j = 0; j < productosNoDisponibles.size(); j++) {
                            Node<Producto> prodEnAlmacen = Helpers.searchProduct(almacenActual.getTInfo().getListaProductos(), producNoDisponible.getTInfo().getProducto());
                            if (prodEnAlmacen == null) {
                                almacenAux = false;
                                break;
                            } else {
                                producNoDisponible = productosNoDisponibles.next(producNoDisponible);
                            }
                        }

                        // Si almacenAux sigue siendo true, entonces el almacen puede completar el pedido;
                        if (almacenAux) {
                            almacenesAux.addEnd(almacenActual.getTInfo());
                        }
                    }
                    almacenActual = App.g.getAlmacenes().next(almacenActual);
                }

                //Si la lista de almacenesAux no es vacia, entonces aplicamos dijsktra para encontrar el almacen mas cercano.
                if (!almacenesAux.isEmpty()) {
                    //Determinamos los indices de los almacenes
                    int[] indexAlmacen = new int[almacenesAux.getiSize()];

                    Node<Almacen> aux = almacenesAux.getpFirst();
                    for (int w = 0; w < indexAlmacen.length; w++) {
                        indexAlmacen[w] = App.g.getIndexWarehouse(aux.getTInfo().getAlmacen());
                        System.out.println(indexAlmacen[w]);
                        aux = almacenesAux.next(aux);
                    }
                    
                    //Buscamos el almacen mas cercano que permita completar el pedido
                    RutaYDistancia rutaCorta = Helpers.shortestPath(App.g, indexAlmacen, App.g.getIndexWarehouse(almacenOrigen.getAlmacen()));
                    
                    //Si rutaCorta es null, enotnces no hay almacenes que puedan completar el pedido
                    if (rutaCorta == null){
                        JOptionPane.showMessageDialog(null,"""
                                                           No hay productos suficientes en los almacenes 
                                                           de la red para realizar el pedido
                                                           """);
                    } //En caso contrario, se hace el pdedido.
                    else{
                        //Le descontamos los productos al almacen origen
                        Node<Producto> producto_pedido = pedido.getpFirst();
                        for (int i = 0; i < pedido.size(); i++) {
                            Producto producEnAlmacen = Helpers.searchProduct(almacenOrigen.getListaProductos(), producto_pedido.getTInfo().getProducto()).getTInfo();
                            //Si el almacen origen tiene suficientes unidades, se le resta lo pedido
                            if (producEnAlmacen.getStock() >= producto_pedido.getTInfo().getStock()){
                                producEnAlmacen.setStock(producEnAlmacen.getStock() - producto_pedido.getTInfo().getStock());  
                            //Si no, se toma todas las unidades y el restante se le resta al almacen auxiliar
                            } else{
                               producEnAlmacen.setStock(0); 
                            }
                            producto_pedido = pedido.next(producto_pedido);
                        }
                        
                        //Buscamos los almacenes que forman la ruta minima y almacenamos los nombres en un string
                        String rutaASeguir = "";
                        Almacen[] ruta = new Almacen[rutaCorta.ruta.length];
                        int count = 0;
                        for (int i : rutaCorta.ruta){
                            ruta[count] = App.g.getAlmacenes().getNode(i).getTInfo();
                            if (count < rutaCorta.ruta.length - 1){
                                rutaASeguir += "Almacen " + ruta[count].getAlmacen() + ", ";  
                            } else{
                                rutaASeguir += "Almacen " + ruta[count].getAlmacen();
                            }
                            System.out.println(ruta[count].toString());
                            count++;
                        }
                        //Tomamos el almacen auxiliar (el primero del array ruta) y le descontamos los productos restantes. 
                        //Almacenamos los nombres de los productos faltantes en un string  
                        String productosFaltantes = "";
                        Node<Producto> productoFaltante = productosNoDisponibles.getpFirst();
                        for (int i =0 ; i < productosNoDisponibles.getiSize(); i++){
                            productosFaltantes += "-" + productoFaltante.getTInfo().getProducto() + " (" + productoFaltante.getTInfo().getStock() +")\n";
                            Producto productoEnAlmacenAux = Helpers.searchProduct(ruta[0].getListaProductos(), productoFaltante.getTInfo().getProducto()).getTInfo();
                            int newStock = productoEnAlmacenAux.getStock() - productoFaltante.getTInfo().getStock();
                            productoEnAlmacenAux.setStock(newStock);
                            productoFaltante = productosNoDisponibles.next(productoFaltante);
                        }
                        
                        //Mostramos en un JOptionPane la ruta a seguir:
                        JOptionPane.showMessageDialog(null, "Pedido realizado exitosamente!\n"+
                                "El almacen " + almacenOrigen.getAlmacen() + "no cuenta con la cantidad suficiente de los siguientes productos:\n"
                                        + productosFaltantes +"\nLos productos faltantes seran pedidos al almacen mas cercano: Almacen " + ruta[0].getAlmacen() + 
                                "\n-La ruta a seguir sera la siguiente: " + rutaASeguir +"\n-La distancia a recorrer sera de" + rutaCorta.distancia + " km");
                                        
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(null, """
                                                        No hay suficientes productos en los almacenes 
                                                        de la red para realizar el pedido!""");
                }
//                

            }
        }
    }

}
