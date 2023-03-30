public class clase3Ejercicio2 {
    // main
    public static void main(String[] args) {
        // codificar una cadena con un desplazamiento de 1 caracter hacia la derecha, y teniendo en cuenta que la z se convierte en a
         String texto = "Hola que talz";
            String textoCodificado = "";
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == 'z') {
                    textoCodificado += 'a';
                }
                else {
                    textoCodificado += (char) (texto.charAt(i) + 1);
                }
            }
            System.out.println(textoCodificado);
        // codificar una cadena con un desplazamiento de 2 caracter hacia la derecha, y teniendo en cuenta que la y se convierte en a y la z se convierte en b  
        String texto2 = "Hola que talz";
            String textoCodificado2 = "";
            for (int i = 0; i < texto2.length(); i++) {
                if (texto2.charAt(i) == 'y') {
                    textoCodificado2 += 'a';
                }
                else if (texto2.charAt(i) == 'z') {
                    textoCodificado2 += 'b';
                }
                else {
                    textoCodificado2 += (char) (texto2.charAt(i) + 2);
                }
            }
            System.out.println(textoCodificado2);



     
    }
}
