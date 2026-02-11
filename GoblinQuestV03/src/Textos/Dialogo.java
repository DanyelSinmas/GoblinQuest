package Textos;

import java.io.Serializable;

/**
 * Clase que se pretende sustituir por un archivo externo que contenga ya todos
 * los dialogos
 * @author User
 */
public class Dialogo implements Serializable {

    private String[] textoDialogo = new String[10];

    public Dialogo() {
        textoDialogo[0] = "Parece ser que la cueva esta siendo invadida, ten cuidado!\nToma la pocion de la sala contigua antes de continuar";
        textoDialogo[1] = "(Se oyen ruidos justo a la izquierda, procede con cuidado)";
        textoDialogo[2] = "Gracias por derrotar a ese humano, pero ten cuidado, parece ser que hay mas por ahi?";
        textoDialogo[3] = "(Se oyen ruidos justo al norte, procede con cuidado)";
        textoDialogo[4] = "Delante parece haber un humano fuerte, preparate bien!";
        textoDialogo[5] = "Se nota una presencia hostil en los alrededores...";
        textoDialogo[6] = "Mas adelante hay un objeto util custodiado por un humano";
        textoDialogo[7] = "Esto esta lleno de humanos! pero tambien de tesoros...";
        textoDialogo[8] = "Ya casi has llegado al final, si derrotas a su capitan, probablemente se vayan de la cueva";
        textoDialogo[9] = "Mas adelante parece estar el ultimo combate, preparate";
    }

    public String getTextoDialogo(int indice) {
        return textoDialogo[indice];
    }

}
