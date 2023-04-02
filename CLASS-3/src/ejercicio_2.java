public class ejercicio_2 {
    // main
    public static void main(String[] args) {
        // codificar una cadena con un desplazamiento de 1 caracter hacia la derecha, y teniendo en cuenta que la z se convierte en a
        String cadenaOriginal = "Hola xyz que tal";
        System.out.println("Cadena original: " + cadenaOriginal);
        System.out.println("Desplazamiento en 1 a la derecha: " + codificar1(cadenaOriginal));
        System.out.println("Desplazamiento en 2 a la derecha: " + codificar2(cadenaOriginal));        
    } 
    
     public static String codificar1(String texto) {
        String textoCodificado = "";
        int desplazamiento = 1;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (caracter == 'z') {
                caracter = 'a';
            }
            // dejar igual el caracter si es un espacio
            else if (caracter == ' ') {
                caracter = ' ';
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
            else if (caracter == ' ') {
                caracter = ' ';
            }
            else {                
                caracter = (char) (caracter + desplazamiento);
            }
            textoCodificado = textoCodificado + caracter;
        }
        return textoCodificado;    
    }
    }

