public class eje {
    public static void main(String[] args) {
        String[] separado = "3_tristes tigres_del_13".split("_");
        // imprime separado.length
        // imprime separado[0]
        System.out.println(separado[1]);
        System.out.println(separado.length);
        System.out.println("hola que tal?".toUpperCase().replace("hola","chau"));
        char letras[] = {'a','b','c','d'};

        int numeros[] = new int[]{1,37,16};

        for(int i=0;i<numeros.length;i++){

        if (numeros[i] < 30) {

        System.out.println(letras[i+1]);

        } else {

        System.out.println(numeros[i]);

        }

        }
        int numersss[] = new int[]{1,37,16};
        System.out.println(numersss[2]);

    }
}
