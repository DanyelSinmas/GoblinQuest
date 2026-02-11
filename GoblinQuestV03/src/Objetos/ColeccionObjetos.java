/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.Serializable;

/**
 *
 * @author Daniel MP
 * 
 * Clase que se pretende sustituir por un archivo que contenga los datos de los
 * objetos para evitar instanciaciones innecesarias
 */
public class ColeccionObjetos implements Serializable{
    
    private Objeto[] objetos = new Objeto[2];
    
    public ColeccionObjetos() {
        objetos[0] = new ObjetoCura("Pocion");
        objetos[1] = new ObjetoAtaque("Potenciador");
    }

    public Objeto getObjetos(int indice) {
        return objetos[indice];
    }
    
    
}
