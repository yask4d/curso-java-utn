package ar.utn.tp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class app {     
    public static void main(String[] args) {
        
        Collection<Partido> partidos = new ArrayList<Partido>();
    	Path pathResultados = Paths.get("src/test/resources/resultados.csv");
        List <String> lineasResultados = null;
        
        try {
            lineasResultados = Files.readAllLines(pathResultados);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Error al leer el archivo");
            System.exit(1);
            
        }
        Boolean primera = true;
        
        for (String lineaResultado : lineasResultados) {
        	if (primera) {
        		primera = false;        		
        	}else {
        		String[] campos = lineaResultado.split(",");
        		Equipo equipo1 = new Equipo(campos[0]);
                Equipo equipo2 = new Equipo(campos[3]);

        		Partido partido = new Partido(equipo1,equipo2);
                partido.setGolesEquipo1(Integer.parseInt(campos[1]));
                partido.setGolesEquipo2(Integer.parseInt(campos[2]));
                partidos.add(partido);
        		
            //System.out.println(lineaResultado);
        	}
        }

        int puntos = 0;

        Path pathPronosticos = Paths.get("src/test/resources/pronosticos.csv");
        List <String> lineasPronosticos = null;
        
        try {
            lineasPronosticos = Files.readAllLines(pathPronosticos);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Error al leer el archivo");
            System.exit(1);
            
        }
        primera = true;
        for (String lineaPronostico : lineasPronosticos) {
        	if (primera) {
        		primera = false;        		
        	}else {
                String[] campos = lineaPronostico.split(",");
                Equipo equipo1 = new Equipo(campos[0]);
                Equipo equipo2 = new Equipo(campos[4]);
                
                Partido partido = null;

                for (Partido partidoAux : partidos) {
                    if (partidoAux.getEquipo1().getNombre().equals(equipo1.getNombre()) && partidoAux.getEquipo2().getNombre().equals(equipo2.getNombre())) {
                        partido = partidoAux;

                    }
                }
                Equipo equipo = null;
                String resultado = null;
                
                if ("X".equals(campos[1])) {
                    equipo = equipo1;
                    resultado = "ganador";
                    System.out.println(lineaPronostico + "ganador");
                }
                if ("X".equals(campos[2])) {
                    equipo = equipo1;
                    resultado = "empate";
                    System.out.println(lineaPronostico + "empate");
                    
                }
                if ("X".equals(campos[3])) {
                    equipo = equipo1;
                    resultado = "perdedor";
                    System.out.println(lineaPronostico + "perdedor");                    
                }

                Pronostico pronostico = new Pronostico(partido, equipo, resultado);

                puntos += pronostico.Puntos();
                System.out.println(lineaPronostico);

        	}
        }
        // mostrar puntos
        System.out.println("Puntos: "+ puntos);
    }
}