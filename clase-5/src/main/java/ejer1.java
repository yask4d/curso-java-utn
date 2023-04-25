import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ejer1 {
    public static void main(String[] args) {
        String productosFile = "c:/Users/Kadyr Valdes/Documents/curso-java-utn/clase-5/src/main/java/productos.txt";
        List<Producto> productos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(productosFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\s+");
                double precioUnitario = Double.parseDouble(values[0]);
                String producto = values[1];
                String codigo = values[2];
                productos.add(new Producto(producto, precioUnitario));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Carrito carrito = new Carrito();
        for (Producto producto : productos) {
            carrito.agregarProducto(producto);
        }

        System.out.println("El costo final del carrito es: " + carrito.calcularTotal());
    }
}
