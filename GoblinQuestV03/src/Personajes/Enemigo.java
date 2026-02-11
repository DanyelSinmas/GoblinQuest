

package Personajes;

import java.io.Serializable;

/**
 * Clase hija de Personaje para crear enemigos
 * @author Daniel Mp
 */
public class Enemigo extends Personaje implements Serializable{

    public Enemigo(String nombre, int vida, int ataque, int agilidad, int defensa) {
        super(nombre, vida, ataque, agilidad, defensa);
    }
    
    public void mostrarDialogo(){
        //programar con un lector de archivos
    }

}
