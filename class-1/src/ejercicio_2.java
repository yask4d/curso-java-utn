

public class ejercicio_2 {
    public static void main(String[] args) {
        income(56, 10, 1, false);
    }


    public static void income(int income, int cantidadVehiculos, int cantidadInmuebles, boolean otrosActivos) {

        // if income is more iqual than 489083 or more than 3 vehicles or more than 2 properties or other assets then declare as a high income
        if (income >= 489083 || cantidadVehiculos > 2 || cantidadInmuebles > 2 || otrosActivos == true) {
            System.out.println("El ingreso es alto");
        }
        else {
            System.out.println("El ingreso es bajo");
        }
    }
}
