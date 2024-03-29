public class ejercicio_1 {
    public static void main(String[] args) {
        System.out.println(countLetter("Hola que tal", 'a')); // 3-1a //  
        int[] ordenado = orderNumbers(41, 22, 11, true);
        for (int i = 0; i < ordenado.length; i++) {
            System.out.print(ordenado[i] + " ");
        }        
    }
    
    public static int countLetter(String texto, char letra) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == letra) {
                contador++;
            }
        }
        return contador;
    }

    public static int[] orderNumbers(int a, int b, int c, boolean ascendent) {
        int[] ordenado = new int[3];
        if (ascendent == true) {
            if (a < b && a < c) {
                ordenado[0] = a;
                if (b < c) {
                    ordenado[1] = b;
                    ordenado[2] = c;
                }
                else {
                    ordenado[1] = c;
                    ordenado[2] = b;
                }
            }
            else if (b < a && b < c) {
                ordenado[0] = b;
                if (a < c) {
                    ordenado[1] = a;
                    ordenado[2] = c;
                }
                else {
                    ordenado[1] = c;
                    ordenado[2] = a;
                }
            }
            else if (c < a && c < b) {
                ordenado[0] = c;
                if (a < b) {
                    ordenado[1] = a;
                    ordenado[2] = b;
                }
                else {
                    ordenado[1] = b;
                    ordenado[2] = a;
                }
            }
        }
        else {
            if (a > b && a > c) {
                ordenado[0] = a;
                if (b > c) {
                    ordenado[1] = b;
                    ordenado[2] = c;
                }
                else {
                    ordenado[1] = c;
                    ordenado[2] = b;
                }
            }
            else if (b > a && b > c) {
                ordenado[0] = b;
                if (a > c) {
                    ordenado[1] = a;
                    ordenado[2] = c;
                }
                else {
                    ordenado[1] = c;
                    ordenado[2] = a;
                }
            }
            else if (c > a && c > b) {
                ordenado[0] = c;
                if (a > b) {
                    ordenado[1] = a;
                    ordenado[2] = b;
                }
                else {
                    ordenado[1] = b;
                    ordenado[2] = a;
                }
            }
        }
        return ordenado;
    }
}   