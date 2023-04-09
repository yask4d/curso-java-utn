package utn.tp;

public class Partido {

    // Atributos equipo1, equipo2, golesEquipo1, golesEquipo2
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    // Constructor
    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    // Getters y Setters
    public Equipo getEquipo1() {
        return equipo1;
    }
    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }
    public Equipo getEquipo2() {
        return equipo2;
    }
    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }
    public int getGolesEquipo1() {
        return golesEquipo1;
    }
    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }
    public int getGolesEquipo2() {
        return golesEquipo2;
    }
    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    // metodo resultado
    public String resultado(Equipo equipo) {
        // si el equipo es el equipo1
        if (equipo.equals(equipo1)) {
            // si los goles del equipo1 son mayores que los del equipo2
            if (golesEquipo1 > golesEquipo2) {
                return "ganador";
            }
            // si los goles del equipo1 son menores que los del equipo2
            else if (golesEquipo1 < golesEquipo2) {
                return "perdedor";
            }
            // si los goles del equipo1 son iguales que los del equipo2
            else {
                return "empate";
            }
        }
        return null;               
        
    }
}
