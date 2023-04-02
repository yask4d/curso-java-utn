import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class leefile {
    public static void main(String[] args) {
        // leer archivo
        String archivo = "C:\\temp\\docker-compose.yml" ;
        try {
            for (String line : Files.readAllLines(Paths.get(archivo))) {
                // print the line if it contains the word "django"
                if (line.contains("django")) {
                    System.out.println(line);
                }
                //System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
       
    
}
