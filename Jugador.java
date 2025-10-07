public class Jugador {
    String nombre;
    int puntaje;
    Jugador anterior;
    Jugador siguiente;

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.anterior = null;
        this.siguiente = null;
    }

    public String toString() {
        return nombre + " - " + puntaje + " puntos";
    }
}
