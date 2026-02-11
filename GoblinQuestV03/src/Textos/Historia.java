package Textos;

import MainGame.Main;
import java.io.Serializable;

/**
 * Clase que se pretende sustituir por un fichero que contenga todos los textos
 * de la historia del juego
 *
 * @author Daniel Mp
 */
public class Historia implements Serializable {

    private String[] textoHistoria = new String[3];

    public Historia() {
        textoHistoria[0] = "Vives al fondo de una cueva junto a tu tribu de goblins. Hoy te toca salir a por suministros de agua, pero algo sucede...";
        textoHistoria[1] = "";
        textoHistoria[2] = "Derrotaste a la expedicion de los humanos y los sobrevivientes huyeron,\ntrayendo de nuevo paz a la cueva... ademas pudiste reunir el suministro de agua!";
    }

    public String getTextoHistoria(int indice) {
        return textoHistoria[indice];
    }

}
