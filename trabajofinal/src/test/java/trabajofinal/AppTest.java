package trabajofinal;

import org.junit.Test;

import ar.utn.tp.Partido;
import ar.utn.tp.Pronostico;
import ar.utn.tp.app;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void testCalcularPuntajes() {
        ArrayList<Partido> partidos = new ArrayList<>();
        partidos.add(new Partido(1, "Argentina", 1, 2, "Arabia Saudita"));
        partidos.add(new Partido(1, "Polonia", 0, 0, "Mexico"));
        partidos.add(new Partido(2, "Polonia", 2, 0, "Arabia Saudita"));
        partidos.add(new Partido(2, "Argentina", 2, 0, "Mexico"));
        partidos.add(new Partido(3, "Polonia", 0, 2, "Argentina"));
        partidos.add(new Partido(3, "Arabia Saudita", 1, 2, "Mexico"));

        ArrayList<Pronostico> pronosticos = new ArrayList<>();
        pronosticos.add(new Pronostico("A", 1, "Argentina", "Pierde", "Arabia Saudita"));
        pronosticos.add(new Pronostico("A", 1, "Polonia", "Empata", "Mexico"));
        pronosticos.add(new Pronostico("A", 2, "Polonia", "Empata", "Arabia Saudita"));
        pronosticos.add(new Pronostico("A", 2, "Argentina", "Empata", "Mexico"));
        pronosticos.add(new Pronostico("A", 3, "Polonia", "Gana", "Argentina"));
        pronosticos.add(new Pronostico("A", 3, "Arabia Saudita", "Pierde", "Mexico"));
        
        pronosticos.add(new Pronostico("B", 1, "Argentina", "Empata", "Arabia Saudita"));
        pronosticos.add(new Pronostico("B", 1, "Polonia", "Gana", "Mexico"));
        pronosticos.add(new Pronostico("B", 2, "Polonia", "Pierde", "Arabia Saudita"));
        pronosticos.add(new Pronostico("B", 2, "Argentina", "Empata", "Mexico"));
        pronosticos.add(new Pronostico("B", 3, "Polonia", "Pierde", "Argentina"));
        pronosticos.add(new Pronostico("B", 3, "Arabia Saudita", "Empata", "Mexico"));
        
        pronosticos.add(new Pronostico("C", 1, "Argentina", "Empata", "Arabia Saudita"));
        pronosticos.add(new Pronostico("C", 1, "Polonia", "Pierde", "Mexico"));
        pronosticos.add(new Pronostico("C", 2, "Polonia", "Empata", "Arabia Saudita"));
        pronosticos.add(new Pronostico("C", 2, "Argentina", "Empata", "Mexico"));
        pronosticos.add(new Pronostico("C", 3, "Polonia", "Pierde", "Argentina"));
        pronosticos.add(new Pronostico("C", 3, "Arabia Saudita", "Gana", "Mexico"));
        
        
        

        Map<String, Integer> resultado = app.calcularPuntajes(partidos, pronosticos);

        for (Map.Entry<String, Integer> entry : resultado.entrySet()) {
            System.out.println("Jugador: " + entry.getKey() + ", Puntaje: " + entry.getValue());
        }

        assertTrue(resultado.get("A") == 5);
        assertTrue(resultado.get("B") == 1);
        assertTrue(resultado.get("C") == 1);
        
        System.out.println("Test calcularPuntajes: OK");
    }
}
