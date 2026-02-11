package Objetos;

import Personajes.Protagonista;
import java.io.Serializable;

/**
 * Objeto que cura 25 de vida
 * @author Daniel MP
 */
public class ObjetoCura extends Objeto implements Serializable{

    public ObjetoCura(String nombreObjeto) {
        super(nombreObjeto);
    }

   
    public String getNombre() {
        return nombreObjeto;
    }

    public void setNombre(String nombre) {
        this.nombreObjeto = nombre;
    }
    
    public ObjetoCura() {
        super(""); // Valores por defecto
    }
 
    public void accionObjeto(Protagonista usador) {
        System.out.println("Te curas 30 de vida!");
        this.usador.setVida(this.usador.getVida() + 30);
        if(this.usador.getVida() > this.usador.getVidaMax()){
            this.usador.setVida(this.usador.getVidaMax());
        }
    }

}
