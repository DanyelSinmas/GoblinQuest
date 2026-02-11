package Personajes;

import Herramientas.Login;
import java.io.Serializable;

/**
 * Clase la cual es el personaje que utiliza el jugador, implementa un sistema
 * de movimiento para poder interactuar con todo el tablero de juego
 *
 * @author Daniel MP
 */
public class Protagonista extends Personaje implements Serializable {

    private int posicionY, posicionX, piso;
    private int posicionAnteriorX, posicionAnteriorY;
    private Inventario inventarioProtagonista;

    public Protagonista(int posicionX, int posicionY, String nombre, int vida, int ataque, int agilidad, int defensa) {
        super(nombre, vida, ataque, agilidad, defensa);
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.piso = 0;
    }

    public void inspeccionar(Personaje rival) {
        System.out.println(super.toString());
    }

    public Inventario getInventarioProtagonista() {
        return inventarioProtagonista;
    }

    public void setInventarioProtagonista(Inventario inventarioProtagonista) {
        this.inventarioProtagonista = inventarioProtagonista;
    }

    public void guardarPosicion() {
        this.posicionAnteriorX = this.posicionX;
        this.posicionAnteriorY = this.posicionY;
    }

    public void revertirMovimiento() {
        this.posicionX = this.posicionAnteriorX;
        this.posicionY = this.posicionAnteriorY;
    }

    public void alante() {
        this.setPosicionY(this.getPosicionY() - 1);

    }

    public void atras() {
        this.setPosicionY(this.getPosicionY() + 1);
    }

    public void izquierda() {
        this.setPosicionX(this.getPosicionX() + 1);
    }

    public void derecha() {
        this.setPosicionX(this.getPosicionX() - 1);
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

}
