package Objetos;

import Combate.Combate;
import Personajes.Protagonista;
import java.io.Serializable;

/**
 * Objeto que mejora el ataque
 * @author Daniel MP
 */
public class ObjetoAtaque extends Objeto {
    
    public ObjetoAtaque(String nombre) {
        super("Objeto ataque");
    }
    
    @Override
    public void accionObjeto(Protagonista usador) {
        System.out.println("Mejoraste el ataque del protagonistaª!");
        usador.setAtaque(usador.getAtaque() + 5);
    }
    
}
