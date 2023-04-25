package trabajofinal;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import ar.utn.tp.Pronostico;
import ar.utn.tp.Partido;
import ar.utn.tp.Equipo;

public class ttestPuntos {
    
    @Test
    public void testPuntos() {
        Equipo equipo1 = new Equipo("Brasil");
        Equipo equipo2 = new Equipo("Alemania");
        Partido partido = new Partido(equipo1, equipo2,1,1);
        
        
        Pronostico pronostico = new Pronostico(partido, equipo1, "empate");
        int puntos = pronostico.Puntos();
        System.out.println("1: " + puntos);
        assertEquals(1, puntos);
        
        
        
        
        

        

    }
}
