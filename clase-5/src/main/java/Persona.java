public class Persona {
    private String nombre;
    private Carrito carrito;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.carrito = new Carrito();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void agregarProductoAlCarrito(Producto producto) {
        carrito.agregarProducto(producto);
    }
}