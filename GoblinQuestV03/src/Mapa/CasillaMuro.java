package Mapa;

import Personajes.Protagonista;
import java.io.Serializable;

/**
 *
 * @author Diurno
 */
public class CasillaMuro extends Casilla implements Serializable {

    public CasillaMuro(int id) {
        super(id);

    }

    @Override
    public void evento(Protagonista mc) {
        System.out.println("Topaste contra un muro!");
        mc.revertirMovimiento();
    }

}
