public class clase3Ejercicio2 {
    // main
    public static void main(String[] args) {
        // codificar una cadena con un desplazamiento de 1 caracter hacia la derecha, y teniendo en cuenta que la z se convierte en a
        System.out.println(codificar1("holax yzz")); 
        System.out.println(codificar2("hola xyz"));
    } 
    
     public static String codificar1(String texto) {
        String textoCodificado = "";
        int desplazamiento = 1;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (caracter == 'z') {
                caracter = 'a';
            }
            else {
                caracter = (char) (caracter + desplazamiento);
            }
            textoCodificado = textoCodificado + caracter;
        }
        return textoCodificado;    
    }
    
    public static String codificar2(String texto) {
        String textoCodificado = "";
        int desplazamiento = 2;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (caracter == 'y') {
                caracter = 'a';
            }
            else if (caracter == 'z') {
                caracter = 'b';
            }
            else {                
                caracter = (char) (caracter + desplazamiento);
            }
            textoCodificado = textoCodificado + caracter;
        }
        return textoCodificado;    
    }
    }

