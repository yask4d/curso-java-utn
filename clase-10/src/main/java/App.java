import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class App {
    private static final String CHAT_FILE = "C:\\Users\\Kadyr Valdes\\Documents\\curso-java-utn\\clase-10\\src\\main\\resources\\chat.txt";
    private static final String READ_OPTION = "1";
    private static final String WRITE_OPTION = "2";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        String name = scanner.nextLine();

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Seleccione una opción:");
            System.out.println("1 - Leer mensajes");
            System.out.println("2 - Escribir mensaje");
            System.out.println("3 - Salir");
            String option = scanner.nextLine();

            switch (option) {
                case READ_OPTION:
                    readMessages();
                    break;
                case WRITE_OPTION:
                    System.out.println("Escriba su mensaje:");
                    String message = scanner.nextLine();
                    writeMessage(name, message);
                    break;
                default:
                    keepRunning = false;
            }
        }
        scanner.close();
    }

    private static void readMessages() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(CHAT_FILE)));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeMessage(String name, String message) {
        String formattedMessage = name + ": " + message + System.lineSeparator();
        try (FileWriter fw = new FileWriter(CHAT_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.print(formattedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
