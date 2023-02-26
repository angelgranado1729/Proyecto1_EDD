/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import MainClasses.Almacen;
import MainClasses.Grafo;
import MainClasses.LinkedList;
import MainClasses.MatrizAdj;
import MainClasses.Node;
import MainClasses.Producto;
import MainClasses.RutasPosibles;
import MainClasses.RutaYDistancia;
import javax.swing.JOptionPane;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author Angel Granado
 */
public class Helpers {

    /**
     * Determina la ruta mas corta mas corta entre dos vertices usando el
     * algoritmo de Dijkstra.
     *
     * @param graph, el grafo donde se va a aplicar Dijkstra.
     * @param source, el inidice del vertice inicio de la ruta.
     * @param target, el indice del vertice destino de la ruta.
     * @return una instancia del objeto RutaYDistancia, que contiene la ruta mas
     * corta y la distancia.
     */
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

    /**
     * Determina el vertice con la menor distancia a un vertice dado.
     *
     * @param distance, un array con las distancias que hay desde el vertice
     * origen y los demas vertices del grafo.
     * @param visitedVertex, un array de boolean que indica los vertices que ya
     * han sido vesitados.
     * @return el indice del vertice con menor distancia.
     */
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

    /**
     * Reconstruye la ruta minima que resulta de implementar Dijkstra.
     *
     * @param ultimos, un array con los inidices de los ultimos vertices
     * visitados en la ruta.
     * @param distancias, un array con las distancias de las rutas que parten
     * del vertice origen a los otros vertices del grafo.
     * @param source, indice del vertice origen.
     * @param target, indice del vertice destino.
     * @return una instancia de la clase RutaYDistancia que contiene la ruta
     * minima y la distancia.
     */
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

    /**
     * Dado un array de vertices, determina la ruta mas corta posible que tiene
     * como origen a uno de los vertices del array y el vertice destino dado.
     *
     * @param graph, el grafo donde se desea determinar la ruta corta.
     * @param sources, el array con los indices de los vertices origen.
     * @param target, el indice del vertice destino.
     * @return retorna una instancia de la clase RutaYDistancia que contiene la
     * ruta minima y la distancia.
     */
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

    /**
     * Retorna un string con los productos del pedido realizado.
     *
     * @param pedido, una lista con los productos del pedido.
     * @return un string con la informacion de los productos del pedido.
     */
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

    /**
     * Busca el nodo que contiene a un producto dado.
     *
     * @param list, la lista de productos donde se desea realizar la busqueda.
     * @param product, el nombre del producto a buscar.
     * @return si el producto existe entonces retorna el nodo, si no entonces
     * retorna null.
     */
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

    /**
     * Determina si el pedido se puede realizar, si se puede lo realiza, y en
     * caso de ser necesario, determina el almacen mas cercano que permita
     * completar los productos faltantes para realizar el pedido.
     *
     * @param almacenOrigen, el almacen donde se va a realizar el pedido
     * @param pedido, la lista de productos que conforman el pedido.
     */
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
                String productosPedidos = "";
                for (int i = 0; i < pedido.size(); i++) {
                    productosPedidos += "-" + producto_pedido.getTInfo().getProducto() + " (" + producto_pedido.getTInfo().getStock() + ")";
                    Producto producEnAlmacen = Helpers.searchProduct(almacenOrigen.getListaProductos(), producto_pedido.getTInfo().getProducto()).getTInfo();
                    producEnAlmacen.setStock(producEnAlmacen.getStock() - producto_pedido.getTInfo().getStock());
                    producto_pedido = pedido.next(producto_pedido);
                }

                //Mostramos un mensaje con el resumen de la compra
                JOptionPane.showMessageDialog(null, """
                                                    Pedido realizado exitosamente!
                                                    
                                                    Resumen del pedido:
                                                    """ + productosPedidos);

