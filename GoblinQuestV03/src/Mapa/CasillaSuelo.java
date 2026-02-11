/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapa;

import Personajes.Protagonista;
import java.io.Serializable;

/**
 *
 * @author Diurno
 */
public class CasillaSuelo extends Casilla implements Serializable{

    public CasillaSuelo(int id) {
        super(id);
    }



    @Override
    public void evento(Protagonista mc) {
        //nada
    }
    
}
