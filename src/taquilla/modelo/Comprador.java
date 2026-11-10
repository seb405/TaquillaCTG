package taquilla.modelo;

/**
 * Persona que compra boletas.
 */
public class Comprador {

    private String documento = "Sin documento";
    private String nombre = "Sin nombre";
    private int edad = 18;

    // Constructor con validacion (usa los setters)
    public Comprador(String documento, String nombre, int edad) {
        setDocumento(documento);
        setNombre(nombre);
        setEdad(edad);
    }

    public String getDocumento() { return documento; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    public void setDocumento(String documento) {
        if (documento != null && !documento.trim().isEmpty()) {
            this.documento = documento.trim();
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
    }

    public void setEdad(int edad) {
        if (edad > 0 && edad <= 120) {
            this.edad = edad;
        }
    }

    @Override
    public String toString() {
        return nombre + " (Doc: " + documento + ", Edad: " + edad + ")";
    }
}
