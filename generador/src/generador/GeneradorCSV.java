package generador;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorCSV {

    public static void main(String[] args) {

        String[] equipos = {            
            "Brasil",
            "Alemania",
            "Argentina",
            "Italia",
            "Francia",
            "España",
            "Países Bajos",
            "Inglaterra",
            "Uruguay",
            "Portugal",
            "México",
            "Bélgica",
            "Colombia",
            "Chile",
            "Suecia",
            "Hungría",
            "Rusia",
            "Croacia",
            "Dinamarca",
            "Serbia"            
        };
        int numEquipos = equipos.length;

        try {
            FileWriter archivoPartidos = new FileWriter("resultados.csv");
            FileWriter archivoPredicciones = new FileWriter("pronosticos.csv");


            // Encabezados de los archivos CSV
            archivoPartidos.append("Equipo 1,Cantidad de goles 1,Cantidad de goles 2,Equipo 2\n");
            archivoPredicciones.append("Equipo 1,Gana,Empata,Gana,Equipo 2\n");


            // Generación de los juegos y las predicciones a partir de todas las combinaciones de equipos
            for (int i = 0; i < numEquipos - 1; i++) {
                for (int j = i + 1; j < numEquipos; j++) {
                    String equipo1 = equipos[i];
                    String equipo2 = equipos[j];
                    int goles1 = (int) (Math.random() * 5); // Generación aleatoria de goles
                    int goles2 = (int) (Math.random() * 5); // Generación aleatoria de goles
                    archivoPartidos.append(equipo1 + "," + goles1 + "," + goles2 + "," + equipo2 + "\n");

                    // Generación aleatoria de la predicción de un aficionado A
                    int opcion = (int) (Math.random() * 3);
                    String gana1, empata, gana2;
                    if (opcion == 0) {
                        gana1 = "X";
                        empata = "";
                        gana2 = "";
                    } else if (opcion == 1) {
                        gana1 = "";
                        empata = "X";
                        gana2 = "";
                    } else {
                        gana1 = "";
                        empata = "";
                        gana2 = "X";
                    }
                    archivoPredicciones.append(equipo1 + "," + gana1 + "," + empata + "," + gana2 + "," + equipo2 + "\n");
                    
                }
            }

            archivoPartidos.flush();
            archivoPartidos.close();

            archivoPredicciones.flush();
            archivoPredicciones.close();



            System.out.println("Los archivos CSV han sido generados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
