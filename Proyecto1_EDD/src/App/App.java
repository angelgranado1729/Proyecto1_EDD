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

    /**
     * @return the g
     */
    public static Grafo getG() {
        return g;
    }

    /**
     * @param aG the g to set
     */
    public static void setG(Grafo aG) {
        g = aG;
    }

    /**
     * @return the selectedPath
     */
    public static String getSelectedPath() {
        return selectedPath;
    }

    /**
     * @param aSelectedPath the selectedPath to set
     */
    public static void setSelectedPath(String aSelectedPath) {
        selectedPath = aSelectedPath;
    }

    /**
     * @return the selectedFile
     */
    public static File getSelectedFile() {
        return selectedFile;
    }

    /**
     * @param aSelectedFile the selectedFile to set
     */
    public static void setSelectedFile(File aSelectedFile) {
        selectedFile = aSelectedFile;
    }

    private static Grafo g = new Grafo();
    private static String selectedPath = "test\\amazon.txt";
    private static File selectedFile = new File(selectedPath);

    /**
     * Inicia el programa.
     */
    public static void start() {
        String data = readTxt();
        loadData(data);
        Inicio ventanaInicio = new Inicio();
        ventanaInicio.setVisible(true);
    }

}
