package Mapa;

import Personajes.Enemigo;
import Personajes.Protagonista;
import Combate.Combate;
import Personajes.ColeccionEnemigos;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Daniel MP
 */
public class CasillaCombate extends Casilla implements Serializable{

    //atributos  
    ColeccionEnemigos enemigos = new ColeccionEnemigos();
    private int enemigoI;
    private Enemigo enemigoCasilla;
    private boolean primeraVez = true;

    public CasillaCombate(int id, int enemigoI) {
        super(id);
        this.enemigoCasilla = enemigos.getEnemigos(enemigoI);
    }

    @Override
    public void evento(Protagonista mc) {

        if (primeraVez == true) {
            Combate combate = new Combate(enemigoCasilla, mc);
            combate.lucha(this.enemigoCasilla, mc);
            this.primeraVez = false;
        } else {
            System.out.println("Ya derrotaste a " + this.enemigoCasilla.getNombre());
        }

    }

}
