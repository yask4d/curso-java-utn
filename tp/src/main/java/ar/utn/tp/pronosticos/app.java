package ar.utn.tp.pronosticos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class app {
    // metodo main
    public static void main(String[] args) {
        // leer archivo de resultados.csv usando paths.get guardarlo en una lista
        
        List <String> lineas = null;
        Path pathResultados = Paths.get("C:\\Users\\Kadyr Valdes\\Documents\\curso-java-utn\\tp\\src\\test\\resources\\resultados.csv");
        try {
            lineas = Files.readAllLines(pathResultados);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        // iterar linea a linea la lista de resultados
        for (String linea : lineas) {
            // imprimir linea
            System.out.println(linea);
            
        }

           

    
    
}
}