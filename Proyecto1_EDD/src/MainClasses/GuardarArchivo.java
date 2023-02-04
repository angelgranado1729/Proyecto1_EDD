package MainClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarArchivo {
    private File archivo;
    
    public GuardarArchivo(String nombreArchivo) {
        archivo = new File(nombreArchivo + ".txt");
    }
    
    public void escribirDatos(String datos) {
        try {
            FileWriter escritor = new FileWriter(archivo, true);
            escritor.write(datos);
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
        }
    }
}
