package Personajes;

import java.io.Serializable;

/**
 *
 * @author Daniel MP
 *
 * Clase que se pretende sustituir por un archivo que ya tenga los datos de los
 * diferentes enemigos para evitar instanciaciones innecesarias.
 */
public class ColeccionEnemigos implements Serializable {

    private Enemigo[] enemigos = new Enemigo[13];

    public ColeccionEnemigos() {
        enemigos[0] = new Enemigo("Guerrero debil", 70, 20, 3, 13);
        enemigos[1] = new Enemigo("Espadachin furioso", 90, 30, 7, 20);
        enemigos[2] = new Enemigo("Asesino cauteloso", 60, 10, 15, 30);
        enemigos[3] = new Enemigo("Guerrero mediocre", 80, 30, 5, 35);
        enemigos[4] = new Enemigo("Capataz audaz", 100, 30, 7, 50);
        enemigos[5] = new Enemigo("Daguero cautero", 75, 35, 15, 20);
        enemigos[6] = new Enemigo("Samurai (?)", 90, 30, 7, 50);
        enemigos[7] = new Enemigo("Guerrero capaz", 80, 25, 15, 40);
        enemigos[8] = new Enemigo("Guerrero poderoso", 100, 30, 7, 50);
        enemigos[9] = new Enemigo("Guerrero con Mayero", 100, 25, 7, 50);
        enemigos[10] = new Enemigo("Espadachin chin", 100, 30, 12, 50);
        enemigos[11] = new Enemigo("Escudero mero", 150, 15, 7, 50);
        enemigos[12] = new Enemigo("Capitan letal", 150, 30, 7, 55);
    }

    public Enemigo getEnemigos(int indice) {
        return enemigos[indice];
    }

}
