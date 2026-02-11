package Combate;

import Personajes.Enemigo;
import Herramientas.RegistradorBBDD;
import Personajes.Protagonista;
import MainGame.Main;
import java.util.Scanner;
import Herramientas.LogDeErrores;
import Objetos.*;
import Herramientas.Login;

/**
 *
 * Esta clase se encarga de manejar los combates del juego
 *
 * @author Daniel MP
 */
public class Combate {

    private Enemigo rival;
    private Protagonista tuPersonaje;
    public static int turno;
    private int opcion = 0;
    Scanner reader = new Scanner(System.in);
    RegistradorBBDD db = new RegistradorBBDD();
    LogDeErrores log = new LogDeErrores();

    public Combate(Enemigo rival, Protagonista tuPersonaje) {
        this.rival = rival;
        this.tuPersonaje = tuPersonaje;
        this.turno = 0;
    }

    /**
     * En base a la agilidad de los personajes, se decide quien ataca primero
     *
     * @param rival
     * @param tuPersonaje
     */
    private void calcularTurno(Enemigo rival, Protagonista tuPersonaje) {
        if (this.rival.getAgilidad() > this.tuPersonaje.getAgilidad()) {
            this.turno++;
        } else {
            this.turno = 0;
        }
    }

    /**
     * Metodo para manejar las acciones de tu personaje durante su turno
     *
     * @param tuPersonaje
     */
    private void turno(Protagonista tuPersonaje) {
        boolean opcionValida = false;

        do {
            try {

                System.out.println("Que quieres hacer?");
                System.out.println("1-Atacar\n2-Usar Objeto");
                this.opcion = reader.nextInt();
                switch (opcion) {
                    case 1:
                        this.tuPersonaje.atacar(this.rival);
                        opcionValida = true;
                        break;
                    case 2:
                        tuPersonaje.getInventarioProtagonista().mostrarInventario(tuPersonaje);
                        opcionValida = false;
                }
            } catch (Exception e) {
                opcionValida = false;
                log.registradorErrores(" " + e);
                reader.nextLine();
            }

        } while (opcionValida == false);

    }

    /**
     * Metodo para manejar el turno del rival
     *
     * @param rival
     */
    private void turno(Enemigo rival) {
        //this.rival.mostrarDialogo(); //hay que programar lo de mostrar dialogos
        int accion = 1;
        //accion = (int) (Math.random() * 3) + 1;
        switch (accion) {
            case 1:
                this.rival.atacar(this.tuPersonaje);
                break;
            case 2:
                this.rival.defender(); //falta implementar la mecanica de defenderse durante un turno
                break;
            case 3:
                System.out.println("Se despista");
        }

    }

    /**
     * Este metodo se encarga de manejar lo que es la pelea en sí,
     *
     * @param rival
     * @param tuPersonaje
     */
    public void lucha(Enemigo rival, Protagonista tuPersonaje) {
        calcularTurno(this.rival, this.tuPersonaje);
        System.out.println("Comienza un combate!");
        Main.esperar(1);
        calcularTurno(this.rival, this.tuPersonaje);

        while (this.rival.getVida() > 0 || this.tuPersonaje.getVida() > 0) {
            if (this.turno % 2 == 0) {
                System.out.println("Es tu turno!");
                this.tuPersonaje.inspeccionar(this.tuPersonaje);
                Main.esperar(1);
                turno(this.tuPersonaje);
                System.out.println("----------------------------");
                Main.esperar(1);
            } else {
                System.out.println("Turno del enemigo!");
                System.out.println("Datos de: " + this.rival.getNombre());
                System.out.println("[" + this.rival.getVida() + "/" + this.rival.getVidaMax() + "]");
                Main.esperar(1);
                turno(this.rival);
                System.out.println("----------------------------");
                Main.esperar(1);
            }

            this.turno++;

            if (this.rival.getVida() <= 0) {
                if (Login.sesionIniciada == true) {
                    db.registradorBajas();
                }
                System.out.println("Ganaste!");
                break;
            } else if (this.tuPersonaje.getVida() <= 0) {
                if (Login.sesionIniciada == true) {
                    db.registradorMuertes();
                }
                System.out.println("Game over");
                Main.esperar(1);
                System.out.println("Adios");
                System.exit(0);
            }
        }

    }//fin lucha

}
