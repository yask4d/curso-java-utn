import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Ingrese la operación (+, -, *, /): ");
        String operacion = scanner.next();

        System.out.print("Ingrese el segundo número: ");
        double numero2 = scanner.nextDouble();

        scanner.close();

        calculadora calculadora = new calculadora();
        double resultado;

        switch (operacion) {
            case "+":
                resultado = calculadora.sumar(numero1, numero2);
                break;
            case "-":
                resultado = calculadora.restar(numero1, numero2);
                break;
            case "*":
                resultado = calculadora.multiplicar(numero1, numero2);
                break;
            case "/":
                try {
                    resultado = calculadora.dividir(numero1, numero2);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("Operación no válida. Operaciones disponibles: +, -, *, /");
                return;
        }

        System.out.printf("El resultado de %f %s %f es: %f%n", numero1, operacion, numero2, resultado);
    }
}