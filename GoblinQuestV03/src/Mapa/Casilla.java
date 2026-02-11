package Mapa;

import Personajes.Protagonista;
import java.io.Serializable;

public abstract class Casilla implements Serializable {
    
    private int id; 
    
    /**
     * Para diseñar las casillas se debe programar en su clase todos los objetos 
     * que puede llegar a contener (todos los enemigos ene CasillaCombate por ejemplo)
     * 
     * A la casilla habrá que pasarla dos parámetros,
     * su id (guia unicamente para numerar y hacer la matriz) y
     * en caso de que lo requiera, un indice para elegir que objetos de la coleccion usar.
     * 
     * @param id 
     */

    public Casilla(int id) {
        this.id = id;
    }
     
    public abstract void evento(Protagonista mc);
    
    

}
