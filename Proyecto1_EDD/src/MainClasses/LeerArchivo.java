package MainClasses;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;

public class LeerArchivo {

  public static void main(String[] args) {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      try {
        BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
        String line = reader.readLine();
        Map<String, Map<String, Integer>> almacenes = new HashMap<>();
        Map<String, Integer> componentes = new HashMap<>();
        String almacenActual = "";
        while (line != null) {
          if (line.startsWith("Almacen ")) {
            if (!componentes.isEmpty()) {
              almacenes.put(almacenActual, componentes);
              componentes = new HashMap<>();
            }
            almacenActual = line.split(" ")[1].substring(0, 1);
          } else if (line.contains(",")) {
            String[] componente = line.split(",");
            componentes.put(componente[0], Integer.parseInt(componente[1]));
          }
          line = reader.readLine();
        }
        almacenes.put(almacenActual, componentes);
        reader.close();

        // aquí puedes acceder a los datos almacenados en el Map almacenes
        System.out.println(almacenes);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}
    
    }
    
