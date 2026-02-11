package Personajes;

import Objetos.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Herramientas.LogDeErrores;

/**
 * Clase para manejar el inventario del protagonista, este se añade como
 * agregacion y representa un arraylist de objetos
 *
 * @author Daniel MP
 */
public class Inventario implements Serializable {

    final int CAPACIDAD_MAXIMA = 5;
    private List<Objeto> listaObjetos;
    LogDeErrores log = new LogDeErrores();

    public Inventario() {
        this.listaObjetos = new ArrayList<>(CAPACIDAD_MAXIMA);
    }

    public void aniadirObjeto(Objeto objetoMeter) {
        if (listaObjetos.size() >= CAPACIDAD_MAXIMA) {
            System.out.println("No queda espacio en el inventario!");
            return;
        }
        listaObjetos.add(objetoMeter);
    }

    public boolean removerObjeto(Objeto objetoRemover) {
        return listaObjetos.remove(objetoRemover);
    }

    public Objeto removerObjeto(int indice) {
        if (indice >= 0 && indice < listaObjetos.size()) {
            return listaObjetos.remove(indice);
        }
        return null;
    }

    public int getCantidadObjetos() {
        return listaObjetos.size();
    }

    public int getCapacidadMaxima() {
        return CAPACIDAD_MAXIMA;
    }

    public List<Objeto> getInventario() {
        return new ArrayList<>(listaObjetos);
    }

    public Objeto getObjeto(int indice) {
        if (indice >= 0 && indice < listaObjetos.size()) {
            return listaObjetos.get(indice);
        }
        return null;
    }

    public void mostrarInventario(Protagonista usador) {
        int contador = 0;
        int opcion = 0;
        Scanner reader = new Scanner(System.in);

        try {
            do {
                if (this.listaObjetos.isEmpty()) {
                    System.out.println("No tienes objetos...");
                    return;
                } else {
                    System.out.println("Lista de objetos: ");
                    for (Objeto obj : listaObjetos) {
                        contador++;
                        System.out.println(contador + ". " + obj.getNombreObjeto());
                    }
                    System.out.println("Quieres usar un objeto?\n1: Si\n2: no");
                    opcion = reader.nextInt();
                    if (opcion == 2) {
                        return;
                    } else {
                        System.out.println("Selecciona objeto (indice en la lista)");
                        opcion = reader.nextInt();
                        usarObjeto((opcion - 1), usador);
                        break;
                    }
                }

            } while (true);

        } catch (Exception e) {
            log.registradorErrores(" " + e);
        }

    }

    public void usarObjeto(int indice, Protagonista usador) {
        System.out.println("Se uso el objeto " + this.getObjeto(indice).getNombreObjeto() + "!");
        this.listaObjetos.get(indice).setUsador(usador);
        this.listaObjetos.get(indice).accionObjeto(usador);
        this.removerObjeto(indice);
    }

    public void copiarEstado(Inventario otroInventario) {
        // Reemplazamos completamente la lista con una copia de la del otro inventario
        this.listaObjetos = new ArrayList<>(otroInventario.getInventario());
    }

}
