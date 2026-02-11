package Mapa;

import Personajes.Protagonista;
import java.util.Scanner;
import Herramientas.LogDeErrores;
import java.io.Serializable;
import java.util.InputMismatchException;

public class CasillaEscalera extends Casilla implements Serializable {

    private int piso;
    private static final long serialVersionUID = 1L; 

    public CasillaEscalera(int id, int piso) {
        super(id);
        this.piso = piso;
    }

    @Override
    public void evento(Protagonista protagonista) {
        Scanner reader = new Scanner(System.in);
        int pisoActual = protagonista.getPiso();

        System.out.println("\n[Escalera] Piso actual: " + pisoActual);

        if (this.piso == 0) {

            if (pisoActual == 0) {
                System.out.println("1: Subir al piso 1");
                System.out.println("2: No hacer nada");
                System.out.print("Opcion: ");

                try {
                    int opcion = reader.nextInt();
                    if (opcion == 1) {
                        protagonista.setPiso(1);
                        System.out.println("Has subido al piso 1");
                    } else {
                        System.out.println("Sigues en el piso 0");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opción no válida");
                    reader.nextLine();
                }
            } else if (pisoActual == 1) {
                System.out.println("1: Bajar al piso 0");
                System.out.println("2: No hacer nada");
                System.out.print("Opcion: ");

                try {
                    int opcion = reader.nextInt();
                    if (opcion == 1) {
                        protagonista.setPiso(0);
                        System.out.println("Has bajado al piso 0");
                    } else {
                        System.out.println("Sigues en el piso 1");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opción no válida");
                    reader.nextLine();
                }
            }

        } else if (this.piso == 1) {

            if (pisoActual == 1) {
                System.out.println("1: Subir al piso 2");
                System.out.println("2: No hacer nada");
                System.out.print("Opción: ");

                try {
                    int opcion = reader.nextInt();
                    if (opcion == 1) {
                        protagonista.setPiso(2);
                        System.out.println("Has subido al piso 2");
                    } else {
                        System.out.println("Sigues en el piso 1");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opcion no válida");
                    reader.nextLine();
                }
            } else if (pisoActual == 2) {
                System.out.println("1: Bajar al piso 1");
                System.out.println("2: No hacer nada");
                System.out.print("Opcion: ");

                try {
                    int opcion = reader.nextInt();
                    if (opcion == 1) {
                        protagonista.setPiso(1);
                        System.out.println("Has bajado al piso 1");
                    } else {
                        System.out.println("Sigues en el piso 2");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opción no valida");
                    reader.nextLine();
                }
            }
        }
    }

}
