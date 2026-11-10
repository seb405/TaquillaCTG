package taquilla.modelo;

/**
 * Localidad de un evento (por ejemplo: Palco, Preferencial, General).
 * Es la clase que controla el aforo y evita la sobreventa.
 */
public class Localidad {

    // 1. Atributos privados (encapsulamiento)
    private String nombre = "Sin nombre";
    private double precio = 0;
    private int aforo = 1;
    private int vendidas = 0;

    // 2. Constructor: usa los setters para reutilizar la validacion.
    //    Si un dato no es valido, se conserva el valor por defecto.
    public Localidad(String nombre, double precio, int aforo) {
        this.vendidas = 0;
        setNombre(nombre);
        setPrecio(precio);
        setAforo(aforo);
    }

    // 3. Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getAforo() { return aforo; }
    public int getVendidas() { return vendidas; }

    // 4. Setters con validacion (vendidas NO tiene setter: solo cambia con vender/liberar)
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        }
    }

    public void setAforo(int aforo) {
        // El aforo debe ser positivo y no puede quedar por debajo de lo ya vendido
        if (aforo > 0 && aforo >= vendidas) {
            this.aforo = aforo;
        }
    }

    // 5. Metodos de negocio
    public boolean hayCupo(int cantidad) {
        return cantidad > 0 && vendidas + cantidad <= aforo;
    }

    public boolean vender(int cantidad) {
        if (!hayCupo(cantidad)) {
            return false;
        }
        vendidas += cantidad;
        return true;
    }

    /** Devuelve cupos a la localidad (se usa al cancelar una boleta). */
    public boolean liberar(int cantidad) {
        if (cantidad <= 0 || cantidad > vendidas) {
            return false;
        }
        vendidas -= cantidad;
        return true;
    }

    public double ocupacion() {
        return vendidas * 100.0 / aforo;
    }

    @Override
    public String toString() {
        return nombre + " | Precio: $" + precio + " | Aforo: " + aforo
                + " | Vendidas: " + vendidas
                + " | Ocupacion: " + String.format("%.1f", ocupacion()) + "%";
    }
}
