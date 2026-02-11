package Personajes;

import MainGame.Main;
import java.io.Serializable;

/**
 * Clase que sirve como molde para construir diferentes personajes dentro del juego
 * 
 * @author Daniel MP
 */
public abstract class Personaje implements Serializable{

    private String nombre;
    private int vida;
    private int vidaMax;
    private int ataque;
    private int agilidad;
    private int defensa;

    public Personaje(String nombre, int vida, int ataque, int agilidad, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.agilidad = agilidad;
        this.defensa = defensa;
        this.vidaMax = vida;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void atacar(Personaje victima) {
        int danio = this.ataque - victima.getDefensa();
        Main.esperar(1);
        if(danio <= 0){
            System.out.println("El ataque fue inutil!");
        }else{
            System.out.println(this.getNombre() + " ataca!");
           System.out.println(victima.getNombre() + " pierde " + danio + " de vida!");
        victima.setVida(victima.getVida() - danio); 
        }
        
    }

    public void defender(){
        System.out.println( this.getNombre() + " se defiende!");
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getVidaMax(){
        return vidaMax;
    }
    

    @Override
    public String toString() {
        return "Datos de: " + this.nombre + "\n"
                + "Vida: [" + this.vida + "/" + this.getVidaMax() + "]";
    }

}
