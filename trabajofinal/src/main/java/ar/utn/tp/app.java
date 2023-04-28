package ar.utn.tp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class app {

    public static void main(String[] args) {
        // Archivo con resultados de partidos
        String partidosFile = "src/test/resources/resultados.csv";
        // Leer partidos desde archivo CSV
        ArrayList<Partido> partidos = readPartidosFromFile(partidosFile);
        // Obtener pronósticos desde la base de datos
        ArrayList<Pronostico> pronosticos = fetchPronosticosFromDatabase();
        // Calcular puntajes de los jugadores
        Map<String, Integer> puntajes = calcularPuntajes(partidos, pronosticos);
        // Mostrar puntajes de los jugadores
        printPuntajes(puntajes);
    }

    // Método para leer partidos desde un archivo CSV
    private static ArrayList<Partido> readPartidosFromFile(String partidosFile) {
        ArrayList<Partido> partidos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(partidosFile))) {
            String line;
            br.readLine(); // Saltar la línea del encabezado
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                partidos.add(new Partido(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[4]));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de partidos: " + e.getMessage());
        }

        return partidos;
    }

    // Método para obtener pronósticos desde la base de datos
    private static ArrayList<Pronostico> fetchPronosticosFromDatabase() {
        ArrayList<Pronostico> pronosticos = new ArrayList<>();

        String jdbcUrl = "jdbc:mysql://localhost:3306/pronosticos?useSSL=false";
        String dbUser = "root";
        String dbPassword = "Skidrow1968";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM pronosticos";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                pronosticos.add(createPronosticoFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener pronósticos de la base de datos: " + e.getMessage());
        }

        return pronosticos;
    }

    // Método para crear un objeto Pronostico desde un ResultSet
    private static Pronostico createPronosticoFromResultSet(ResultSet resultSet) throws SQLException {
        String jugador = resultSet.getString("jugador");
        int ronda = resultSet.getInt("ronda");
        String equipo1 = resultSet.getString("equipo1");
        String equipo2 = resultSet.getString("equipo2");

        String resultado;
        if (resultSet.getBoolean("gano")) {
            resultado = "Gana";
        } else if (resultSet.getBoolean("empato")) {
            resultado = "Empata";
        } else {
            resultado = "Pierde";
        }

        return new Pronostico(jugador, ronda, equipo1, resultado, equipo2);
    }

    
    // Método para calcular puntajes de los jugadores
    public static Map<String, Integer> calcularPuntajes(ArrayList<Partido> partidos, ArrayList<Pronostico> pronosticos) {
        Map<String, Integer> puntajes = new HashMap<>();
        Map<String, Integer> aciertosPorRonda = new HashMap<>();

        // Comparar pronósticos con resultados de partidos
        for (Pronostico pronostico : pronosticos) {
            for (Partido partido : partidos) {
                if (pronostico.getRonda() == partido.getRonda() &&
                        pronostico.getEquipo1().equals(partido.getEquipo1()) &&
                        pronostico.getEquipo2().equals(partido.getEquipo2())) {

                    String pronosticoResultado = pronostico.getResultado();
                    String partidoResultado;
                    if (partido.getGolesEquipo1() > partido.getGolesEquipo2()) {
                        partidoResultado = "Gana";
                    } else if (partido.getGolesEquipo1() < partido.getGolesEquipo2()) {
                        partidoResultado = "Pierde";
                    } else {
                        partidoResultado = "Empata";
                    }

                    // Si el pronóstico es correcto, actualizar puntajes y aciertos por ronda
                    if (pronosticoResultado.equals(partidoResultado)) {
                        String jugador = pronostico.getJugador();
                        puntajes.put(jugador, puntajes.getOrDefault(jugador, 0) + 1);

                        String jugadorRonda = jugador + "_" + pronostico.getRonda();
                        aciertosPorRonda.put(jugadorRonda, aciertosPorRonda.getOrDefault(jugadorRonda, 0) + 1);
                    }
                }
            }
        }

        // Verificar y asignar puntos adicionales por acertar todos los partidos de una ronda
        for (String jugadorRonda : aciertosPorRonda.keySet()) {
            if (aciertosPorRonda.get(jugadorRonda) == partidos.size() / 3) {
                String[] parts = jugadorRonda.split("_");
                String jugador = parts[0];
                puntajes.put(jugador, puntajes.getOrDefault(jugador, 0) + 2);
            }
        }

        return puntajes;
    }

    // Método para imprimir los puntajes de los jugadores
    private static void printPuntajes(Map<String, Integer> puntajes) {
        int maxPuntaje = 0;
        String jugadorGanador = "";

        // Encontrar al jugador con el puntaje más alto
        for (Map.Entry<String, Integer> entry : puntajes.entrySet()) {
            String jugador = entry.getKey();
            int puntaje = entry.getValue();
            if (puntaje > maxPuntaje) {
                maxPuntaje = puntaje;
                jugadorGanador = jugador;
            }
        }

        // Imprimir el puntaje total de cada jugador
        for (Map.Entry<String, Integer> entry : puntajes.entrySet()) {
            String jugador = entry.getKey();
            int puntaje = entry.getValue();
            System.out.println("Jugador: " + jugador + ", Puntaje total: " + puntaje);
        }

        System.out.println("\nEl ganador es: " + jugadorGanador + " con " + maxPuntaje + " puntos.");
    }
}
