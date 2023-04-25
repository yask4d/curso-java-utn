import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java RegexMatcher <archivo> <expresion_regular>");
            System.exit(1);
        }

        String archivo = args[0];
        String expresionRegular = args[1];

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numeroLinea = 1;
            Pattern pattern = Pattern.compile(expresionRegular);

            while ((linea = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(linea);
                boolean coincide = matcher.matches();
                System.out.printf("Línea %d: %s\n", numeroLinea, coincide ? "Coincide" : "No coincide");
                numeroLinea++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
