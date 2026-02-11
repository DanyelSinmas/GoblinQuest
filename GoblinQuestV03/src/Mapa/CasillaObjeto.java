package Mapa;

import Personajes.Protagonista;
import MainGame.Main;
import Objetos.*;
import java.io.Serializable;

/**
 *
 * @author Diurno
 */
public class CasillaObjeto extends Casilla implements Serializable{

    ColeccionObjetos objetos = new ColeccionObjetos();
    private int objetoI;
    private Objeto objetoCasilla;
    private boolean primeraVez = true;

    public CasillaObjeto(int id, int objetoI) {
        super(id);
        this.objetoCasilla = objetos.getObjetos(objetoI);
    }

    public void evento(Protagonista mc) {
        if (primeraVez == true) {
            System.out.println("Encontraste el objeto " + this.objetoCasilla.getNombreObjeto());
            mc.getInventarioProtagonista().aniadirObjeto(objetoCasilla);
            this.primeraVez = false;
        } else {
            System.out.println("Ya cogiste " + this.objetoCasilla.getNombreObjeto());
        }

    }

}
