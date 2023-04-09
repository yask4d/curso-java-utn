package ar.utn.tp.pronosticos;

import java.nio.file.Path;
import java.nio.file.Paths;

public class app {
    // metodo main
    public static void main(String[] args) {
        // leer archivo de resultados.csv usando paths.get guardarlo en una lista
        
        Path pathResultados = Paths.get(null, "./src/test/resources/resultados.csv");
        // iterar linea a linea pathResultados
        for (Path path : pathResultados) {
            // imprimir path
            System.out.println(path);
            
        }

        



        

    
    }
}
