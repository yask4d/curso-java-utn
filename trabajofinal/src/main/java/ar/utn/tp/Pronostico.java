package ar.utn.tp;

public class Pronostico {
    private String jugador;
    private int ronda;
    private String equipo1;
    private String equipo2;
    private String resultado;

    public Pronostico(String jugador, int ronda, String equipo1, String resultado, String equipo2) {
        this.jugador = jugador;
        this.ronda = ronda;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }

    public String getJugador() {
        return jugador;
    }

    public int getRonda() {
        return ronda;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public String getResultado() {
        return resultado;
    }
}