                //Si no, se busca los productos restantes en los otros almacenes de la red
            } else {
                //Primero buscamos los almacenes de la red que tienen los productos faltantes
                Node<Almacen> almacenActual = App.getG().getAlmacenes().getpFirst();
                for (int i = 0; i < App.getG().getAlmacenes().getiSize(); i++) {
                    if (!almacenActual.getTInfo().getAlmacen().equalsIgnoreCase(almacenOrigen.getAlmacen())) {

                        boolean almacenAux = true;
                        Node<Producto> producNoDisponible = productosNoDisponibles.getpFirst();
                        for (int j = 0; j < productosNoDisponibles.size(); j++) {
                            Node<Producto> prodEnAlmacen = Helpers.searchProduct(almacenActual.getTInfo().getListaProductos(), producNoDisponible.getTInfo().getProducto());

                            //Verificamos que el almacen tenga la cantidad suficiente para realizar el pedido
                            if (prodEnAlmacen == null) {
                                almacenAux = false;
                                break;
                            } else if (prodEnAlmacen.getTInfo().getStock() < producNoDisponible.getTInfo().getStock()) {
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
                    almacenActual = App.getG().getAlmacenes().next(almacenActual);
                }

                //Si la lista de almacenesAux no es vacia, entonces aplicamos dijsktra para encontrar el almacen mas cercano.
                if (!almacenesAux.isEmpty()) {
                    //Determinamos los indices de los almacenes
                    int[] indexAlmacen = new int[almacenesAux.getiSize()];

                    Node<Almacen> aux = almacenesAux.getpFirst();
                    for (int w = 0; w < indexAlmacen.length; w++) {
                        indexAlmacen[w] = App.getG().getIndexWarehouse(aux.getTInfo().getAlmacen());
                        aux = almacenesAux.next(aux);
                    }

                    //Buscamos el almacen mas cercano que permita completar el pedido
                    RutaYDistancia rutaCorta = Helpers.shortestPath(App.getG(), indexAlmacen, App.getG().getIndexWarehouse(almacenOrigen.getAlmacen()));

                    //Si rutaCorta es null, enotnces no hay almacenes que puedan completar el pedido
                    if (rutaCorta == null) {
                        JOptionPane.showMessageDialog(null, """
                                                           No hay productos suficientes en los almacenes 
                                                           de la red para realizar el pedido
                                                           """);
                    } //En caso contrario, se hace el pdedido.
                    else {
                        //Le descontamos los productos al almacen origen
                        Node<Producto> producto_pedido = pedido.getpFirst();
                        for (int i = 0; i < pedido.size(); i++) {
                            Producto producEnAlmacen = Helpers.searchProduct(almacenOrigen.getListaProductos(), producto_pedido.getTInfo().getProducto()).getTInfo();
                            //Si el almacen origen tiene suficientes unidades, se le resta lo pedido
                            if (producEnAlmacen.getStock() >= producto_pedido.getTInfo().getStock()) {
                                producEnAlmacen.setStock(producEnAlmacen.getStock() - producto_pedido.getTInfo().getStock());
                                //Si no, se toma todas las unidades y el restante se le resta al almacen auxiliar
                            } else {
                                producEnAlmacen.setStock(0);
                            }
                            producto_pedido = pedido.next(producto_pedido);
                        }

                        //Buscamos los almacenes que forman la ruta minima y almacenamos los nombres en un string
                        String rutaASeguir = "";
                        Almacen[] ruta = new Almacen[rutaCorta.ruta.length];
                        int count = 0;
                        for (int i : rutaCorta.ruta) {
                            ruta[count] = App.getG().getAlmacenes().getNode(i).getTInfo();
                            if (count < rutaCorta.ruta.length - 1) {
                                rutaASeguir += "Almacen " + ruta[count].getAlmacen() + ", ";
                            } else {
                                rutaASeguir += "Almacen " + ruta[count].getAlmacen();
                            }
                            count++;
                        }
                        //Tomamos el almacen auxiliar (el primero del array ruta) y le descontamos los productos restantes. 
                        //Almacenamos los nombres de los productos faltantes en un string  
                        String productosFaltantes = "";
                        Node<Producto> productoFaltante = productosNoDisponibles.getpFirst();
                        for (int i = 0; i < productosNoDisponibles.getiSize(); i++) {
                            productosFaltantes += "-" + productoFaltante.getTInfo().getProducto() + " (" + productoFaltante.getTInfo().getStock() + ")\n";
                            Producto productoEnAlmacenAux = Helpers.searchProduct(ruta[0].getListaProductos(), productoFaltante.getTInfo().getProducto()).getTInfo();
                            int newStock = productoEnAlmacenAux.getStock() - productoFaltante.getTInfo().getStock();
                            productoEnAlmacenAux.setStock(newStock);
                            productoFaltante = productosNoDisponibles.next(productoFaltante);
                        }

                        //Mostramos en un JOptionPane la ruta a seguir:
                        JOptionPane.showMessageDialog(null, """
                                                            Pedido realizado exitosamente!
                                                            El almacen """ + almacenOrigen.getAlmacen() + " no cuenta con la cantidad suficiente de los siguientes productos:\n"
                                + productosFaltantes + "\nLos productos faltantes seran pedidos al almacen mas cercano: Almacen " + ruta[0].getAlmacen()
                                + "\n-La ruta a seguir sera la siguiente: " + rutaASeguir + "\n-La distancia a recorrer sera de " + rutaCorta.distancia + " km");

                        Helpers.plotGraph(ruta);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, """
                                                        No hay suficientes productos en los almacenes 
                                                        de la red para realizar el pedido!""");
                }
            }
        }
    }

    /**
     * Registra un almacen en el grafo.
     *
     * @param nuevoAlmacen, nombre del almacen.
     * @param almacenInicioIndex, el indice del almacen inicio.
     * @param almacenDestinoIndex, el indice del almacen destino.
     * @param distancia1, distancia entre el almacen inicio y el nuevo almacen.
     * @param distancia2, distancia entre el nuevo almacen y el almacen destino.
     */
    public static void registrarNuevoAlmacen(String nuevoAlmacen, int almacenInicioIndex, int almacenDestinoIndex, double distancia1, double distancia2) {
        if (!nuevoAlmacen.equals("")) {
            //Primero verificamos si el almacen ya esta registrado
            boolean almacenRegistrado = false;
            Node<Almacen> currentAlmacen = App.getG().getAlmacenes().getpFirst();
            for (int i = 0; i < App.getG().getNumVertices(); i++) {
                if (currentAlmacen.getTInfo().getAlmacen().equalsIgnoreCase(nuevoAlmacen)) {
                    almacenRegistrado = true;
                    break;
                }
                currentAlmacen = App.getG().getAlmacenes().next(currentAlmacen);
            }

            //Si no esta registrado, entonces se registra en el grafo.
            if (!almacenRegistrado) {
                //Si no hay espacio, se crea una nueva matriz de adyacencia y luego se registra el almacen
                if (App.getG().getNumVertices() == App.getG().getNumMaxVertices()) {
                    //Creamos la nueva matriz de adyacencia
                    MatrizAdj newMatrix = new MatrizAdj(App.getG().getNumMaxVertices());

                    //Pasamos la informacion anterior a la matriz
                    for (int i = 0; i < App.getG().getNumVertices(); i++) {
                        for (int j = 0; j < App.getG().getNumVertices(); j++) {
                            newMatrix.getMatrix()[i][j] = App.getG().getMatrixAdj().getMatrix()[i][j];
                        }
                    }

                    //Colocamos la nueva matriz en el grafo
                    App.getG().setMatrixAdj(newMatrix);

                    //Colocamos el nuevo numero maximo de vertices
                    App.getG().setNumMaxVertices(newMatrix.getNumMaxVertices());
                }

                //Registramos el almacen en la lista de almacenes (el procedimiento ya modifica el numero de vertices
                App.getG().getAlmacenes().addEnd(new Almacen(nuevoAlmacen));
                App.getG().setNumVertices(App.getG().getAlmacenes().getiSize());
                App.getG().getMatrixAdj().setNumVertices(App.getG().getAlmacenes().getiSize());

                //Ahora registramos la rutas asociadas al nuevo almacen.
                //Primero buscamos el indice del nuevo almacen, que justamente coincide con el numero de vertices del grafo.
                int nuevoAlmacenIndex = App.getG().getNumVertices() - 1;

                //Luego registramos s rutas en la matriz de adyacencia
                App.getG().getMatrixAdj().getMatrix()[almacenInicioIndex][nuevoAlmacenIndex] = distancia1;
                App.getG().getMatrixAdj().getMatrix()[nuevoAlmacenIndex][almacenDestinoIndex] = distancia2;

                //Mostramos un mensaje que indica que el almacen ha sido registrado exitosamente.
                JOptionPane.showMessageDialog(null, "El almacen " + nuevoAlmacen
                        + " ha sido registrado exitosamente!\n\n"
                        + "-Ruta 1: Almacen " + App.getG().getAlmacenes().getNode(almacenInicioIndex).getTInfo().getAlmacen()
                        + " ----> Almacen " + nuevoAlmacen + "(" + distancia1 + " km)\n" + "\n-Ruta 2: Almacen " + nuevoAlmacen + " ----> "
                        + "Almacen " + App.getG().getAlmacenes().getNode(almacenDestinoIndex).getTInfo().getAlmacen() + " (" + distancia2 + " km)");

                //Si ya hay un almacen con el mismo nombre entonces no se registra el almacen.
            } else {
                JOptionPane.showMessageDialog(null, "El almacen " + nuevoAlmacen
                        + " ya esta registrado en la red de almacenes");

            }
        }
    }

    /**
     * Grafica el grafo, donde los vertices son los almacenes registrados.
     *
     * @param almacenes
     */
    public static void plotGraph(Almacen[] almacenes) {
        MultiGraph graph = new MultiGraph("Mi grafo");

        for (int i = 0; i < App.getG().getNumVertices(); i++) {
            String nombre = App.getG().getAlmacenes().getNode(i).getTInfo().getAlmacen();
            graph.addNode(nombre).setAttribute("ui.label", nombre + "\n");
        }

        for (int i = 0; i < App.getG().getMatrixAdj().getMatrix().length; i++) {
            for (int j = 0; j < App.getG().getMatrixAdj().getMatrix()[i].length; j++) {
                double peso = App.getG().getPeso(i, j);
                if (peso > 0) {
                    String nombreNodo1 = App.getG().getAlmacenes().getNode(i).getTInfo().getAlmacen();
                    String nombreNodo2 = App.getG().getAlmacenes().getNode(j).getTInfo().getAlmacen();
                    String edgeName = nombreNodo1 + " " + nombreNodo2;
                    graph.addEdge(edgeName, nombreNodo1, nombreNodo2, true);
                    Edge edge = graph.getEdge(edgeName);
                    if (peso % 1 == 0){
                        edge.setAttribute("ui.label", (int) peso + " km");   
                    } else{
                        edge.setAttribute("ui.label", peso + " km");    
                    }
                }
            }
        }

        graph.setAttribute("ui.stylesheet", "node { text-offset: 0px, -10px; size: 15px; text-size: 15;"
                + " fill-color: #232F3E; text-alignment: above; text-color: #222; text-background-mode: plain;"
                + " text-background-color: white; } edge { size: 2px; fill-color: #444; text-alignment: above; "
                + "text-size: 20; arrow-size: 12; text-color: #000000; text-offset: 10px, -20px;}");
        System.setProperty("org.graphstream.ui", "swing");

        if (almacenes != null) {
            for (int i = 0; i < almacenes.length; i++) {
                for (int j = i + 1; j < almacenes.length; j++) {
                    Edge ed = graph.getEdge(almacenes[i].getAlmacen() + " " + almacenes[j].getAlmacen());
                    if (ed != null) {
                        ed.setAttribute("ui.style", "fill-color: #FF9900; text-color: #FF9900;");
                        graph.getNode(almacenes[i].getAlmacen()).setAttribute("ui.style", "fill-color: #FF9900; text-color: #FF9900;");
                        graph.getNode(almacenes[i+1].getAlmacen()).setAttribute("ui.style", "fill-color: #FF9900; text-color: #FF9900;");

                    }
                }
            }
            String receptor = almacenes[almacenes.length - 1].getAlmacen();
            graph.getNode(receptor).setAttribute("ui.label", "Almacen Receptor: " + almacenes[almacenes.length-1].getAlmacen());
            String auxiliar = almacenes[0].getAlmacen();
            graph.getNode(auxiliar).setAttribute("ui.label", "Almacen Auxiliar: " + almacenes[0].getAlmacen());
        }

        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
    }

}
