public class Ranking {
    private Jugador cabeza;
    private Jugador cola;
    private int tamano;

    public Ranking() {
        cabeza = null;
        cola = null;
        tamano = 0;
    }

    public void agregar(Jugador nuevo) {
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            tamano = 1;
        } else {
            Jugador actual = cabeza;
            while (actual != null && nuevo.puntaje <= actual.puntaje) {
                actual = actual.siguiente;
            }

            if (actual == cabeza) { // Insertar al inicio
                nuevo.siguiente = cabeza;
                cabeza.anterior = nuevo;
                cabeza = nuevo;
            } else if (actual == null) { // Insertar al final
                cola.siguiente = nuevo;
                nuevo.anterior = cola;
                cola = nuevo;
            } else { // Insertar en medio
                nuevo.siguiente = actual;
                nuevo.anterior = actual.anterior;
                actual.anterior.siguiente = nuevo;
                actual.anterior = nuevo;
            }
            tamano++;
        }

        // Mantener solo los 5 mejores
        if (tamano > 5) {
            cola = cola.anterior;
            cola.siguiente = null;
            tamano--;
        }
    }

    public void mostrar() {
        System.out.println("\n=== RANKING DE LOS 5 MEJORES ===");
        Jugador actual = cabeza;
        int pos = 1;
        while (actual != null) {
            System.out.println(pos + ". " + actual);
            actual = actual.siguiente;
            pos++;
        }
        if (cabeza == null) {
            System.out.println("No hay jugadores aún.");
        }
        System.out.println("===============================\n");
    }
}
