/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import MainClasses.Almacen;
import MainClasses.Grafo;
import MainClasses.Nodo;
import MainClasses.Producto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author Angel Granado
 */
public class FileFunctions {
    
    public static void writeTxt(Grafo g){
        String data = "";
        
        if (!g.isEmpty()){
            data += "Almacenes;" + "\n";
            Nodo<Almacen> pAux = g.getAlmacenes().first();
            
            while (pAux != null){
                data += "Almacen " + pAux.gettInfo().getAlmacen() + ":" + "\n";
                
                Nodo<Producto> auxProduct = pAux.gettInfo().getListaProductos().first();
                while (auxProduct != null){
                    if (pAux.gettInfo().getListaProductos().next(auxProduct) == null){
                        data += auxProduct.gettInfo().getProducto() + "," + auxProduct.gettInfo().getStock() + ";" + "\n";
                    } else {
                        data += auxProduct.gettInfo().getProducto() + "," + auxProduct.gettInfo().getStock() + "\n";  
                    }
                    auxProduct = pAux.gettInfo().getListaProductos().next(auxProduct);
                }
                
                pAux = g.getAlmacenes().next(pAux); 
            }
            
            data += "Rutas;" + "\n";
            int[][] matriz = g.getMatrixAdj().getMatrix();
            for (int i = 0; i  < g.getNumVertices(); i++){
                for (int j = 0; j < g.getNumVertices(); j++){
                    Almacen source = g.getAlmacenes().getByIndex(i).gettInfo();
                    Almacen target = g.getAlmacenes().getByIndex(j).gettInfo();
                    if (source != null && target != null){
                        String nameSource = source.getAlmacen();
                        String nameTarget = source.getAlmacen();
                        data += nameSource + "," + nameTarget + "," + matriz[i][j] + "\n";
                    }
                }
            }
        }
        
        try{
            PrintWriter pw = new PrintWriter("test\\amazon.txt");
            pw.print(data);
            pw.close();
            JOptionPane.showMessageDialog(null, "El archivo ha sido guardado exitosamente!");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al escribir el archivo");
        }
    }
    
    public static Grafo readTxt(){
        Grafo g = new Grafo();
        String line;
        String data = "";
        String path = "test\\amazon.txt";
        File file = new File(path);
        
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
                
                if (!("".equals(data))){
                    String[] almacenes = data.substring("Almacenes;".length(), data.indexOf("Rutas;") - 1).strip().split(";");
                    String[] rutas = data.substring(data.indexOf("Rutas;") + "Rutas;".length()).strip().split("\n");
                    Grafo grafo = new Grafo(almacenes.length);
                    
                    //Llenamos la lista almacenes
                    for (int i = 0 ; i < almacenes.length; i++){
                        String[] almacenInfo = almacenes[i].split("\n");
                        String name = almacenInfo[0].replaceAll("Almacen ", "").strip().replace(":", "");
                        Almacen almacen = new Almacen(name);
                        
                        for (int j = 1; j < almacenInfo.length; j++ ){
                            String[] productoInfo = almacenInfo[j].split(",");
                            Producto producto = new Producto(productoInfo[0], Integer.parseInt(productoInfo[1])); 
                            almacen.getListaProductos().append(producto);
                        }
                        grafo.getAlmacenes().append(almacen);
                    }
                    
                    //Llenamos la matriz de adyacencias
                    for (String info: rutas){
                        String[] rutaInfo = info.split(",");
                        int sourceIndex = grafo.numAlmacen(rutaInfo[0]);
                        int targetIndex = grafo.numAlmacen(rutaInfo[1]);
                        int distance = Integer.parseInt(rutaInfo[2]);
                        grafo.getMatrixAdj().addEdge(sourceIndex, targetIndex, distance); 
                    }
                    
                br.close();
                //Retornamos grafo con la informacion del txt
                return grafo;
                }
                
                br.close();
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
        
        //Retornamos grafo vacio
        return g;
    }
    
}
