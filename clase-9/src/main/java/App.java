
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ingresar persona");
            System.out.println("2. Listar personas");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("Ingrese nombre:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese apellido:");
                String apellido = scanner.nextLine();
                System.out.println("Ingrese fecha de nacimiento:");
                String fechaNacimiento = scanner.nextLine();

                Persona persona = new Persona();
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setFechaNacimiento(fechaNacimiento);

                personas.add(persona);

            } else if (opcion == 2) {
                for (Persona persona : personas) {
                    System.out.println("Nombre: " + persona.getNombre() + ", Apellido: " + persona.getApellido() + ", Fecha de nacimiento: " + persona.getFechaNacimiento());
                }
            } else if (opcion == 3) {
                break;
            }
        }
        scanner.close();
    }
}
