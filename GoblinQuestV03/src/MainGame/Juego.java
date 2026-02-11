package MainGame;

import Mapa.Mapa;
import Personajes.Protagonista;
import Herramientas.*;
import Personajes.*;
import Textos.Historia;
import java.util.Scanner;

/**
 * Clase que maneja el bucle principal del juego
 *
 * @author Daniel MP
 */
public class Juego {

    /**
     * Este metodo es en sí la parte jugable
     */
    LogDeErrores log = new LogDeErrores();
    Scanner reader = new Scanner(System.in);
    Protagonista mc = new Protagonista(1, 0, "jugador 1", 100, 70, 8, 12);
    Inventario inventarioProtagonista = new Inventario();
    Historia h = new Historia();
    Mapa mapaJuego = new Mapa();
    RegistradorBBDD db = new RegistradorBBDD();
    Guardado g = new Guardado();

    public void jugar() {
        mc.setInventarioProtagonista(inventarioProtagonista);
        //instanciación necesaria de objetos

        //variables
        boolean cicloJuego = true;
        char direccion = '\u0000';
        int opcion = 0;

        try {
            if (Login.sesionIniciada == true) {
                mc.setNombre(Login.nombreUser);
            }
            System.out.println("Comienza la aventura en goblin quest!");
            mc.setPiso(0);
            mc.setPosicionX(8); //posicion de inicio del juego
            mc.setPosicionY(8);
            while (cicloJuego == true) { //bucle del juego en si
                mc.guardarPosicion();
                mc.inspeccionar(mc);
                mapaJuego.mostrarMapa(mc);
                System.out.println("---------------------------");
                System.out.println("A: IZQUIERDA, D: DERECHA, W: ARRIBA, S: ABAJO\nI: Comprobar inventario\nX: Salir");
                if (Login.sesionIniciada == true) {
                    System.out.println("G: Guardar partida C: Cargar partida");
                }
                direccion = reader.next().toLowerCase().charAt(0);
                if (Login.sesionIniciada) {
                    db.registradorPasos();
                }
                switch (direccion) {
                    case 'd':
                        mc.izquierda();
                        break;
                    case 'a':
                        mc.derecha();
                        break;
                    case 'w':
                        mc.alante();
                        break;
                    case 's':
                        mc.atras();
                        break;
                    case 'i':
                        mc.getInventarioProtagonista().mostrarInventario(mc);
                        break;
                    case 'g':
                        g.guardar(mc, mapaJuego);
                        break;
                    case 'c':
                        if (Login.sesionIniciada == true) {

                            System.out.println("Que archivo quieres cargar?");
                            System.out.println("1: Archivo 1  " + "2: Archivo 2");
                            opcion = reader.nextInt();
                            if (opcion == 1) {
                                mc = (Protagonista) (g.cargar(1)[0]);
                                mapaJuego = (Mapa) (g.cargar(1)[1]);
                            } else {
                                mc = (Protagonista) (g.cargar(2)[0]);
                                mapaJuego = (Mapa) (g.cargar(2)[1]);
                            }
                        } else {
                            System.out.println("Para cargar debes iniciar sesion");
                        }

                        break;
                    case 'x':
                        cicloJuego = false;
                }
                System.out.println("\nCaja de mensajes:");
                System.out.println("---------------------------");
                mapaJuego.ejecutarCasilla(mc);
                System.out.println("---------------------------");

                if (mc.getPosicionX() == 4 && mc.getPosicionY() == 9) {
                    Main.esperar(2);
                    System.out.println("Enhorabuena por completar el juego!");
                    Main.esperar(1);
                    System.out.println("Espero que lo hayas disfrutado...");
                    Main.esperar(1);
                    System.out.println("Hasta luego!");
                    Main.esperar(2);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            log.registradorErrores(" " + e);
        }

    }

}
