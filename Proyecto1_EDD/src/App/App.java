/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import static App.FileFunctions.loadData;
import static App.FileFunctions.readTxt;
import GUI.Classes.Inicio;
import MainClasses.Grafo;
import java.io.File;

/**
 *
 * @author Angel Granado
 */
public class App {
    public static Grafo g = new Grafo(); 
    public static String selectedPath = "test\\amazon.txt";
    public static File selectedFile = new File(selectedPath);
    
    
    /**
     * Inicia el programa.
     */
    public static void start(){
       String data = readTxt();
       loadData(data);
       Inicio ventanaInicio = new Inicio();
       ventanaInicio.setVisible(true);
        System.out.println(g.toString());
    }
    
}
