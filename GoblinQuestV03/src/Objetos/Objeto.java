

package Objetos;

import Personajes.Protagonista;
import java.io.Serializable;

/**
 * Clase abstracta que sirve como molde de otros objetos
 * @author Daniel MP
 */
public abstract class Objeto implements Serializable{
    
    String nombreObjeto;
    Protagonista usador;

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public Objeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
        this.usador = usador;
    }

    public Protagonista getUsador() {
        return usador;
    }

    public void setUsador(Protagonista usador) {
        this.usador = usador;
    }
    
    /**
     * Metodo que permite al objeto interactuar con quien lo use
     * @param usador 
     */
    public abstract void accionObjeto(Protagonista usador);

}
