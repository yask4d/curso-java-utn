public class ejercicio_1 {
    public static void main(String[] args) {        
        int[] ordenado = orderNumbers(41, 22, 11, "d"); // a = ascendent, d = descendent
        for (int i = 0; i < ordenado.length; i++) {
            System.out.print(ordenado[i] + " ");
        }        
    }
    
    public static int[] orderNumbers(int a, int b, int c, String orden) {
        int[] ordenado = new int[3];
        if (orden.equals("a")) {
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
        else if (orden.equals("d")) {
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
