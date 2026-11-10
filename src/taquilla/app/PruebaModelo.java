package taquilla.app;

import taquilla.modelo.Boleta;
import taquilla.modelo.Comprador;
import taquilla.modelo.Evento;
import taquilla.modelo.Localidad;

/**
 * Main sencillo para probar las clases del modelo (Entrega 1).
 * El menu real de la aplicacion se hace en la Entrega 2.
 */
public class PruebaModelo {

    public static void main(String[] args) {
        // 1. Crear un evento con 3 localidades
        Evento concierto = new Evento("EV001", "Concierto de champeta", "2026-12-05", "Plaza de Toros");
        concierto.agregarLocalidad(new Localidad("Palco", 150000, 5));
        concierto.agregarLocalidad(new Localidad("Preferencial", 80000, 10));
        concierto.agregarLocalidad(new Localidad("General", 40000, 20));
        System.out.println(concierto);

        // 2. Crear un comprador
        Comprador lorena = new Comprador("1020304050", "Lorena Perez", 28);
        System.out.println("\nComprador: " + lorena);

        // 3. Vender boletas controlando el aforo
        Localidad palco = concierto.buscarLocalidad("Palco");
        System.out.println("\n--- Prueba de aforo en Palco (aforo 5) ---");
        System.out.println("Vender 3: " + palco.vender(3));   // true
        System.out.println("Vender 3: " + palco.vender(3));   // false (solo quedan 2)
        System.out.println("Vender 2: " + palco.vender(2));   // true
        System.out.println("Hay cupo para 1: " + palco.hayCupo(1)); // false
        System.out.println(palco);

        // 4. Crear una boleta
        Boleta boleta = new Boleta(concierto, palco, lorena, palco.getPrecio());
        System.out.println("\n" + boleta);

        // 5. Probar validaciones del constructor
        Localidad invalida = new Localidad("", -5, 0);
        System.out.println("\nLocalidad con datos invalidos -> " + invalida);
    }
}
