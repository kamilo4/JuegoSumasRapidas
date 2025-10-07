import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Ranking ranking = new Ranking();

        boolean seguir = true;

        while (seguir) {
            System.out.println("=== JUEGO DE SUMAS RÁPIDAS ===");
            System.out.print("Ingrese su nombre de usuario: ");
            String nombre = sc.nextLine();

            int puntaje = 0;
            int tiempo = 10;
            boolean sigueJugando = true;
            int nivel = 1;

            while (sigueJugando) {
                System.out.println("\n--- Nivel " + nivel + " ---");
                System.out.println("Tiempo por suma: " + tiempo + " segundos");

                for (int i = 0; i < 5; i++) {
                    int a = rand.nextInt(50) + 1;
                    int b = rand.nextInt(50) + 1;
                    int resultado = a + b;

                    System.out.print(a + " + " + b + " = ");

                    long inicio = System.currentTimeMillis();
                    String entrada = sc.nextLine();
                    long fin = System.currentTimeMillis();

                    long tiempoUsado = (fin - inicio) / 1000;

                    // Validar tiempo
                    if (tiempoUsado > tiempo) {
                        System.out.println("⏰ ¡Se acabó el tiempo!");
                        sigueJugando = false;
                        break;
                    }

                    // Validar número
                    int respuesta;
                    try {
                        respuesta = Integer.parseInt(entrada);
                    } catch (Exception e) {
                        System.out.println("❌ Entrada inválida. Fin del juego.");
                        sigueJugando = false;
                        break;
                    }

                    // Verificar resultado
                    if (respuesta == resultado) {
                        puntaje += 100;
                        System.out.println("✅ Correcto! +" + 100 + " puntos");
                    } else {
                        System.out.println("❌ Incorrecto. Era " + resultado);
                        sigueJugando = false;
                        break;
                    }
                }

                if (sigueJugando) {
                    nivel++;
                    tiempo -= 2;
                    if (tiempo <= 0) tiempo = 2;
                    System.out.println("Subes al nivel " + nivel + "!");
                }
            }

            System.out.println("\nPuntaje final: " + puntaje);
            ranking.agregar(new Jugador(nombre, puntaje));
            ranking.mostrar();

            System.out.print("¿Desea jugar otra vez? (s/n): ");
            String opcion = sc.nextLine();
            if (!opcion.equalsIgnoreCase("s")) {
                seguir = false;
            }
        }

        System.out.println("\nGracias por jugar!");
        sc.close();
    }
}
