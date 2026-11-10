package taquilla.modelo;

/**
 * Boleta vendida: guarda el evento, la localidad, el comprador y el valor pagado.
 * El numero es consecutivo y lo genera un contador static compartido por todas las boletas.
 */
public class Boleta {

    private static int contador = 0; // atributo de clase (static)

    private int numero;
    private Evento evento;
    private Localidad localidad;
    private Comprador comprador;
    private double valorPagado;

    /**
     * La clase de servicio (Taquilla) debe verificar antes que evento, localidad
     * y comprador no sean null y que la venta se haya hecho con localidad.vender().
     */
    public Boleta(Evento evento, Localidad localidad, Comprador comprador, double valorPagado) {
        contador++;
        this.numero = contador;
        this.evento = evento;
        this.localidad = localidad;
        this.comprador = comprador;
        this.valorPagado = valorPagado >= 0 ? valorPagado : 0;
    }

    public int getNumero() { return numero; }
    public Evento getEvento() { return evento; }
    public Localidad getLocalidad() { return localidad; }
    public Comprador getComprador() { return comprador; }
    public double getValorPagado() { return valorPagado; }

    @Override
    public String toString() {
        return "Boleta #" + numero
                + " | Evento: " + evento.getNombre()
                + " | Localidad: " + localidad.getNombre()
                + " | Comprador: " + comprador.getNombre()
                + " | Pagado: $" + valorPagado;
    }
}
