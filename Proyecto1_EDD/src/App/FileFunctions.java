/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import MainClasses.Almacen;
import MainClasses.Grafo;
import MainClasses.ListUtilMethods.UtilMethodsPoducts;
import MainClasses.Node;
import MainClasses.Producto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author Angel Granado
 */
public class FileFunctions {
    
    /**
     * Guarda toda la informacion del almacenada en el grafo, en un archivo txt.
     * 
     * @param g, el grafo a guardar.
     */
    public static void saveTxt(Grafo g){
        String data = "";
        
        if (!g.isEmpty()){
            data += "Almacenes;" + "\n";
            Node<Almacen> pAux = g.getAlmacenes().first();
            
            while (pAux != null){
                data += "Almacen " + pAux.getTInfo().getAlmacen() + ":" + "\n";
                
                Node<Producto> auxProduct = pAux.getTInfo().getListaProductos().first();
                while (auxProduct != null){
                    if (pAux.getTInfo().getListaProductos().next(auxProduct) == null){
                        data += auxProduct.getTInfo().getProducto() + "," + auxProduct.getTInfo().getStock() + ";" + "\n";
                    } else {
                        data += auxProduct.getTInfo().getProducto() + "," + auxProduct.getTInfo().getStock() + "\n";  
                    }
                    auxProduct = pAux.getTInfo().getListaProductos().next(auxProduct);
                }
                
                pAux = g.getAlmacenes().next(pAux); 
            }
            
            data += "Rutas;" + "\n";
            double[][] matriz = g.getMatrixAdj().getMatrix();
            for (int i = 0; i  < g.getNumVertices(); i++){
                for (int j = 0; j < g.getNumVertices(); j++){
                    Almacen source = g.getAlmacenes().getNode(i).getTInfo();
                    Almacen target = g.getAlmacenes().getNode(j).getTInfo();
                    if (source != null && target != null){
                        String nameSource = source.getAlmacen();
                        String nameTarget = target.getAlmacen();
                        if (matriz[i][j] != 0){
                            if (matriz[i][j] % 1 == 0){
                                data += nameSource + "," + nameTarget + "," + (int) matriz[i][j] + "\n";  
                            } else{
                                data += nameSource + "," + nameTarget + "," +  matriz[i][j] + "\n";     
                            }
                        }
                    }
                }
            }
        }
        try{
            // Crear un objeto FileWriter para escribir en el archivo
            FileWriter fileWriter = new FileWriter(App.selectedFile);

            // Crear un objeto PrintWriter para escribir texto en el archivo
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Escribir en el archivo utilizando el método print o println
            printWriter.print(data);

            // Cerrar el archivo para liberar recursos
            printWriter.close();
            
            JOptionPane.showMessageDialog(null, "El archivo ha sido guardado exitosamente!");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al escribir el archivo");         
        } 
    }
    
    /**
     * Carga los datos del string obtenido al leer el txt y los carga en el grafo y
     * a los TDA asociados.
     * 
     * @param data, string con toda la informacion que contiene el txt.
     */
    public static void loadData(String data){
        if (!("".equals(data))){
            String[] almacenes = data.substring("Almacenes;".length(), data.indexOf("Rutas;") - 1).strip().split(";");
            String[] rutas = data.substring(data.indexOf("Rutas;") + "Rutas;".length()).strip().split("\n");         
            Grafo grafo = new Grafo(almacenes.length);
                    
            //Llenamos la lista almacenes
            for (String almacenData: almacenes){
                String[] dataBruta = almacenData.split(":");   
                
                String name = dataBruta[0].replaceAll("Almacen ", "").strip();
                String[] productsData = dataBruta[1].split("\n");
                Almacen almacen = new Almacen(name);
                almacen.getListaProductos().setMethods(new UtilMethodsPoducts());
                
                for (String productData: productsData){
                    if (!productData.equalsIgnoreCase("")){
                        String[] productInfo = productData.split(",");
                        Producto producto = new Producto(productInfo[0], Integer.parseInt(productInfo[1]));
                        almacen.getListaProductos().addEnd(producto);
                    }
                }
                grafo.getAlmacenes().addEnd(almacen);
            }
            
            
            //Llenamos la matriz de adyacencia
            for (String rutaData: rutas){
                String[] rutaInfo = rutaData.split(",");
                String source = rutaInfo[0];
                String target = rutaInfo[1];
                double distance = Double.parseDouble(rutaInfo[2]);
                try{
                    grafo.addEdge(source, target, distance);
                } catch (Exception e){
                }                
            }
            //Retornamos grafo con la informacion del txt
            App.g = grafo;
        }  
    }
    
    /**
     * Lee la informacion del txt y lo retorna en un string.
     */
    public static String readTxt(){
        String line;
        String data = "";
        File file = App.selectedFile;
        
        try{
            if (!file.exists()){
                file.createNewFile();
            } else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                
                while ((line = br.readLine()) != null){
                    if (!(line.isEmpty())){
                        data += line + "\n";
                    }
                }
                br.close();
            }    
            return data;   
        } catch (Exception e){
        }
        return data;       
    }
  
    
}