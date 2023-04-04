import java.util.Scanner;

public class ejercicio_1_b {
    public static void main(String[] args) {        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Ingrese los tres n\u00FAmeros separados por un espacio: ");        
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.print("Ingrese 'a' para ordenar en forma ascendente o 'd' para ordenar en forma descendente: ");
            String orden = sc.next();
            boolean ascendent = orden.equalsIgnoreCase("a");

            int[] ordenado = orderNumbers(a, b, c, ascendent);
            for (int i = 0; i < ordenado.length; i++) {
                
                System.out.print(ordenado[i] + " ");

            }
        }        
    }
    
    public static int[] orderNumbers(int a, int b, int c, boolean ascendent) {
        int[] ordenado = new int[3];
        if (ascendent == true) {
            if (a < b && a < c) {
                ordenado[0] = a;
                if (b < c) {
                    ordenado[1] = b;
                    ordenado[2] = c;
                } else {
                    ordenado[1] = c;
                    ordenado[2] = b;
                }
            } else if (b < a && b < c) {
                ordenado[0] = b;
                if (a < c) {
                    ordenado[1] = a;
                    ordenado[2] = c;
                } else {
                    ordenado[1] = c;
                    ordenado[2] = a;
                }
            } else if (c < a && c < b) {
                ordenado[0] = c;
                if (a < b) {
                    ordenado[1] = a;
                    ordenado[2] = b;
                } else {
                    ordenado[1] = b;
                    ordenado[2] = a;
                }
            }
        } else {
            if (a > b && a > c) {
                ordenado[0] = a;
                if (b > c) {
                    ordenado[1] = b;
                    ordenado[2] = c;
                } else {
                    ordenado[1] = c;
                    ordenado[2] = b;
                }
            } else if (b > a && b > c) {
                ordenado[0] = b;
                if (a > c) {
                    ordenado[1] = a;
                    ordenado[2] = c;
                } else {
                    ordenado[1] = c;
                    ordenado[2] = a;
                }
            } else if (c > a && c > b) {
                ordenado[0] = c;
                if (a > b) {
                    ordenado[1] = a;
                    ordenado[2] = b;
                } else {
                    ordenado[1] = b;
                    ordenado[2] = a;
                }
            }
        }
        return ordenado;
    }
}
