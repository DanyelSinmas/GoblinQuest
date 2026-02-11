package Mapa;

import Personajes.Protagonista;
import Textos.Historia;
import java.io.Serializable;

/**
 *
 * @author Diurno
 */
public class CasillaHistoria extends Casilla implements Serializable {

    private String historiaCasilla;
    private boolean primeraVez;

    Historia historia = new Historia();

    public CasillaHistoria(int id, int historiaI) {
        super(id);
        this.historiaCasilla = historia.getTextoHistoria(historiaI);
    }

    @Override
    public void evento(Protagonista mc) {
        if (this.primeraVez == false) {
            System.out.println(this.historiaCasilla);
            this.primeraVez = true;
        } else {
            //nada
        }

    }

}
