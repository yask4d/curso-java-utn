package ar.utn.tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class app {
    public static void main(String[] args) {
        String partidosFile = "src/test/resources/resultados.csv";        
        ArrayList<Partido> partidos = new ArrayList<>();
        ArrayList<Pronostico> pronosticos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(partidosFile))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                partidos.add(new Partido(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        String jdbcUrl = "jdbc:mysql://localhost:3306/pronosticos?useSSL=false";
        String dbUser = "root";
        String dbPassword = "Skidrow1968";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM pronosticos";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
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

                pronosticos.add(new Pronostico(jugador, ronda, equipo1, resultado, equipo2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
  
        Map<String, Integer> puntajes = calcularPuntajes(partidos, pronosticos);

        //Map<String, Integer> puntajes = new HashMap<>();
        Map<String, Integer> aciertosPorRonda = new HashMap<>();

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

                    if (pronosticoResultado.equals(partidoResultado)) {
                        String jugador = pronostico.getJugador();
                        String jugadorRonda = jugador + "-" + pronostico.getRonda();
                        puntajes.put(jugador, puntajes.getOrDefault(jugador, 0) + 1);
                        aciertosPorRonda.put(jugadorRonda, aciertosPorRonda.getOrDefault(jugadorRonda, 0) + 1);
                    }
                }
            }
        }

        for (String jugadorRonda : aciertosPorRonda.keySet()) {
            if (aciertosPorRonda.get(jugadorRonda) == partidos.size() / 3) {
                String[] jugadorRondaSplit = jugadorRonda.split("-");
                String jugador = jugadorRondaSplit[0];
                puntajes.put(jugador, puntajes.get(jugador) + 2);
            }
        }

        int maxPuntaje = 0;
        String jugadorGanador = "";

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
    
    public static Map<String, Integer> calcularPuntajes(ArrayList<Partido> partidos, ArrayList<Pronostico> pronosticos) {
        Map<String, Integer> puntajes = new HashMap<>();
        Map<String, Integer> aciertosPorRonda = new HashMap<>();

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

                    if (pronosticoResultado.equals(partidoResultado)) {
                        String jugador = pronostico.getJugador();
                        puntajes.put(jugador, puntajes.getOrDefault(jugador, 0) + 1);

                        String jugadorRonda = jugador + "_" + pronostico.getRonda();
                        aciertosPorRonda.put(jugadorRonda, aciertosPorRonda.getOrDefault(jugadorRonda, 0) + 1);
                    }
                }
            }
        }

        for (String jugadorRonda : aciertosPorRonda.keySet()) {
            if (aciertosPorRonda.get(jugadorRonda) == partidos.size() / 3) {
                String[] parts = jugadorRonda.split("_");
                String jugador = parts[0];
                puntajes.put(jugador, puntajes.getOrDefault(jugador, 0) + 2);
            }
        }

        return puntajes;
    }

}



            	