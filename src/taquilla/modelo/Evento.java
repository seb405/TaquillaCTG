package taquilla.modelo;

/**
 * Evento cultural (concierto, obra, festival) con sus localidades.
 * Las localidades se guardan en un arreglo de tamano fijo con un contador.
 */
public class Evento {

    public static final int MAX_LOCALIDADES = 3;

    private String codigo = "Sin codigo";
    private String nombre = "Sin nombre";
    private String fecha = "Sin fecha";
    private String lugar = "Sin lugar";
    private Localidad[] localidades = new Localidad[MAX_LOCALIDADES];
    private int numLocalidades = 0;

    // Constructor con validacion (usa los setters)
    public Evento(String codigo, String nombre, String fecha, String lugar) {
        setCodigo(codigo);
        setNombre(nombre);
        setFecha(fecha);
        setLugar(lugar);
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getFecha() { return fecha; }
    public String getLugar() { return lugar; }
    public int getNumLocalidades() { return numLocalidades; }

    /** Devuelve la localidad de la posicion indicada, o null si no existe. */
    public Localidad getLocalidad(int posicion) {
        if (posicion >= 0 && posicion < numLocalidades) {
            return localidades[posicion];
        }
        return null;
    }

    // Setters con validacion
    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty()) {
            this.codigo = codigo.trim();
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
    }

    public void setFecha(String fecha) {
        if (fecha != null && !fecha.trim().isEmpty()) {
            this.fecha = fecha.trim();
        }
    }

    public void setLugar(String lugar) {
        if (lugar != null && !lugar.trim().isEmpty()) {
            this.lugar = lugar.trim();
        }
    }

    // Metodos de negocio
    /** Agrega una localidad si hay espacio y no esta repetida. */
    public boolean agregarLocalidad(Localidad l) {
        if (l == null || numLocalidades >= MAX_LOCALIDADES) {
            return false;
        }
        if (buscarLocalidad(l.getNombre()) != null) {
            return false; // ya existe una localidad con ese nombre
        }
        localidades[numLocalidades] = l;
        numLocalidades++;
        return true;
    }

    /** Busca una localidad por nombre (sin distinguir mayusculas). Devuelve null si no existe. */
    public Localidad buscarLocalidad(String nombre) {
        if (nombre == null) {
            return null;
        }
        for (int i = 0; i < numLocalidades; i++) {
            if (localidades[i].getNombre().equalsIgnoreCase(nombre.trim())) {
                return localidades[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String texto = "[" + codigo + "] " + nombre + " | " + fecha + " | " + lugar
                + "\nLocalidades (" + numLocalidades + "/" + MAX_LOCALIDADES + "):";
        for (int i = 0; i < numLocalidades; i++) {
            texto += "\n  - " + localidades[i];
        }
        return texto;
    }
}
