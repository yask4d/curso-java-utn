import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            FileWriter archivoPartidos = new FileWriter("partidos.csv");
            FileWriter archivoPredicciones = new FileWriter("predicciones.csv");

            // Encabezados de los archivos CSV
            archivoPartidos.append("Equipo 1,Cantidad de goles 1,Equipo 2,Cantidad de goles 2\n");
            archivoPredicciones.append("Equipo 1,Gana,Empata,Gana,Equipo 2\n");

            // Generación aleatoria de parejas de equipos
            List<String[]> parejas = new ArrayList<String[]>();
            List<String> equiposList = new ArrayList<String>();
            for (int i = 0; i < numEquipos; i++) {
                equiposList.add(equipos[i]);
            }
            Collections.shuffle(equiposList); // Mezcla aleatoria de los equipos
            for (int i = 0; i < numEquipos/2; i++) {
                String[] pareja = {equiposList.get(i), equiposList.get(i+numEquipos/2)};
                parejas.add(pareja);
            }

            // Generación de los juegos y las predicciones a partir de las parejas
            for (String[] pareja : parejas) {
                String equipo1 = pareja[0];
                String equipo2 = pareja[1];
                int goles1 = (int) (Math.random() * 5); // Generación aleatoria de goles
                int goles2 = (int) (Math.random() * 5); // Generación aleatoria de goles
                archivoPartidos.append(equipo1 + "," + goles1 + "," + equipo2 + "," + goles2 + "\n");

                // Generación aleatoria de la predicción de un aficionado
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



