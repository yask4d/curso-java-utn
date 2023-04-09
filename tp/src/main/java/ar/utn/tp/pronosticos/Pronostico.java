package ar.utn.tp.pronosticos;

public class Pronostico {
    // atributos partido, equipo y resultado
    private Partido partido;
    private Equipo equipo;
    private String resultado;

    // constructor
    public Pronostico(Partido partido, Equipo equipo, String resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    // getters y setters
    public Partido getPartido() {
        return partido;
    }
    
    public Equipo getEquipo() {
        return equipo;
    }
    
    public String getResultado() {
        return resultado;
    }
    
    // metodo puntos
    public int puntos() {
        String resultadoReal = partido.resultado(equipo); //este resultado es el que devuelve el metodo resultado de la clase Partido
        if (resultado.equals(resultadoReal)) {   //este resultado es el pronosticado
            return 1;
        } else {
            return 0;
        }                
    }    
}
