package Mapa;

import Textos.Dialogo;
import Personajes.Protagonista;
import java.io.Serializable;

public class CasillaDialogo extends Casilla implements Serializable {

    Dialogo dialogos = new Dialogo();
    private boolean primeraVez = false;
    private String dialogoCasilla;
    private int dialogoI;

    public CasillaDialogo(int id, int dialogoI) {
        super(id);
        this.dialogoCasilla = dialogos.getTextoDialogo(dialogoI);
    }

    @Override
    public void evento(Protagonista mc) {
        if (this.primeraVez == false) {
            System.out.println(dialogoCasilla);
            this.primeraVez = true;
        } else {
            //nada
        }

    }

}
