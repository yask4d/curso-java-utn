public class ejercicio_1 {
    public static void main(String[] args) {
        allNumbers(5,17);  // 1-a
        evenNumbers(5,17); // 1-b       
        chooseNumbers(10, 21, true); // 1-c
        showEvenNumbers2(10, 21); // 1-d
    }

    // 1-a // method to show all numbers between a and b
    public static void allNumbers(int a, int b) {
        System.out.println("Los numeros entre " + a + " y " + b + " son: ");
        while (a <= b) {
            System.out.println(a);
            a++;
        }
    }

    // 1-b // method to show only even numbers
    public static void evenNumbers(int a, int b) {    
        System.out.println("Los numeros pares entre " + a + " y " + b + " son: ");
        while (a <= b) {
            if (a % 2 == 0 ) {
                System.out.println(a + " es par");            } 
            a++;
        }
    }

    // 1-c // method to choose if show all numbers or only even numbers    
    public static void chooseNumbers(int a, int b, boolean pares) {
        // if pares is true, show a message
        if (pares == true) {
            System.out.println("Los numeros entre " + a + " y " + b + " que son pares son: ");
        }
        else {
            System.out.println("Los numeros entre " + a + " y " + b + " que son impares son: ");
        }        
        while (a <= b) {
            if (a % 2 == 0 && pares == true) {
                System.out.println(a + " es par");
            }
            else if (a % 2 != 0 && pares == false) {
                System.out.println(a + " es impar");
            }
            a++;
        }
    }

    // 1-d // same as 1-b but using a for loop
    public static void showEvenNumbers2(int a, int b) {
        System.out.println("Los numeros pares entre " + a + " y " + b + " son: ");
        for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " es par");
            }
        }
    }

}
